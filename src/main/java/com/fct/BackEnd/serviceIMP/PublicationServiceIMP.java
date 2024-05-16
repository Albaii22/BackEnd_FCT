package com.fct.BackEnd.serviceIMP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fct.BackEnd.entities.Publications;
import com.fct.BackEnd.repository.PublicationsRepository;
import com.fct.BackEnd.services.PublicationsService;

import java.util.List;
import java.util.Optional;

@Service
public class PublicationServiceIMP implements PublicationsService {

    // private static final Logger logger = LoggerFactory.getLogger(PublicationServiceIMP.class);

    @Autowired
    private PublicationsRepository publicationRepository;

    @Override
    public List<Publications> getAllPublicaciones() {
        // logger.info("Fetching all publications");
        List<Publications> publications = publicationRepository.findAll();
        // logger.debug("Found {} publications", publications.size());
        return publications;
    }

    @Override
    public Optional<Publications> getPublicacionById(Long id) {
        // logger.info("Fetching publication with id {}", id);
        Optional<Publications> publication = publicationRepository.findById(id);
        if (publication.isPresent()) {
            // logger.debug("Found publication: {}", publication.get());
        } else {
            // logger.warn("No publication found with id {}", id);
        }
        return publication;
    }

    @Override
    public Publications createPublicacion(Publications publication) {
        // logger.info("Creating new publication");
        Publications savedPublication = publicationRepository.save(publication);
        // logger.debug("Created publication: {}", savedPublication);
        return savedPublication;
    }

    @Override
    public Publications updatePublicacion(Long id, Publications publication) {
        // logger.info("Updating publication with id {}", id);
        publication.setId(id);
        Publications updatedPublication = publicationRepository.save(publication);
        // logger.debug("Updated publication: {}", updatedPublication);
        return updatedPublication;
    }

    @Override
    public void deletePublicacion(Long id) {
        // logger.info("Deleting publication with id {}", id);
        publicationRepository.deleteById(id);
        // logger.debug("Deleted publication with id {}", id);
    }
}
