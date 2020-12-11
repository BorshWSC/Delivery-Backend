package ru.tpu.clouddelivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tpu.clouddelivery.dao.CommentDao;
import ru.tpu.clouddelivery.model.Comment;

@Service
public class CommentService {

    private CommentDao commentDao;

    @Autowired
    public CommentService(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    public Iterable<Comment> getAllComments() {
        return commentDao.findAll();
    }

    public Comment addComment(Comment comment) {
        return commentDao.save(comment);
    }
}
