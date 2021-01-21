package br.com.jolvino.mysqlrest.port.external.database;

import br.com.jolvino.mysqlrest.core.models.Pessoa;

import java.util.List;

public interface PessoaDAOPort {
    List<Pessoa> findAll();

    Pessoa getPessoaById(Long idPessoa);

    Pessoa criaPessoa(Pessoa pessoa);

    Pessoa atualizaPessoa(Pessoa pessoa, Long idPessoa);
}
