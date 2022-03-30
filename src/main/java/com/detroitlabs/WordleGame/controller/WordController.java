package com.detroitlabs.WordleGame.controller;

import com.detroitlabs.WordleGame.data.LetterRepository;
import com.detroitlabs.WordleGame.model.WordBank;
import com.detroitlabs.WordleGame.service.WordGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.swing.*;

@Controller
public class WordController {
    private boolean secondGuessMade = false;

    @Autowired
    LetterRepository letterRepository;

    @RequestMapping("/")
    public String displayHome(ModelMap modelMap) {
        modelMap.put("CharBank", letterRepository.getCharacterBanks());
        modelMap.put("wordLength", letterRepository.getCharacterBanks().size());
        return "home";
    }

    @RequestMapping("/page2")
    public String displayPage2(@RequestParam String keyword, ModelMap modelMap) {
        modelMap.put("wordLength", letterRepository.getCharacterBanks().size());
        if (keyword.length() != letterRepository.getCharacterBanks().size()) {
            if (!secondGuessMade) {
                return "errorMismatch";
            } else {
                return "errorMismatchPage2";
            }
        }
        secondGuessMade=true;

        letterRepository.recordGuess(keyword);


        modelMap.put("userGuess", keyword);
        modelMap.put("CharBank", letterRepository.getCharacterBanks());
        modelMap.put("PriorGuesses",letterRepository.getPriorGuesses());
        return "page2";
    }

    @RequestMapping("/errorMismatch")
    public String displayError() {
        return "errorMismatch";
    }

    @RequestMapping("errorMismatchPage2")
    public String displayErrorAfterSecondGuess(ModelMap modelMap) {
        modelMap.put("wordLength", letterRepository.getCharacterBanks().size());
        return "errorMismatchPage2";
    }
}
