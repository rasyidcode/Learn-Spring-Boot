package com.rasyidcode.jdbcpractice.user;

import com.password4j.Password;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.dao.DuplicateKeyException;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@DataJdbcTest
public class UserRepositoryTest {

    @Autowired
    public UserRepository userRepository;

    @Test
    public void test_getAllUsers() {
        List<User> users = userRepository.findAll();
        assertThat(users).isNotEmpty();
        assertThat(users.size()).isEqualTo(6);
        assertThat(users.getFirst().getId()).isEqualTo(1);
        assertThat(users.getFirst().getUsername()).isEqualTo("dtrump");
    }

    @Test
    public void test_getUser_thenSuccess() {
        Optional<User> optionalUser = userRepository.findById(1);
        assertThat(optionalUser.isPresent()).isTrue();
        assertThat(optionalUser.get().getUsername()).isEqualTo("dtrump");
    }

    @Test
    public void test_getUser_thenIsNotFound() {
        Optional<User> optionalUser = userRepository.findById(69);
        assertThat(optionalUser.isEmpty()).isTrue();
    }

    @Test
    public void test_createNewUser_thenSucceed() {
        User user = userRepository.save(
                new User(
                        "alincoln",
                        Password.hash("12345").withBcrypt().getResult(),
                        "alincoln@example.com"
                )
        );
        assertThat(user.getId()).isNotNull();
        assertThat(user.getUsername()).isEqualTo("alincoln");
    }

    @Test
    public void test_createUserWithDuplicateUsername_thenFailed() {
        userRepository.save(
                new User(
                        "alincoln",
                        Password.hash("12345").withBcrypt().getResult(),
                        "alincoln@example.com"
                )
        );
        assertThatThrownBy(() -> userRepository.save(
                new User(
                        "alincoln",
                        Password.hash("12345").withBcrypt().getResult(),
                        "alincolnn@example.com"
                )
        )).hasCauseInstanceOf(DuplicateKeyException.class);
    }

    @Test
    public void test_createUserWithDuplicateEmail_thenFailed() {
        userRepository.save(
                new User(
                        "alincoln",
                        Password.hash("12345").withBcrypt().getResult(),
                        "alincoln@example.com"
                )
        );
        assertThatThrownBy(() -> userRepository.save(
                new User(
                        "alincolnn",
                        Password.hash("12345").withBcrypt().getResult(),
                        "alincoln@example.com"
                )
        )).hasCauseInstanceOf(DuplicateKeyException.class);
    }

    @Test
    public void test_updateUser_thenSucceed() {
        Optional<User> optionalUser = userRepository.findById(1);
        optionalUser.ifPresent(user -> {
            user.setUsername("troosevelt");
            user.setEmail("troosevelt@example.com");
            user.setPassword(Password.hash("secret").withBcrypt().getResult());
            User updatedUser = userRepository.save(user);

            assertThat(updatedUser.getUsername()).isEqualTo("troosevelt");
            assertThat(updatedUser.getEmail()).isEqualTo("troosevelt@example.com");
            assertThat(Password.check("secret", updatedUser.getPassword()).withBcrypt()).isTrue();
        });
    }

    @Test
    public void test_deleteUser_thenSucceed() {
        userRepository.deleteById(1);

        Optional<User> optionalUser = userRepository.findById(1);

        assertThat(optionalUser.isEmpty()).isTrue();
    }

    @Test
    public void test_checkUserPassword_isValid() {
        Optional<User> optionalUser = userRepository.findById(1);
        optionalUser.ifPresent(user ->
                assertThat(Password.check("12345", user.getPassword()).withBcrypt()).isTrue()
        );
    }

}
