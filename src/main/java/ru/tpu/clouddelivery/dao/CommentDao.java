package ru.tpu.clouddelivery.dao;

import org.springframework.data.repository.CrudRepository;
import ru.tpu.clouddelivery.model.Comment;

public interface CommentDao extends CrudRepository<Comment, Integer> {
}
