package com.detroitlabs.WordleGame.data;

import com.detroitlabs.WordleGame.model.CharacterBank;
import com.detroitlabs.WordleGame.service.WordGeneratorService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LetterRepository { //generate word
    //break word into part of characters
    //check character with color response
    WordGeneratorService wordGeneratorService = new WordGeneratorService();
    ArrayList<CharacterBank> characterBanks = new ArrayList<>();

    public LetterRepository() {
        String theWord = wordGeneratorService.getWord()[0];
        System.out.println(theWord);
        while(theWord.length() > 0) {
            String x = theWord.substring(0,1);
            theWord = theWord.substring(1);
            characterBanks.add(new CharacterBank(x));
        }
    }

    public List<CharacterBank> getCharacterBanks() {
        return characterBanks;
    }
}
