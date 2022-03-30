package com.detroitlabs.WordleGame.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public class WordBank {
    String[] randomWord;
//    List<String> randomWords;

    @JsonProperty("")
    public String[] getRandomWord() {
        return randomWord;
    }

    @JsonProperty("")
    public void setRandomWord(String[] randomWord) {
        this.randomWord = randomWord;
    }
}

//    @JsonProperty("")
//    public List<String> getRandomWords() {
//        return randomWords;
//    }
//
//    @JsonProperty("")
//    public void setRandomWords(List<String> randomWords) {
//        this.randomWords = randomWords;


