package br.com.teste.mysqlrest.ports.output;

import br.com.teste.mysqlrest.usecases.model.Pessoa;

import java.util.List;

public interface PessoaDAOPort {
    List<Pessoa> findAll();

    Pessoa getPessoaById(Long idPessoa);

    Pessoa criaPessoa(Pessoa pessoa);

    Pessoa atualizaPessoa(Pessoa pessoa, Long idPessoa);
}
