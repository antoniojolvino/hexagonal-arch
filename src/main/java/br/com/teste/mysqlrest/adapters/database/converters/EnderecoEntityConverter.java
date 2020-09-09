package br.com.teste.mysqlrest.adapters.database.converters;

import br.com.teste.mysqlrest.external.consumers.database.entities.EnderecoEntity;
import br.com.teste.mysqlrest.usecases.model.Endereco;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class EnderecoEntityConverter {

    public static List<EnderecoEntity> toEntity(List<Endereco> enderecos) {
        if (Objects.nonNull(enderecos))
            return enderecos.stream().map(item -> EnderecoEntity.builder()
                    .bairro(item.getBairro())
                    .cep(item.getCep())
                    .complemento(item.getComplemento())
                    .logradouro(item.getLogradouro())
                    .numero(item.getNumero())
                    .build()).collect(Collectors.toList());
        else
            return Collections.emptyList();
    }

    public static EnderecoEntity toEntity(Endereco item) {
        return EnderecoEntity.builder()
                .id(item.getId())
                .bairro(item.getBairro())
                .cep(item.getCep())
                .complemento(item.getComplemento())
                .logradouro(item.getLogradouro())
                .numero(item.getNumero())
                .build();
    }

    public static List<Endereco> toModel(List<EnderecoEntity> enderecos) {
        if (Objects.nonNull(enderecos))
            return enderecos.stream().map(item -> Endereco.builder()
                    .id(item.getId())
                    .bairro(item.getBairro())
                    .cep(item.getCep())
                    .complemento(item.getComplemento())
                    .logradouro(item.getLogradouro())
                    .numero(item.getNumero())
                    .build()).collect(Collectors.toList());
        else
            return Collections.emptyList();
    }

    public static Endereco toModel(EnderecoEntity enderecoEntity) {
        return Endereco.builder()
                .id(enderecoEntity.getId())
                .bairro(enderecoEntity.getBairro())
                .cep(enderecoEntity.getCep())
                .complemento(enderecoEntity.getComplemento())
                .logradouro(enderecoEntity.getLogradouro())
                .numero(enderecoEntity.getNumero())
                .build();
    }
}
