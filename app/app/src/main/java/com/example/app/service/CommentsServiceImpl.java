package com.example.app.service;

import com.example.app.module.Comments;
import com.example.app.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CommentsServiceImpl implements CommentsService {

    private final CommentsRepository commentsRepository;

    @Autowired
    public CommentsServiceImpl(CommentsRepository commentsRepository) {this.commentsRepository = commentsRepository;}

    @Override
    public Comments getComments(int id) {
        return commentsRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Comment with id " + id + " not found"
        ));
    }
}
