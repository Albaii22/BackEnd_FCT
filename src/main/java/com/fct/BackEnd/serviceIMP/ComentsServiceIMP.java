package com.fct.BackEnd.serviceIMP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fct.BackEnd.entities.Coments;
import com.fct.BackEnd.repository.ComentsRepository;
import com.fct.BackEnd.services.ComentsService;

import java.util.List;
import java.util.Optional;

@Service
public class ComentsServiceIMP implements ComentsService{

    @Autowired
    private ComentsRepository comentsRepository;

    public List<Coments> getAllComentarios() {
        return comentsRepository.findAll();
    }

    public Optional<Coments> getComentarioById(Long id) {
        return comentsRepository.findById(id);
    }

    public Coments createComentario(Coments coments) {
        return comentsRepository.save(coments);
    }

    public Coments updateComentario(Long id, Coments coments) {
        coments.set_id(id);
        return comentsRepository.save(coments); 
    }

    public void deleteComentario(Long id) {
        comentsRepository.deleteById(id);
    }
}
