package me.dio.service.impl;
import me.dio.model.Erro;
import me.dio.repository.DescriptionRepository;
import me.dio.repository.ErroRepository;
import me.dio.service.ErroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ErroServiceImpl implements ErroService {

    @Autowired
    private ErroRepository erroRepository;

    @Autowired
    private DescriptionRepository descriptionRepository;

    @Override
    public List<Erro> getErro() {
        return erroRepository.findAll();
    }

    @Override
    public Erro create(Erro erro) {
        if(erro.getId_erro() == null){
            throw new IllegalArgumentException("Erro id can't be null");
        }
        if(erroRepository.existsById(erro.getId_erro())){
            throw new IllegalArgumentException("Erro already exists");
        }
        if(descriptionRepository.existsById(erro.getDescription().getId_description())){
            throw new IllegalArgumentException("Decripton already exists");
        }
        if(erro.getDescription().getId_description() == null){
            throw new IllegalArgumentException("Description id can't be null");
        }
        return erroRepository.save(erro);
    }

    @Override
    public Erro update(Erro erro) {
        if (!erroRepository.existsById(erro.getId_erro())){
            throw new IllegalArgumentException("Erro not found to update");
        }
        if(!descriptionRepository.existsById(erro.getDescription().getId_description())){
            throw new IllegalArgumentException("Description not found to update");
        }
        return erroRepository.save(erro);
    }

    @Override
    public void delete(Long id) {
        if (!erroRepository.existsById(id)) {
            throw new IllegalArgumentException("Erro not found to delete");
        }
        erroRepository.deleteById(id);
    }

}
