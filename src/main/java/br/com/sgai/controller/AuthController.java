package br.com.sgai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sgai.domain.Discente;
import br.com.sgai.domain.Docente;
import br.com.sgai.dto.LoginDTO;
import br.com.sgai.service.DiscenteService;
import br.com.sgai.service.DocenteService;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {
    
    @Autowired
    DiscenteService discenteService;
    @Autowired
    DocenteService docenteService;

    @PostMapping(value = "/discente")
    public boolean authDiscente(@RequestBody LoginDTO credentials) {
        Discente discente = discenteService.findAllByCpfAndSenha(credentials.getCpf(), credentials.getSenha());
        if(discente == null) {
        	return false;
        }else {
        	return true;
        }
    }
    
    @PostMapping(value = "/docente")
    public boolean authDocente(@RequestBody LoginDTO credentials) {
        Docente docente = docenteService.findAllByCpfAndSenha(credentials.getCpf(), credentials.getSenha());
        if(docente == null) {
        	return false;
        }else {
        	return true;
        }
    }
    
    
}
