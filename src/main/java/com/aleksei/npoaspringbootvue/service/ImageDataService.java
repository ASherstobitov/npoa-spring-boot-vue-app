package com.aleksei.npoaspringbootvue.service;

import com.aleksei.npoaspringbootvue.dto.ImageDataDto;

public interface ImageDataService {

    ImageDataDto getById(Long id);

    void save(ImageDataDto imageDataDto);
}
