package com.aleksei.npoaspringbootvue.util;

import com.aleksei.npoaspringbootvue.dto.ImageDataDto;
import com.aleksei.npoaspringbootvue.entity.ImageData;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

@Component
public class ImageDataUtil {

    public static ImageDataDto imageDataToImageDataDto(ImageData imageData) {
        return new ImageDataDto(imageData.getId(), Base64Coder.decode(imageData.getImage()),
                imageData.getText(), imageData.getNum());
    }

    public static ImageData imageDataDtoToImageData(ImageDataDto imageDataDto) {
        return new ImageData(imageDataDto.getId(), String.valueOf(Base64Coder.encode(imageDataDto.getImage())),
                imageDataDto.getText(), imageDataDto.getNum());
    }
}
