package com.aleksei.npoaspringbootvue.service;

import com.aleksei.npoaspringbootvue.entity.ImageData;

public interface ImageDataService {

    ImageData getById(Long id);

    void save(ImageData imageData);
}
