package com.brainstation23.cblmt.language.languageDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Iabur on July 08, 2021.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InternationalizationDto {
    private String key;
    private String value;
    private String shortcode;
}
