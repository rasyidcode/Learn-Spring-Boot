package com.rasyidcode.votingapp.service;

import com.rasyidcode.votingapp.entity.Option;
import com.rasyidcode.votingapp.repository.OptionRepository;
//import com.rasyidcode.votingapp.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionService {

//    @Autowired
//    private VoteRepository voteRepository;

    @Autowired
    public OptionRepository optionRepository;

    public List<Option> getAllOptions() {
        return optionRepository.findAll();
    }

    public void createVote(int optionId) {
        Option option = optionRepository.findById(optionId).orElseThrow();
        option.setVotes(option.getVotes() + 1);

        optionRepository.save(option);
    }

}
