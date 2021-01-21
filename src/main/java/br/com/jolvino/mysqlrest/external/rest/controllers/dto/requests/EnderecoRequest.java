package br.com.jolvino.mysqlrest.external.rest.controllers.dto.requests;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class EnderecoRequest {
    private String logradouro;
    private Integer numero;
    private String complemento;
    private String bairro;
    private String cep;
}