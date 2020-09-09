package br.com.teste.mysqlrest.ports.output;

import br.com.teste.mysqlrest.usecases.model.Endereco;
import br.com.teste.mysqlrest.usecases.model.Pessoa;

import java.util.List;

public interface EnderecoDAOPort {
    List<Endereco> findByIdPessoa(Long idPessoa);

    Endereco salvaEndereco(Endereco endereco, Long idPessoa);
}
