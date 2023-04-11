package me.dio.academia.digital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.academia.digital.dto.AvaliacaoFisicaDTO;
import me.dio.academia.digital.dto.AvaliacaoFisicaUpdateDTO;
import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.AvaliacaoFisicaRepository;

@Service
public class AvaliacaoFisicaService {
  @Autowired
  private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

  @Autowired
  private AlunoRepository alunoRepository;

  public AvaliacaoFisica create(AvaliacaoFisicaDTO form) {
    AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
    Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();

    avaliacaoFisica.setAluno(aluno);
    avaliacaoFisica.setPeso(form.getPeso());
    avaliacaoFisica.setAltura(form.getAltura());

    return avaliacaoFisicaRepository.save(avaliacaoFisica);
  }

  public AvaliacaoFisica get(Long id) {
    return avaliacaoFisicaRepository.findById(id).get();
  }

  public List<AvaliacaoFisica> getAll() {

    return avaliacaoFisicaRepository.findAll();
  }

  public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateDTO formUpdate) {
    return avaliacaoFisicaRepository.findById(id).map(avaliacaoFisica -> {
      avaliacaoFisica.setPeso(formUpdate.getPeso());
      avaliacaoFisica.setAltura(formUpdate.getAltura());
      return avaliacaoFisicaRepository.save(avaliacaoFisica);
    }).get();
  }

  public void delete(Long id) {
    if (avaliacaoFisicaRepository.findById(id).isEmpty()) {
      throw new RuntimeException("Avaliação Física não encontrada");
    } else {
      avaliacaoFisicaRepository.deleteById(id);
    }
  }
}
