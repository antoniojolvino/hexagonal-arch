package br.com.jolvino.mysqlrest.port.core.impl;

import br.com.jolvino.mysqlrest.core.services.ManterEnderecoService;
import br.com.jolvino.mysqlrest.external.rest.controllers.dto.requests.EnderecoRequest;
import br.com.jolvino.mysqlrest.external.rest.controllers.dto.responses.EnderecoResponse;
import br.com.jolvino.mysqlrest.port.core.converters.EnderecoDTOConverter;
import br.com.jolvino.mysqlrest.port.core.ManterEnderecoPort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManterEnderecoPortImpl implements ManterEnderecoPort {
    private final ManterEnderecoService manterEnderecoUC;

    public ManterEnderecoPortImpl(ManterEnderecoService manterEnderecoUC) {
        this.manterEnderecoUC = manterEnderecoUC;
    }

    @Override
    public List<EnderecoResponse> findByIdPessoa(Long idPessoa) {
        return EnderecoDTOConverter.modelToResponse(manterEnderecoUC.findByIdPessoa(idPessoa));
    }

    @Override
    public EnderecoResponse ciraEndereco(EnderecoRequest endereco, Long idPessoa) {
        return EnderecoDTOConverter.modelToResponse(manterEnderecoUC.salvaEndereco(EnderecoDTOConverter.requestToModel(endereco), idPessoa));
    }

    @Override
    public EnderecoResponse alteraEndereco(EnderecoRequest endereco, Long idEndereco, Long idPessoa) {
        return EnderecoDTOConverter.modelToResponse(manterEnderecoUC.salvaEndereco(EnderecoDTOConverter.requestToModel(endereco, idEndereco), idPessoa));
    }

}
