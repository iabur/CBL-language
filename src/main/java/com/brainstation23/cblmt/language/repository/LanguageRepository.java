package com.brainstation23.cblmt.language.repository;

import com.brainstation23.cblmt.language.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Iabur on July 07, 2021.
 */
@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {
    Language findLanguageByShortCode(String shortcode);
}