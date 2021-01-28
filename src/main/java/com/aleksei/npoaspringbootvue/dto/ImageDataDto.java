package com.aleksei.npoaspringbootvue.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ImageDataDto {

    private Long id;

    private byte[] image;

    private String text;

    private Integer num;
}
