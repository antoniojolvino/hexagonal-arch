package br.com.teste.mysqlrest.external.rest.controllers;

import br.com.teste.mysqlrest.external.rest.controllers.dto.requests.PessoaRequest;
import br.com.teste.mysqlrest.external.rest.controllers.dto.responses.PessoaResponse;
import br.com.teste.mysqlrest.port.core.ManterPessoaPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/pessoa")
@RestController
public class PessoaRestController {

    private final ManterPessoaPort manterPessoaPort;

    public PessoaRestController(ManterPessoaPort manterPessoaPort) {
        this.manterPessoaPort = manterPessoaPort;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaResponse> getPessoaById(@PathVariable("id") Long idPessoa) {
        return ResponseEntity.ok().body(manterPessoaPort.getPessoaById(idPessoa));
    }

    @GetMapping
    public ResponseEntity<List<PessoaResponse>> getAllPessoas() {
        return ResponseEntity.ok().body(manterPessoaPort.getAllPessoas());
    }

    @PostMapping
    public ResponseEntity<PessoaResponse> criarPessoa(@RequestBody PessoaRequest pessoaRequest) {
        return ResponseEntity.ok().body(manterPessoaPort.criarPessoa(pessoaRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaResponse> atualizarPessoa(@PathVariable("id") Long idPessoa, @RequestBody PessoaRequest pessoaRequest) {
        return ResponseEntity.ok().body(manterPessoaPort.atualizaPessoa(pessoaRequest, idPessoa));
    }
}