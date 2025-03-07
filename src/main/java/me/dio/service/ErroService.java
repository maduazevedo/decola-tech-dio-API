package me.dio.service;
import me.dio.model.Erro;

import java.util.List;

public interface ErroService {

    List<Erro> getErro();

    Erro create (Erro error);

    Erro update (Erro error);

    void delete (Long id);

}
