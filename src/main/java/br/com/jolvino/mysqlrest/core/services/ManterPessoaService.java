package br.com.jolvino.mysqlrest.core.services;

import br.com.jolvino.mysqlrest.core.models.Pessoa;
import br.com.jolvino.mysqlrest.port.external.database.PessoaDAOPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManterPessoaService {

    private final PessoaDAOPort pessoaDAOPort;

    public ManterPessoaService(PessoaDAOPort pessoaDAOPort) {
        this.pessoaDAOPort = pessoaDAOPort;
    }

    public List<Pessoa> getAllPessoas() {
        return pessoaDAOPort.findAll();
    }

    public Pessoa getPessoaById(Long idPessoa) {
        return pessoaDAOPort.getPessoaById(idPessoa);
    }

    public Pessoa criarPessoa(Pessoa pessoa) {
        return pessoaDAOPort.criaPessoa(pessoa);
    }

    public Pessoa atualizaPessoa(Pessoa pessoa, Long idPessoa) {
        return pessoaDAOPort.atualizaPessoa(pessoa, idPessoa);
    }
}
