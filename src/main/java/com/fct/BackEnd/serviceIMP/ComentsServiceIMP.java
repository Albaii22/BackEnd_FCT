package com.fct.BackEnd.serviceIMP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fct.BackEnd.entities.Coments;
import com.fct.BackEnd.repository.ComentsRepository;
import com.fct.BackEnd.services.ComentsService;

import java.util.List;
import java.util.Optional;

@Service
public class ComentsServiceIMP implements ComentsService {

    private static final Logger logger = LoggerFactory.getLogger(ComentsServiceIMP.class);

    @Autowired
    private ComentsRepository comentsRepository;

    @Override
    public List<Coments> getAllComentarios() {
        logger.info("Fetching all comments");
        List<Coments> comments = comentsRepository.findAll();
        logger.debug("Found {} comments", comments.size());
        return comments;
    }

    @Override
    public Optional<Coments> getComentarioById(Long id) {
        logger.info("Fetching comment with id {}", id);
        Optional<Coments> comment = comentsRepository.findById(id);
        if (comment.isPresent()) {
            logger.debug("Found comment: {}", comment.get());
        } else {
            logger.warn("No comment found with id {}", id);
        }
        return comment;
    }

    @Override
    public Coments createComentario(Coments coments) {
        logger.info("Creating new comment");
        Coments savedComment = comentsRepository.save(coments);
        logger.debug("Created comment: {}", savedComment);
        return savedComment;
    }

    @Override
    public Coments updateComentario(Long id, Coments coments) {
        logger.info("Updating comment with id {}", id);
        coments.set_id(id);
        Coments updatedComment = comentsRepository.save(coments);
        logger.debug("Updated comment: {}", updatedComment);
        return updatedComment;
    }

    @Override
    public void deleteComentario(Long id) {
        logger.info("Deleting comment with id {}", id);
        comentsRepository.deleteById(id);
        logger.debug("Deleted comment with id {}", id);
    }
}
