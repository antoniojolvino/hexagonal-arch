package br.com.teste.mysqlrest.adapters.database;

import br.com.teste.mysqlrest.adapters.database.converters.EnderecoEntityConverter;
import br.com.teste.mysqlrest.external.consumers.database.dao.EnderecoDAO;
import br.com.teste.mysqlrest.ports.output.EnderecoDAOPort;
import br.com.teste.mysqlrest.usecases.model.Endereco;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EnderecoDAOAdapter implements EnderecoDAOPort {

    private final EnderecoDAO enderecoDAO;

    public EnderecoDAOAdapter(EnderecoDAO pessoaDAO) {
        this.enderecoDAO = pessoaDAO;
    }

    @Override
    public List<Endereco> findByIdPessoa(Long idPessoa) {
        return enderecoDAO.findByIdPessoa(idPessoa).stream().map(EnderecoEntityConverter::toModel).collect(Collectors.toList());
    }

    @Override
    public Endereco salvaEndereco(Endereco endereco,  Long idPessoa){
        return EnderecoEntityConverter.toModel(enderecoDAO.salvaEndereco(EnderecoEntityConverter.toEntity(endereco), idPessoa));
    }
}
