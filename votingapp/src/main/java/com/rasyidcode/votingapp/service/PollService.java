package com.rasyidcode.votingapp.service;

import com.rasyidcode.votingapp.entity.Poll;
import com.rasyidcode.votingapp.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PollService {

    @Autowired
    private PollRepository pollRepository;

    public List<Poll> getAllPosts() {
        return pollRepository.findAll();
    }

    public Poll getPollById(int id) {
        return pollRepository.findById(id).orElseThrow();
    }

    public void createPoll(Poll poll) {
        pollRepository.save(poll);
    }


}
