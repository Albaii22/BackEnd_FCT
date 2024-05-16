package com.fct.BackEnd.serviceIMP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fct.BackEnd.entities.Publications;
import com.fct.BackEnd.repository.PublicationsRepository;
import com.fct.BackEnd.services.PublicationsService;

import java.util.List;
import java.util.Optional;

@Service
public class PublicationServiceIMP implements PublicationsService {

    @Autowired
    private PublicationsRepository publicationRepository;

    public List<Publications> getAllPublicaciones() {
        return publicationRepository.findAll();
    }

    public Optional<Publications> getPublicacionById(Long id) {
        return publicationRepository.findById(id);
    }

    public Publications createPublicacion(Publications publication) {
        return publicationRepository.save(publication);
    }

    public Publications updatePublicacion(Long id, Publications publication) {
        publication.set_id(id);
        return publicationRepository.save(publication);
    }

    public void deletePublicacion(Long id) {
        publicationRepository.deleteById(id);
    }
}