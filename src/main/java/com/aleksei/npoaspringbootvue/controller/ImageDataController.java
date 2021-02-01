package com.aleksei.npoaspringbootvue.controller;

import com.aleksei.npoaspringbootvue.entity.ImageData;
import com.aleksei.npoaspringbootvue.service.ImageDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/image")
public class ImageDataController {

    private final ImageDataService service;

    @GetMapping()
    @CrossOrigin(origins = "http://localhost:8080")
    public ImageData getById() {

        return service.getById(1L);
    }

    @PutMapping
    @CrossOrigin(origins = "http://localhost:8080")
    public void update(@RequestBody ImageData imageData) {

        service.save(imageData);
    }
}
