package br.com.teste.mysqlrest.usecases.services;

import br.com.teste.mysqlrest.ports.output.PessoaDAOPort;
import br.com.teste.mysqlrest.usecases.model.Pessoa;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManterPessoaUC {

    private final PessoaDAOPort pessoaDAOPort;

    public ManterPessoaUC(PessoaDAOPort pessoaDAOPort) {
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
