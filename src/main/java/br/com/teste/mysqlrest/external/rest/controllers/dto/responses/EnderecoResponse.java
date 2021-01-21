package br.com.teste.mysqlrest.external.rest.controllers.dto.responses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EnderecoResponse {
    private Long id;
    private String logradouro;
    private Integer numero;
    private String complemento;
    private String bairro;
    private String cep;
}