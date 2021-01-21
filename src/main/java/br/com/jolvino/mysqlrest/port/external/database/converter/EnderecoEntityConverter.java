package br.com.jolvino.mysqlrest.port.external.database.converter;

import br.com.jolvino.mysqlrest.core.models.Endereco;
import br.com.jolvino.mysqlrest.external.database.entities.EnderecoEntity;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Antonio Jolvino
 */
public class EnderecoEntityConverter {

    /**
     * Converte um List de Endereco em um List de EnderecoEntity
     * @param enderecos List de Endereco
     * @return List de EnderecoEntity
     * @see List
     * @see Endereco
     * @see EnderecoEntity
     */
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

    /**
     * Converte um Endereco em um EnderecoEntity
     * @param endereco Instância de Endereco
     * @return Instância de EnderecoEntity
     * @see Endereco
     * @see EnderecoEntity
     */
    public static EnderecoEntity toEntity(Endereco endereco) {
        return EnderecoEntity.builder()
                .id(endereco.getId())
                .bairro(endereco.getBairro())
                .cep(endereco.getCep())
                .complemento(endereco.getComplemento())
                .logradouro(endereco.getLogradouro())
                .numero(endereco.getNumero())
                .build();
    }

    /**
     * Converte um List de EnderecoEntity em um List de Endereco
     * @param enderecos Instância de List de EnderecoEntity
     * @return Instância de List de Endereco
     * @see List
     * @see EnderecoEntity
     * @see Endereco
     */
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

    /**
     * Converte um EnderecoEntity em um Endereco
     * @param enderecoEntity Instância de EnderecoEntity
     * @return Instância de Endereco
     * @see EnderecoEntity
     * @see Endereco
     */
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
