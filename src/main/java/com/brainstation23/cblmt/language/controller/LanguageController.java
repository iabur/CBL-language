package com.brainstation23.cblmt.language.controller;

import com.brainstation23.cblmt.language.entity.Language;
import com.brainstation23.cblmt.language.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Created by Iabur on July 07, 2021.
 */
@RestController
@RequestMapping("/language")
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @PostMapping("/insert")
    public Language insertLanguage(@RequestBody Language language) {
        return languageService.insertLanguage(language);
    }

    @GetMapping("/{languageId}")
    public Optional<Language> getLanguage(@PathVariable("languageId") Long id) {
        return languageService.getLanguage(id);
    }

}
