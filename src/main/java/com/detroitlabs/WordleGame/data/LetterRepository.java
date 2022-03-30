package com.detroitlabs.WordleGame.data;

import com.detroitlabs.WordleGame.model.CharacterBank;
import com.detroitlabs.WordleGame.service.WordGeneratorService;

import java.util.List;

public class LetterRepository { //generate word
    //break word into part of characters
    //check character with color response
    WordGeneratorService wordGeneratorService = new WordGeneratorService();
    List<CharacterBank> characterBanks;

    public LetterRepository() {
        String theWord = wordGeneratorService.getWord()[0];
        while(theWord.length() > 0) {
            String x = theWord.substring(0,1);
            characterBanks.add(new CharacterBank(x));
        }
    }




}
