package com.detroitlabs.WordleGame.controller;

import com.detroitlabs.WordleGame.model.WordBank;
import com.detroitlabs.WordleGame.service.WordGeneratorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WordController {
    WordGeneratorService wordGeneratorService = new WordGeneratorService();

    @ResponseBody
    @RequestMapping("/")
    public String displayWord() {
        WordBank wordBank = wordGeneratorService.getWord();
        System.out.println(wordBank.getRandomWord()[0]);
        return wordBank.getRandomWord()[0];

    }

}
