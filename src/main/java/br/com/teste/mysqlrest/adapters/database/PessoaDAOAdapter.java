package br.com.teste.mysqlrest.adapters.database;

import br.com.teste.mysqlrest.adapters.database.converters.PessoaEntityConverter;
import br.com.teste.mysqlrest.external.consumers.database.dao.PessoaDAO;
import br.com.teste.mysqlrest.ports.output.PessoaDAOPort;
import br.com.teste.mysqlrest.usecases.model.Pessoa;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PessoaDAOAdapter implements PessoaDAOPort {

    private final PessoaDAO pessoaDAO;

    public PessoaDAOAdapter(PessoaDAO pessoaDAO) {
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
