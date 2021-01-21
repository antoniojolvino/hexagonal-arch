package br.com.teste.mysqlrest.port.core;

import br.com.teste.mysqlrest.external.rest.controllers.dto.requests.EnderecoRequest;
import br.com.teste.mysqlrest.external.rest.controllers.dto.responses.EnderecoResponse;

import java.util.List;

public interface ManterEnderecoPort {
    List<EnderecoResponse> findByIdPessoa(Long idPessoa);

    EnderecoResponse alteraEndereco(EnderecoRequest endereco, Long idEndereco, Long idPessoa);

    EnderecoResponse ciraEndereco(EnderecoRequest endereco, Long idPessoa);
}
