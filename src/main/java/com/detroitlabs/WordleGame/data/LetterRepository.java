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
        do {
            theWord = wordGeneratorService.getWord()[0];
        } while (theWord.length() > 9);
        System.out.println(theWord);
        characterBanks = stringToCharBankList(theWord);
    }

    public ArrayList<CharacterBank> stringToCharBankList(String theWord) {
        ArrayList<CharacterBank> tempBank = new ArrayList<>();

        while (theWord.length() > 0) {
            String x = theWord.substring(0, 1);
            theWord = theWord.substring(1);
            tempBank.add(new CharacterBank(x));
        }

        return tempBank;
    }

    public void recordGuess(String newGuess) {
        ArrayList<CharacterBank> tempBank = new ArrayList<>();
        String coloredChars = "";


        for (int i = 0; i < newGuess.length(); i++) {
            if (newGuess.substring(i, i + 1).equals(theWord.substring(i, i + 1))) {
                System.out.println("One match");
                tempBank.add(new CharacterBank(newGuess.substring(i, i + 1), "#00FF00"));
                coloredChars = coloredChars + newGuess.substring(i, i + 1);
            } else {
                tempBank.add(new CharacterBank(newGuess.substring(i, i + 1)));
            }
        }
        for (int j = 0; j < newGuess.length(); j++) {
            if (!tempBank.get(j).getColor().equals("#00FF00")) {
                if (theWord.contains(newGuess.substring(j, j + 1)) && countOfChar(coloredChars, newGuess.substring(j, j + 1)) < countOfChar(theWord, theWord.substring(j, j + 1))) {
                    System.out.println("One contains");
                    tempBank.get(j).setColor("#FFFF00");
                    coloredChars = coloredChars + newGuess.substring(j, j + 1);
                }
            }
        }
        priorGuesses.add(tempBank);
    }

    public int countOfChar(String wordCheck, String theLetter) {
        int count = 0;
        for (int i = 0; i < wordCheck.length(); i++) {
            if (wordCheck.substring(i, i + 1).equals(theLetter)) {
                count++;
            }
        }
        return count;
    }


    public ArrayList<CharacterBank> getCharacterBanks() { // returns List
        return characterBanks;
    }

    public ArrayList<ArrayList<CharacterBank>> getPriorGuesses() {
        return priorGuesses;
    }

    public boolean winCheck(String keyword) {
        if(keyword.equals(theWord)) {
            return true;
        } else {
            return false;
        }
    }
}
