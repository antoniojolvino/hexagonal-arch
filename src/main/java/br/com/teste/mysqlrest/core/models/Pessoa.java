package br.com.teste.mysqlrest.core.models;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Builder
@Data
public class Pessoa implements Serializable {
    private Long id;
    private String nome;
    private String email;
    private List<Endereco> enderecos;
}
