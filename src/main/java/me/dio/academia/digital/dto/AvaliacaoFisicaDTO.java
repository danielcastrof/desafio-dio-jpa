package me.dio.academia.digital.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class AvaliacaoFisicaDTO {

  public AvaliacaoFisicaDTO(Long alunoId, double peso, double altura) {
    this.alunoId = alunoId;
    this.peso = peso;
    this.altura = altura;
  }

  public AvaliacaoFisicaDTO() {
  }

  @NotNull(message = "Preencha o campo corretamente.")
  @Positive(message = "O Id do aluno precisa ser positivo.")
  private Long alunoId;

  @NotNull(message = "Preencha o campo corretamente.")
  @Positive(message = "${validatedValue}' precisa ser positivo.")
  private double peso;

  @NotNull(message = "Preencha o campo corretamente.")
  @Positive(message = "${validatedValue}' precisa ser positivo.")
  @DecimalMin(value = "150", message = "'${validatedValue}' precisa ser no mínimo {value}.")
  private double altura;

  public Long getAlunoId() {
    return alunoId;
  }

  public void setAlunoId(Long alunoId) {
    this.alunoId = alunoId;
  }

  public double getPeso() {
    return peso;
  }

  public void setPeso(double peso) {
    this.peso = peso;
  }

  public double getAltura() {
    return altura;
  }

  public void setAltura(double altura) {
    this.altura = altura;
  }
}
