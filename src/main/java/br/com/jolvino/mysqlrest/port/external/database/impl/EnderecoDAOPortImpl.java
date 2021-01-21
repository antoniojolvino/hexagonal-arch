package br.com.jolvino.mysqlrest.port.external.database.impl;

import br.com.jolvino.mysqlrest.core.models.Endereco;
import br.com.jolvino.mysqlrest.external.database.dao.EnderecoDAO;
import br.com.jolvino.mysqlrest.port.external.database.converter.EnderecoEntityConverter;
import br.com.jolvino.mysqlrest.port.external.database.EnderecoDAOPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EnderecoDAOPortImpl implements EnderecoDAOPort {

    private final EnderecoDAO enderecoDAO;

    public EnderecoDAOPortImpl(EnderecoDAO pessoaDAO) {
        this.enderecoDAO = pessoaDAO;
    }

    @Override
    public List<Endereco> findByIdPessoa(Long idPessoa) {
        return enderecoDAO.findByIdPessoa(idPessoa).stream().map(EnderecoEntityConverter::toModel).collect(Collectors.toList());
    }

    @Override
    public Endereco salvaEndereco(Endereco endereco, Long idPessoa) {
        return EnderecoEntityConverter.toModel(enderecoDAO.salvaEndereco(EnderecoEntityConverter.toEntity(endereco), idPessoa));
    }
}
