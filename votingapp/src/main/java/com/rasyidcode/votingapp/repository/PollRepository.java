package com.rasyidcode.votingapp.repository;

import com.rasyidcode.votingapp.entity.Poll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollRepository extends JpaRepository<Poll, Integer> {
}
