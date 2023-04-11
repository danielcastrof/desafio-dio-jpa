package me.dio.academia.digital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.dio.academia.digital.dto.AvaliacaoFisicaDTO;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.service.AvaliacaoFisicaService;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

  @Autowired
  private AvaliacaoFisicaService service;

  @PostMapping
  public AvaliacaoFisica create(@RequestBody AvaliacaoFisicaDTO form) {
    return service.create(form);
  }

  @GetMapping
  public List<AvaliacaoFisica> getAll() {
    return service.getAll();
  }

}