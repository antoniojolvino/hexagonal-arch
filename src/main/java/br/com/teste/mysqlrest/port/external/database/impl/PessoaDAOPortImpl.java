package br.com.teste.mysqlrest.port.external.database.impl;

import br.com.teste.mysqlrest.core.models.Pessoa;
import br.com.teste.mysqlrest.external.database.dao.PessoaDAO;
import br.com.teste.mysqlrest.port.external.database.PessoaDAOPort;
import br.com.teste.mysqlrest.port.external.database.converter.PessoaEntityConverter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PessoaDAOPortImpl implements PessoaDAOPort {

    private final PessoaDAO pessoaDAO;

    public PessoaDAOPortImpl(PessoaDAO pessoaDAO) {
        this.pessoaDAO = pessoaDAO;
    }

    @Override
    public List<Pessoa> findAll() {
        return pessoaDAO.findAll().stream().map(PessoaEntityConverter::toModel).collect(Collectors.toList());
    }

    @Override
    public Pessoa getPessoaById(Long idPessoa) {
        return PessoaEntityConverter.toModel(pessoaDAO.getPessoaById(idPessoa));
    }

    @Override
    public Pessoa criaPessoa(Pessoa pessoa) {
        return PessoaEntityConverter.toModel(pessoaDAO.criaPessoa(PessoaEntityConverter.toEntity(pessoa)));
    }

    @Override
    public Pessoa atualizaPessoa(Pessoa pessoa, Long idPessoa) {
        return PessoaEntityConverter.toModel(pessoaDAO.atualizaPessoa(PessoaEntityConverter.toEntity(pessoa, idPessoa)));
    }
}
