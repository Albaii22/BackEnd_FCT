package com.fct.BackEnd.services;

import com.fct.BackEnd.entities.Comments;

import java.util.List;
import java.util.Optional;

public interface ComentsService {
    List<Comments> getAllComentarios();
    Optional<Comments> getComentarioById(Long id);
    Comments createComentario(Comments coments);
    Comments updateComentario(Long id, Comments coments);
    void deleteComentario(Long id);
}
