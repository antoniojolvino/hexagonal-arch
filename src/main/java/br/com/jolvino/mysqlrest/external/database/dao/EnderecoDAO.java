package br.com.jolvino.mysqlrest.external.database.dao;

import br.com.jolvino.mysqlrest.external.database.entities.EnderecoEntity;
import br.com.jolvino.mysqlrest.external.database.entities.PessoaEntity;
import br.com.jolvino.mysqlrest.external.database.repositories.EnderecoRepository;
import br.com.jolvino.mysqlrest.external.database.repositories.PessoaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EnderecoDAO {

    private final EnderecoRepository enderecoRepository;

    private final PessoaRepository pessoaRepository;

    public EnderecoDAO(EnderecoRepository enderecoRepository, PessoaRepository pessoaRepository) {
        this.enderecoRepository = enderecoRepository;
        this.pessoaRepository = pessoaRepository;
    }

    public EnderecoEntity salvaEndereco(EnderecoEntity endereco, Long idPessoa) {
        Optional<PessoaEntity> optionalPessoaEntity = pessoaRepository.findById(idPessoa);
        if (optionalPessoaEntity.isPresent()) {
            endereco.setPessoa(optionalPessoaEntity.get());
            return enderecoRepository.save(endereco);
        }
        throw new RuntimeException("Não existe pessoa com ID: " + idPessoa);
    }

    public List<EnderecoEntity> findByIdPessoa(Long idPessoa) {
        return enderecoRepository.findByIdPessoa(idPessoa);
    }
}
