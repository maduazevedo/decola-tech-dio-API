package me.dio.repository;

import me.dio.model.Description;
import me.dio.model.Erro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ErroRepository extends JpaRepository<Erro, Long> {
}
