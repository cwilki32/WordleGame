package com.detroitlabs.WordleGame.controller;

import com.detroitlabs.WordleGame.data.LetterRepository;
import com.detroitlabs.WordleGame.model.WordBank;
import com.detroitlabs.WordleGame.service.WordGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WordController {
//    WordGeneratorService wordGeneratorService = new WordGeneratorService();
    @Autowired
    LetterRepository letterRepository = new LetterRepository();

    @RequestMapping("/")
    public String displayHome() {
        return "home";

    }
}
