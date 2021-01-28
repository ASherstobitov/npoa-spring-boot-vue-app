package com.aleksei.npoaspringbootvue.service;

import com.aleksei.npoaspringbootvue.dto.ImageDataDto;
import com.aleksei.npoaspringbootvue.entity.ImageData;
import com.aleksei.npoaspringbootvue.util.ImageDataUtil;
import com.aleksei.npoaspringbootvue.repository.ImageDataRepository;
import com.aleksei.npoaspringbootvue.util.exeption.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
@RequiredArgsConstructor
public class ImageDataServiceImpl implements ImageDataService {

    private final ImageDataRepository repository;

    @Override
    public ImageDataDto getById(Long id) {
        ImageData imageData = repository.findById(id).orElseThrow(NotFoundException::new);
        return ImageDataUtil.imageDataToImageDataDto(imageData);
    }

    @Override
    public void save(ImageDataDto imageDataDto) {
        if (imageDataDto != null)
            repository.updateTextAndNum(1L, imageDataDto.getText(), imageDataDto.getNum());
    }

    @PostConstruct
    public void saveImage() throws IOException {
        if (!repository.existsById(1L)) {
            ResourceLoader loader = new DefaultResourceLoader();
            File file = new File("src\\main\\resources\\static\\images\\TacoCloud.png");
            InputStream in = new FileInputStream(file);
            byte[] bytes = in.readAllBytes();
            String codeImage = String.valueOf(Base64Coder.encode(bytes));
            ImageData entity = new ImageData();
            entity.setId(1L);
            entity.setImage(codeImage);
            repository.save(entity);
        }
    }
}
