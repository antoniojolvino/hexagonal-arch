package br.com.teste.mysqlrest.usecases.services;

import br.com.teste.mysqlrest.ports.output.EnderecoDAOPort;
import br.com.teste.mysqlrest.usecases.model.Endereco;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManterEnderecoUC {

    private final EnderecoDAOPort enderecoDAOPort;

    public ManterEnderecoUC(EnderecoDAOPort enderecoDAOPort) {
        this.enderecoDAOPort = enderecoDAOPort;
    }

    public List<Endereco> findByIdPessoa(Long idPessoa){
        return enderecoDAOPort.findByIdPessoa(idPessoa);
    }

    public Endereco salvaEndereco(Endereco endereco, Long idPessoa){
        return enderecoDAOPort.salvaEndereco(endereco, idPessoa);
    }
}
