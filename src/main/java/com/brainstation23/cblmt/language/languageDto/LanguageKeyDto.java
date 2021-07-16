package com.brainstation23.cblmt.language.languageDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * Created by Iabur on July 07, 2021.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LanguageKeyDto {
    private String languageName;
//    private List<Map<String, String>> keyvals;
    private Map<String, String> keyvals;
}
