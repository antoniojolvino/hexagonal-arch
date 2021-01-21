package br.com.jolvino.mysqlrest.port.core.converters;

import br.com.jolvino.mysqlrest.core.models.Pessoa;
import br.com.jolvino.mysqlrest.external.rest.controllers.dto.requests.PessoaRequest;
import br.com.jolvino.mysqlrest.external.rest.controllers.dto.responses.PessoaResponse;

import java.util.List;
import java.util.stream.Collectors;

public class PessoaDTOConverter {
    public static PessoaResponse modelToResponse(Pessoa pessoa) {
        return PessoaResponse.builder()
                .id(pessoa.getId())
                .nome(pessoa.getNome())
                .email(pessoa.getEmail())
                .enderecos(EnderecoDTOConverter.modelToResponse(pessoa.getEnderecos()))
                .build();
    }

    public static Pessoa requestToModel(PessoaRequest pessoaRequest) {
        return Pessoa.builder()
                .nome(pessoaRequest.getNome())
                .email(pessoaRequest.getEmail())
                .enderecos(EnderecoDTOConverter.requestToModel(pessoaRequest.getEnderecos()))
                .build();
    }

    public static List<PessoaResponse> modelToResponse(List<Pessoa> pessoas) {
        return pessoas.stream().map(pessoa -> PessoaResponse.builder()
                .id(pessoa.getId())
                .nome(pessoa.getNome())
                .email(pessoa.getEmail())
                .enderecos(EnderecoDTOConverter.modelToResponse(pessoa.getEnderecos()))
                .build()).collect(Collectors.toList());
    }
}
