package me.dio.service.impl;
import me.dio.model.Erro;
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
        return erroRepository.save(erro);
    }

    @Override
    public Erro update(Erro erro) {
        if (!erroRepository.existsById(erro.getId_erro())){
            throw new IllegalArgumentException("Erro not found to update");
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
