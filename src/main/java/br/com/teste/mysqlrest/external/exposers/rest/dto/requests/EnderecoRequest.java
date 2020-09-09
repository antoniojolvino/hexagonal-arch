package br.com.teste.mysqlrest.external.exposers.rest.dto.requests;

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