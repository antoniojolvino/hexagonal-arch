package br.com.teste.mysqlrest.external.database.repositories;

import br.com.teste.mysqlrest.external.database.entities.EnderecoEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EnderecoRepository extends CrudRepository<EnderecoEntity, Long> {
    @Modifying
    @Query("delete from endereco e where e.pessoa.id = :idPessoa")
    void deleteByIdPessoa(@Param("idPessoa") Long idPessoa);

    @Query("from endereco e where e.pessoa.id = :idPessoa")
    List<EnderecoEntity> findByIdPessoa(@Param("idPessoa") Long idPessoa);
}