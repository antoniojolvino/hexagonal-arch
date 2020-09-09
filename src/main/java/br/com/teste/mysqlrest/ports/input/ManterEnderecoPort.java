package br.com.teste.mysqlrest.ports.input;

import br.com.teste.mysqlrest.external.exposers.rest.dto.requests.EnderecoRequest;
import br.com.teste.mysqlrest.external.exposers.rest.dto.responses.EnderecoResponse;

import java.util.List;

public interface ManterEnderecoPort {
    List<EnderecoResponse> findByIdPessoa(Long idPessoa);

    EnderecoResponse alteraEndereco(EnderecoRequest endereco, Long idEndereco, Long idPessoa);

    EnderecoResponse ciraEndereco(EnderecoRequest endereco, Long idPessoa);
}
