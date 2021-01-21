package br.com.jolvino.mysqlrest.port.external.database;

import br.com.jolvino.mysqlrest.core.models.Endereco;

import java.util.List;

public interface EnderecoDAOPort {
    List<Endereco> findByIdPessoa(Long idPessoa);

    Endereco salvaEndereco(Endereco endereco, Long idPessoa);
}
