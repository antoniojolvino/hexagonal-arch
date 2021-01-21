package br.com.teste.mysqlrest.external.rest.controllers.dto.requests;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class PessoaRequest {
    private String nome;

    private String email;

    private List<EnderecoRequest> enderecos;
}


