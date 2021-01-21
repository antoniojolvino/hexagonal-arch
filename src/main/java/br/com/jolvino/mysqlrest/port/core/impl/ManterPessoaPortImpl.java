package br.com.jolvino.mysqlrest.port.core.impl;

import br.com.jolvino.mysqlrest.core.models.Pessoa;
import br.com.jolvino.mysqlrest.core.services.ManterPessoaService;
import br.com.jolvino.mysqlrest.external.rest.controllers.dto.requests.PessoaRequest;
import br.com.jolvino.mysqlrest.external.rest.controllers.dto.responses.PessoaResponse;
import br.com.jolvino.mysqlrest.port.core.converters.PessoaDTOConverter;
import br.com.jolvino.mysqlrest.port.core.ManterPessoaPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManterPessoaPortImpl implements ManterPessoaPort {
    @Autowired
    private ManterPessoaService manterPessoaService;

    public ManterPessoaPortImpl(ManterPessoaService manterPessoaService) {
        this.manterPessoaService = manterPessoaService;
    }

    @Override
    public PessoaResponse getPessoaById(Long idPessoa) {
        return PessoaDTOConverter.modelToResponse(manterPessoaService.getPessoaById(idPessoa));
    }

    @Override
    public List<PessoaResponse> getAllPessoas() {
        return PessoaDTOConverter.modelToResponse(manterPessoaService.getAllPessoas());
    }

    @Override
    public PessoaResponse criarPessoa(PessoaRequest pessoaRequest) {
        Pessoa pessoa = PessoaDTOConverter.requestToModel(pessoaRequest);
        return PessoaDTOConverter.modelToResponse(manterPessoaService.criarPessoa(pessoa));
    }

    @Override
    public PessoaResponse atualizaPessoa(PessoaRequest pessoaRequest, Long idPessoa) {
        Pessoa pessoa = PessoaDTOConverter.requestToModel(pessoaRequest);
        return PessoaDTOConverter.modelToResponse(manterPessoaService.atualizaPessoa(pessoa, idPessoa));
    }
}
