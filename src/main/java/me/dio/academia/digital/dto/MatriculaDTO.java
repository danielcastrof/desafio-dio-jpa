package me.dio.academia.digital.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class MatriculaDTO {

  public MatriculaDTO(Long alunoId) {
    this.alunoId = alunoId;
  }

  public MatriculaDTO() {
  }

  @NotNull(message = "Preencha o campo corretamente.")
  @Positive(message = "O Id do aluno precisa ser positivo.")
  private Long alunoId;

  public Long getAlunoId() {
    return alunoId;
  }

  public void setAlunoId(Long alunoId) {
    this.alunoId = alunoId;
  }
}
