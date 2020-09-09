package br.com.teste.mysqlrest.adapters.usecases;

import br.com.teste.mysqlrest.adapters.usecases.converters.PessoaDTOConverter;
import br.com.teste.mysqlrest.external.exposers.rest.dto.requests.PessoaRequest;
import br.com.teste.mysqlrest.external.exposers.rest.dto.responses.PessoaResponse;
import br.com.teste.mysqlrest.ports.input.ManterPessoaPort;
import br.com.teste.mysqlrest.usecases.model.Pessoa;
import br.com.teste.mysqlrest.usecases.services.ManterPessoaUC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManterPessoaAdapter implements ManterPessoaPort {
    @Autowired
    private ManterPessoaUC manterPessoaUC;

    public ManterPessoaAdapter(ManterPessoaUC manterPessoaUC) {
        this.manterPessoaUC = manterPessoaUC;
    }

    @Override
    public PessoaResponse getPessoaById(Long idPessoa) {
        return PessoaDTOConverter.modelToResponse(manterPessoaUC.getPessoaById(idPessoa));
    }

    @Override
    public List<PessoaResponse> getAllPessoas() {
        return PessoaDTOConverter.modelToResponse(manterPessoaUC.getAllPessoas());
    }

    @Override
    public PessoaResponse criarPessoa(PessoaRequest pessoaRequest) {
        Pessoa pessoa = PessoaDTOConverter.requestToModel(pessoaRequest);
        return PessoaDTOConverter.modelToResponse(manterPessoaUC.criarPessoa(pessoa));
    }

    @Override
    public PessoaResponse atualizaPessoa(PessoaRequest pessoaRequest, Long idPessoa) {
        Pessoa pessoa = PessoaDTOConverter.requestToModel(pessoaRequest);
        return PessoaDTOConverter.modelToResponse(manterPessoaUC.atualizaPessoa(pessoa, idPessoa));
    }
}
