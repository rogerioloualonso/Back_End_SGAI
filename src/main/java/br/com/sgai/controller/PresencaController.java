package br.com.sgai.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sgai.domain.Presenca;
import br.com.sgai.dto.PresencaDTO;
import br.com.sgai.service.PresencaService;

@RestController
@RequestMapping(value = "/presenca")
public class PresencaController {
    
    @Autowired
    PresencaService Service;

    @GetMapping(value = "/byDiscente/{id}")
    public ResponseEntity<List<PresencaDTO>> getPresencasByIdDiscente(@PathVariable int id) {
        List<Presenca> presenca = Service.findAllByIdDiscente(id);
        List<PresencaDTO> listDTO = presenca.stream().map(obj -> new PresencaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
    }
    
    @DeleteMapping(value = "/excluir/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
    	Service.delete(id);
		return ResponseEntity.noContent().build();
	}

    
}
