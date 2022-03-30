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

@Controller
public class WordController {

    @Autowired
    LetterRepository letterRepository;

    @RequestMapping("/")
    public String displayHome(ModelMap modelMap) {
        modelMap.put("CharBank", letterRepository.getCharacterBanks());
        modelMap.put("wordLength",letterRepository.getCharacterBanks().size());
        return "home";

    }

    @RequestMapping("/page2")
    public String displayPage2(@RequestParam String keyword, ModelMap modelMap){
        modelMap.put("userGuess", keyword);
        return "page2";
    }
}
