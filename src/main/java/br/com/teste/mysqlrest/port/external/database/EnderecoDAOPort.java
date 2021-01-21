package br.com.teste.mysqlrest.port.external.database;

import br.com.teste.mysqlrest.core.models.Endereco;

import java.util.List;

public interface EnderecoDAOPort {
    List<Endereco> findByIdPessoa(Long idPessoa);

    Endereco salvaEndereco(Endereco endereco, Long idPessoa);
}
