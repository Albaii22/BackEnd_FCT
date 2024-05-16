package com.fct.BackEnd.services;

import com.fct.BackEnd.entities.Publications;

import java.util.List;
import java.util.Optional;

public interface PublicationsService {
    List<Publications> getAllPublicaciones();
    Optional<Publications> getPublicacionById(Long id);
    Publications createPublicacion(Publications publication);
    Publications updatePublicacion(Long id, Publications publication);
    void deletePublicacion(Long id);
}
