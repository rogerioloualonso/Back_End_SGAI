package br.com.sgai.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sgai.domain.Turma;
import br.com.sgai.dto.TurmaDTO;
import br.com.sgai.service.TurmaService;

@RestController
@RequestMapping(value = "/turma")
public class TurmaController {
    
    @Autowired
    TurmaService turmaService;

    @GetMapping(value = "/byDocente/{id}")
    public ResponseEntity<List<TurmaDTO>> getTurmasById(@PathVariable int id) {
        List<Turma> turma = turmaService.findAllByIdDocente(id);
        List<TurmaDTO> listDTO = turma.stream().map(obj -> new TurmaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
    }
    
}
