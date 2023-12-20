package com.example.app.controller;


import com.example.app.module.Comments;
import com.example.app.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CommentsController {

    private final CommentsService commentsService;

    @Autowired
    public CommentsController(CommentsService commentsService) {this.commentsService = commentsService;}

    @GetMapping("/comments/{id}")
    public Comments getComments(@PathVariable int id) {
        return commentsService.getComments(id);
    }
}
