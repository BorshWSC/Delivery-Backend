package ru.tpu.clouddelivery.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.tpu.clouddelivery.model.Comment;
import ru.tpu.clouddelivery.service.CommentService;

@RestController
@RequestMapping(value = "api/comment")
public class CommentRest {

    private CommentService commentService;

    @Autowired
    public CommentRest(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping()
    public Iterable<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    @PostMapping("/add")
    public Comment addComment(@RequestBody Comment comment) {
       return commentService.addComment(comment);
    }
}
