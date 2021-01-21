package br.com.jolvino.mysqlrest.port.core;

import br.com.jolvino.mysqlrest.external.rest.controllers.dto.requests.EnderecoRequest;
import br.com.jolvino.mysqlrest.external.rest.controllers.dto.responses.EnderecoResponse;

import java.util.List;

public interface ManterEnderecoPort {
    List<EnderecoResponse> findByIdPessoa(Long idPessoa);

    EnderecoResponse alteraEndereco(EnderecoRequest endereco, Long idEndereco, Long idPessoa);

    EnderecoResponse ciraEndereco(EnderecoRequest endereco, Long idPessoa);
}
