package br.com.jolvino.mysqlrest.core.services;

import br.com.jolvino.mysqlrest.core.models.Endereco;
import br.com.jolvino.mysqlrest.port.external.database.EnderecoDAOPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManterEnderecoService {

    private final EnderecoDAOPort enderecoDAOPort;

    public ManterEnderecoService(EnderecoDAOPort enderecoDAOPort) {
        this.enderecoDAOPort = enderecoDAOPort;
    }

    public List<Endereco> findByIdPessoa(Long idPessoa) {
        return enderecoDAOPort.findByIdPessoa(idPessoa);
    }

    public Endereco salvaEndereco(Endereco endereco, Long idPessoa) {
        return enderecoDAOPort.salvaEndereco(endereco, idPessoa);
    }
}
