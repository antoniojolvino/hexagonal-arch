package br.com.teste.mysqlrest.external.database.repositories;

import br.com.teste.mysqlrest.external.database.entities.PessoaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PessoaRepository extends CrudRepository<PessoaEntity, Long> {
    List<PessoaEntity> findAll();
}