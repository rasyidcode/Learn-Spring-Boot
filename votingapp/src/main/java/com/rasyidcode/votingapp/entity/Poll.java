package com.rasyidcode.votingapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Poll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String question;

    @OneToMany(mappedBy = "poll", cascade = CascadeType.ALL)
    private List<Option> optionList;
}
