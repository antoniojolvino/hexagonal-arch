package br.com.teste.mysqlrest.ports.input;

import br.com.teste.mysqlrest.external.exposers.rest.dto.requests.PessoaRequest;
import br.com.teste.mysqlrest.external.exposers.rest.dto.responses.PessoaResponse;

import java.util.List;

public interface ManterPessoaPort {
    PessoaResponse getPessoaById(Long idPessoa);

    List<PessoaResponse> getAllPessoas();

    PessoaResponse criarPessoa(PessoaRequest pessoaRequest);

    PessoaResponse atualizaPessoa(PessoaRequest pessoaRequest, Long idPessoa);
}
