package com.brainstation23.cblmt.language.controller;

import com.brainstation23.cblmt.language.entity.Internationalization;
import com.brainstation23.cblmt.language.languageDto.InternationalizationDto;
import com.brainstation23.cblmt.language.languageDto.LanguageKeyDto;
import com.brainstation23.cblmt.language.languageDto.UpdateDto;
import com.brainstation23.cblmt.language.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Iabur on July 07, 2021.
 */
@RestController
@RequestMapping("/key")
public class InternationalizationController {
    @Autowired
    private LanguageService languageService;

    @PostMapping("/insert")
    public Internationalization saveLanguageWord(@RequestBody InternationalizationDto internationalizationDto) {
        return languageService.insertLanguageWord(internationalizationDto);
    }

    @GetMapping("/{language_Key}")
    public List<Internationalization> getLanguageWord(@PathVariable("language_Key") String key) {
        return languageService.getLanguageWordByKey(key);
    }

    @GetMapping("/language/{shortCode}")
    public LanguageKeyDto getKeysByShortCode(@PathVariable("shortCode") String shortCode) {
        return languageService.getKeysByShortCode(shortCode);
    }

    @PostMapping("/update")
    public Internationalization updateInternationalization(@RequestBody UpdateDto updateDto) {
        return languageService.updateInternationalization(updateDto);
    }

}
