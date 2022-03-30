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
    ArrayList<ArrayList<CharacterBank>> priorGuesses = new ArrayList<>();
    String theWord;

    public LetterRepository() {
        theWord = wordGeneratorService.getWord()[0];
        System.out.println(theWord);
        characterBanks = stringToCharBankList(theWord);
    }

    public ArrayList<CharacterBank> stringToCharBankList(String theWord){
        ArrayList<CharacterBank> tempBank = new ArrayList<>();

        while(theWord.length() > 0) {
            String x = theWord.substring(0,1);
            theWord = theWord.substring(1);
            tempBank.add(new CharacterBank(x));
        }

        return tempBank;
    }

    public void recordGuess(String newGuess){
        ArrayList<CharacterBank> tempBank = new ArrayList<>();


        for(int i=0; i < newGuess.length(); i++){
            if(newGuess.substring(i,i+1).equals(theWord.substring(i,i+1))){
                System.out.println("One match");
                tempBank.add(new CharacterBank(newGuess.substring(i,i+1), "#00FF00"));
            } else {
                tempBank.add(new CharacterBank(newGuess.substring(i,i+1)));
            }
        }

        priorGuesses.add(tempBank);
    }

    public ArrayList<CharacterBank> getCharacterBanks() { // returns List
        return characterBanks;
    }

    public ArrayList<ArrayList<CharacterBank>> getPriorGuesses() {
        return priorGuesses;
    }
}
