package com.fct.BackEnd.services;

import com.fct.BackEnd.entities.Coments;

import java.util.List;
import java.util.Optional;

public interface ComentsService {
    List<Coments> getAllComentarios();
    Optional<Coments> getComentarioById(Long id);
    Coments createComentario(Coments coments);
    Coments updateComentario(Long id, Coments coments);
    void deleteComentario(Long id);
}
