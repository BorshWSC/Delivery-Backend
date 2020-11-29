package ru.tpu.clouddelivery.dao;

import org.springframework.data.repository.CrudRepository;
import ru.tpu.clouddelivery.model.Image;

public interface ImageDao extends CrudRepository<Image, Integer> {
}
