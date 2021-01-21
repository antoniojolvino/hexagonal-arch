package br.com.teste.mysqlrest.port.core.converters;

import br.com.teste.mysqlrest.core.models.Endereco;
import br.com.teste.mysqlrest.external.rest.controllers.dto.requests.EnderecoRequest;
import br.com.teste.mysqlrest.external.rest.controllers.dto.responses.EnderecoResponse;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class EnderecoDTOConverter {
    public static List<EnderecoResponse> modelToResponse(List<Endereco> enderecos) {
        if (Objects.nonNull(enderecos))
            return enderecos.stream().map(endereco -> EnderecoResponse.builder()
                    .id(endereco.getId())
                    .logradouro(endereco.getLogradouro())
                    .numero(endereco.getNumero())
                    .complemento(endereco.getComplemento())
                    .bairro(endereco.getBairro())
                    .cep(endereco.getCep())
                    .build()).collect(Collectors.toList());
        else
            return Collections.emptyList();
    }

    public static List<Endereco> requestToModel(List<EnderecoRequest> enderecos) {
        if (Objects.nonNull(enderecos))
            return enderecos.stream().map(endereco -> Endereco.builder()
                    .logradouro(endereco.getLogradouro())
                    .numero(endereco.getNumero())
                    .complemento(endereco.getComplemento())
                    .bairro(endereco.getBairro())
                    .cep(endereco.getCep())
                    .build()).collect(Collectors.toList());
        else
            return Collections.emptyList();
    }

    public static EnderecoResponse modelToResponse(Endereco endereco) {
        return EnderecoResponse.builder()
                .id(endereco.getId())
                .logradouro(endereco.getLogradouro())
                .numero(endereco.getNumero())
                .complemento(endereco.getComplemento())
                .bairro(endereco.getBairro())
                .cep(endereco.getCep())
                .build();
    }

    public static Endereco requestToModel(EnderecoRequest endereco) {
        return Endereco.builder()
                .logradouro(endereco.getLogradouro())
                .numero(endereco.getNumero())
                .complemento(endereco.getComplemento())
                .bairro(endereco.getBairro())
                .cep(endereco.getCep())
                .build();
    }

    public static Endereco requestToModel(EnderecoRequest endereco, Long idEndereco) {
        return Endereco.builder()
                .id(idEndereco)
                .logradouro(endereco.getLogradouro())
                .numero(endereco.getNumero())
                .complemento(endereco.getComplemento())
                .bairro(endereco.getBairro())
                .cep(endereco.getCep())
                .build();
    }
}
