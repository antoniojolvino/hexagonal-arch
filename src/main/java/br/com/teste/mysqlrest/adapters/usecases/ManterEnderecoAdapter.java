package br.com.teste.mysqlrest.adapters.usecases;

import br.com.teste.mysqlrest.adapters.usecases.converters.EnderecoDTOConverter;
import br.com.teste.mysqlrest.external.exposers.rest.dto.requests.EnderecoRequest;
import br.com.teste.mysqlrest.external.exposers.rest.dto.responses.EnderecoResponse;
import br.com.teste.mysqlrest.ports.input.ManterEnderecoPort;
import br.com.teste.mysqlrest.usecases.services.ManterEnderecoUC;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManterEnderecoAdapter implements ManterEnderecoPort {
    private final ManterEnderecoUC manterEnderecoUC;

    public ManterEnderecoAdapter(ManterEnderecoUC manterEnderecoUC) {
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
