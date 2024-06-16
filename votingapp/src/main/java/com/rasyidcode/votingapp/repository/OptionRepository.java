package com.rasyidcode.votingapp.repository;

import com.rasyidcode.votingapp.entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository extends JpaRepository<Option, Integer> {
}
