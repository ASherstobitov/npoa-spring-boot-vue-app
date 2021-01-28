package com.aleksei.npoaspringbootvue.controller;

import com.aleksei.npoaspringbootvue.dto.ImageDataDto;
import com.aleksei.npoaspringbootvue.service.ImageDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/image")
public class ImageDataController {

    private final ImageDataService service;

    @GetMapping()
    public ImageDataDto getById() {
        return service.getById(1L);
    }

    @PutMapping
    public void update(@RequestBody ImageDataDto imageDataDto) {
        service.save(imageDataDto);
    }
}
