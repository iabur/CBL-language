package com.brainstation23.cblmt.language.service;

import com.brainstation23.cblmt.language.entity.Internationalization;
import com.brainstation23.cblmt.language.entity.Language;
import com.brainstation23.cblmt.language.languageDto.InternationalizationDto;
import com.brainstation23.cblmt.language.languageDto.LanguageKeyDto;
import com.brainstation23.cblmt.language.languageDto.UpdateDto;
import com.brainstation23.cblmt.language.repository.InternationalizationRepository;
import com.brainstation23.cblmt.language.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Created by Iabur on July 07, 2021.
 */
@Service
public class LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private InternationalizationRepository internationalizationRepository;

    public Language insertLanguage(Language language) {
        language.setStatus(1);
        return languageRepository.save(language);
    }

    public Optional<Language> getLanguage(Long id) {
        return languageRepository.findById(id);
    }

    public Internationalization insertLanguageWord(InternationalizationDto internationalizationDto) {
        Language language = languageRepository.findLanguageByShortCode(internationalizationDto.getShortcode());
        if (language != null) {
            LocalDateTime time = LocalDateTime.now();
            language.setInternationaltionUpdateTime(time);
            Internationalization internationalization = new Internationalization();
            internationalization.setKey(internationalizationDto.getKey());
            internationalization.setValue(internationalizationDto.getValue());
            internationalization.setLanguage(language);
            return internationalizationRepository.save(internationalization);
        }
        return null;
    }

    public List<Internationalization> getLanguageWordByKey(String key) {
        return internationalizationRepository.findAllByKey(key);
    }

    public LanguageKeyDto getKeysByShortCode(String shortCode) {
        List<Internationalization> internationalization = internationalizationRepository.findAllByLanguageShortCode(shortCode);
        if (internationalization != null) {
            LanguageKeyDto languageKeyDto = new LanguageKeyDto();
            languageKeyDto.setLanguageName(shortCode);
//        List<Map<String, String>> keyvals = new ArrayList<>();
            Map<String, String> keyvalsMap = new HashMap<String, String>();
            for (Internationalization intern:
                    internationalization) {
                keyvalsMap.put(intern.getKey(), intern.getValue());
//        keyvals.add(keyvalsMap);
            }
            languageKeyDto.setKeyvals(keyvalsMap);
            return languageKeyDto;
        }
       return null;
    }

    public Internationalization updateInternationalization(UpdateDto updateDto) {
        Internationalization internationalization = internationalizationRepository.findByLanguageShortCodeAndKey(updateDto.getLanguageShortCode(), updateDto.getKey());
        if (internationalization != null) {
            internationalization.setValue(updateDto.getNewValue());
            LocalDateTime now = LocalDateTime.now();
            internationalization.getLanguage().setInternationaltionUpdateTime(now);
            internationalizationRepository.save(internationalization);
            return internationalization;
        }
        return null;
    }

}
