package me.dio.academia.digital.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.academia.digital.dto.AlunoDTO;
import me.dio.academia.digital.dto.AlunoUpdateDTO;
import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.infra.utils.JavaTimeUtils;
import me.dio.academia.digital.repository.AlunoRepository;

@Service
public class AlunoService {

  @Autowired
  private AlunoRepository repository;

  public Aluno create(AlunoDTO form) {
    Aluno aluno = new Aluno();
    aluno.setNome(form.getNome());
    aluno.setCpf(form.getCpf());
    aluno.setBairro(form.getBairro());
    aluno.setDataDeNascimento(form.getDataDeNascimento());

    return repository.save(aluno);
  }

  public Aluno get(Long id) {
    return repository.findById(id).get();
  }

  public List<Aluno> getAll(String dataDeNascimento) {

    if (dataDeNascimento == null) {
      return repository.findAll();
    } else {
      LocalDate localDate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
      return repository.findByDataDeNascimento(localDate);
    }

  }

  public Aluno update(Long id, AlunoUpdateDTO formUpdate) {
    return repository.findById(id).map(aluno -> {
      aluno.setNome(formUpdate.getNome());
      aluno.setBairro(formUpdate.getBairro());
      aluno.setDataDeNascimento(formUpdate.getDataDeNascimento());
      return repository.save(aluno);
    }).get();
  }

  public void delete(Long id) {
    if (repository.findById(id).isEmpty()) {
      throw new RuntimeException("Aluno não encontrado");
    } else {
      repository.deleteById(id);
    }
  }

  public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id) {

    Aluno aluno = repository.findById(id).get();

    return aluno.getAvaliacoes();

  }
}
