package com.brainstation23.cblmt.language.repository;

import com.brainstation23.cblmt.language.entity.Internationalization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Iabur on July 07, 2021.
 */
@Repository
public interface InternationalizationRepository extends JpaRepository<Internationalization, Long> {


    List<Internationalization> findAllByKey(String key);

    List<Internationalization> findAllByLanguageShortCode(String shortCode);

    Internationalization findByLanguageShortCodeAndKey(String languageShortCode, String key);
}
