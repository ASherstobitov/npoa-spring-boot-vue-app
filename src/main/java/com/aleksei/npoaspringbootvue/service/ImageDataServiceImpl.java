package com.aleksei.npoaspringbootvue.service;

import com.aleksei.npoaspringbootvue.entity.ImageData;
import com.aleksei.npoaspringbootvue.repository.ImageDataRepository;
import com.aleksei.npoaspringbootvue.exeption.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ImageDataServiceImpl implements ImageDataService {

    private final ImageDataRepository repository;

    @Override
    public ImageData getById(Long id) {

        return repository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public void save(ImageData imageData) {
        if (imageData != null)
            repository.updateTextAndNum(1L, imageData.getText(), imageData.getNum());
    }

    @PostConstruct
    public void saveImage() throws IOException {
        if (!repository.existsById(1L)) {
            StringBuilder stringBuilder = new StringBuilder();
            try (Stream<String> stream = Files.lines(Paths.get("src\\main\\resources\\static\\images\\base64.txt"))) {
                stream.forEach(s -> stringBuilder.append(s));
            }
            ImageData entity = new ImageData();
            entity.setId(1L);
            entity.setImage(stringBuilder.toString());
            repository.save(entity);
        }
    }
}
