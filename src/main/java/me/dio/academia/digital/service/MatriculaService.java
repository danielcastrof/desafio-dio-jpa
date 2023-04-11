package me.dio.academia.digital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.academia.digital.dto.MatriculaDTO;
import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.MatriculaRepository;

@Service
public class MatriculaService {

  @Autowired
  private MatriculaRepository matriculaRepository;

  @Autowired
  private AlunoRepository alunoRepository;

  public Matricula create(MatriculaDTO form) {
    Matricula matricula = new Matricula();
    Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();

    matricula.setAluno(aluno);

    return matriculaRepository.save(matricula);
  }

  public Matricula get(Long id) {
    return matriculaRepository.findById(id).get();
  }

  public List<Matricula> getAll(String bairro) {

    if (bairro == null) {
      return matriculaRepository.findAll();
    } else {
      return matriculaRepository.findAlunosMatriculadosBairro(bairro);
    }

  }

  public void delete(Long id) {
    if (matriculaRepository.findById(id).isEmpty()) {
      throw new RuntimeException("Matrícula não encontrada");
    } else {
      matriculaRepository.deleteById(id);
    }
  }

}
