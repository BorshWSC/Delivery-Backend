package ru.tpu.clouddelivery.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tpu.clouddelivery.dao.ImageDao;
import ru.tpu.clouddelivery.exceptions.NotFoundException;
import ru.tpu.clouddelivery.model.Image;

@Service
public class ImageService {

    private ImageDao imageDao;

    @Autowired
    public ImageService(ImageDao imageDao) {
        this.imageDao = imageDao;
    }

    public Iterable<Image> getAllImages() {
        return imageDao.findAll();
    }

    public Image getImageById(String id) {
        return imageDao.findById(Integer.parseInt(id)).orElseThrow(NotFoundException::new);
    }

    public Image createImage(Image image) {
        return imageDao.save(image);
    }

    public Image updateImage(Image imageFromDb, Image newImage) {
        BeanUtils.copyProperties(newImage, imageFromDb, "id");
        return imageDao.save(imageFromDb);
    }

    public void deleteImage(Image image) {
        imageDao.delete(image);
    }
}
