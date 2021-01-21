package br.com.teste.mysqlrest.port.core;

import br.com.teste.mysqlrest.external.rest.controllers.dto.requests.PessoaRequest;
import br.com.teste.mysqlrest.external.rest.controllers.dto.responses.PessoaResponse;

import java.util.List;

public interface ManterPessoaPort {
    PessoaResponse getPessoaById(Long idPessoa);

    List<PessoaResponse> getAllPessoas();

    PessoaResponse criarPessoa(PessoaRequest pessoaRequest);

    PessoaResponse atualizaPessoa(PessoaRequest pessoaRequest, Long idPessoa);
}
