package br.com.teste.mysqlrest.external.database.dao;

import br.com.teste.mysqlrest.external.database.entities.EnderecoEntity;
import br.com.teste.mysqlrest.external.database.entities.PessoaEntity;
import br.com.teste.mysqlrest.external.database.repositories.EnderecoRepository;
import br.com.teste.mysqlrest.external.database.repositories.PessoaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class PessoaDAO {

    private final EnderecoRepository enderecoRepository;

    private final PessoaRepository pessoaRepository;

    public PessoaDAO(EnderecoRepository enderecoRepository, PessoaRepository pessoaRepository) {
        this.enderecoRepository = enderecoRepository;
        this.pessoaRepository = pessoaRepository;
    }

    public PessoaEntity criaPessoa(PessoaEntity pessoaEntity) {
        List<EnderecoEntity> enderecosEntity = pessoaEntity.getEnderecos();

        pessoaEntity.setEnderecos(Collections.emptyList());

        pessoaEntity = pessoaRepository.save(pessoaEntity);

        if (!enderecosEntity.isEmpty()) {
            enderecosEntity = criarEnderecos(enderecosEntity, pessoaEntity);
            pessoaEntity.setEnderecos(enderecosEntity);
        }
        return pessoaEntity;
    }

    @Transactional
    public PessoaEntity atualizaPessoa(PessoaEntity pessoaEntity) {
        List<EnderecoEntity> enderecosEntity = pessoaEntity.getEnderecos();

        pessoaEntity.setEnderecos(Collections.emptyList());

        PessoaEntity pessoaTransient = pessoaRepository.save(pessoaEntity);

        if (!enderecosEntity.isEmpty())
            substituiEnderecosPorPessoa(enderecosEntity, pessoaTransient);

        return pessoaTransient;
    }

    public PessoaEntity getPessoaById(Long idPessoa) {
        Optional<PessoaEntity> optionalPessoaEntity = pessoaRepository.findById(idPessoa);
        if (optionalPessoaEntity.isPresent()) {
            return optionalPessoaEntity.get();
        }
        throw new RuntimeException("Não existe pessoa com ID: " + idPessoa);
    }

    public List<PessoaEntity> findAll() {
        return pessoaRepository.findAll();
    }

    private List<EnderecoEntity> criarEnderecos(List<EnderecoEntity> enderecos, PessoaEntity pessoa) {
        List<EnderecoEntity> enderecosEntity = new ArrayList<>();
        enderecos.forEach(enderecoEntity -> enderecoEntity.setPessoa(pessoa));
        enderecoRepository.saveAll(enderecos).forEach(enderecosEntity::add);
        return enderecosEntity;
    }

    private void substituiEnderecosPorPessoa(List<EnderecoEntity> enderecosEntity, PessoaEntity pessoaTransient) {
        enderecoRepository.deleteByIdPessoa(pessoaTransient.getId());
        enderecosEntity = criarEnderecos(enderecosEntity, pessoaTransient);
        pessoaTransient.setEnderecos(enderecosEntity);
    }

}
