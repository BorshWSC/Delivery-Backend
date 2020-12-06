package ru.tpu.clouddelivery.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.tpu.clouddelivery.model.Image;
import ru.tpu.clouddelivery.service.ImageService;

@RestController
@RequestMapping(value = "api/img")
public class ImageRest {

    private ImageService imageService;

    @Autowired
    public ImageRest(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping()
    public Iterable<Image> list() {
        return imageService.getAllImages();
    }

    @GetMapping("{id}")
    public Image getOne(@PathVariable String id) {

        return imageService.getImageById(id);
    }

    @PostMapping("/create")
    public Image create(@RequestBody Image image){
        return imageService.createImage(image);
    }

    @PutMapping("{id}")
    public Image update(@PathVariable("id") Image imageFromDB, @RequestBody Image newImage) {
        return imageService.updateImage(imageFromDB, newImage);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Image imageFromDB) {
        imageService.deleteImage(imageFromDB);
    }
}
