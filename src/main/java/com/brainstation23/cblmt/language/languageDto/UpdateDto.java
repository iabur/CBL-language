package com.brainstation23.cblmt.language.languageDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Iabur on July 08, 2021.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDto {
    private String languageShortCode;
    private String key;
    private String newValue;
}
