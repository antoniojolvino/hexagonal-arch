package br.com.teste.mysqlrest.external.rest.controllers.dto.responses;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PessoaResponse {
    private Long id;

    private String nome;

    private String email;

    private List<EnderecoResponse> enderecos;
}
