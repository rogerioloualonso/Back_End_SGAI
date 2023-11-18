package br.com.sgai.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.sgai.domain.Discente;
import br.com.sgai.domain.Presenca;
import br.com.sgai.domain.Turma;

@JsonIgnoreProperties({"turma","presenca"})
public class DiscenteDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String cpf;
	private String telefone;
	private String matricula;
	private List<Presenca> presenca;
	private List<Turma> turma;

	public DiscenteDTO(Discente obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.telefone = obj.getTelefone();
		this.matricula = obj.getMatricula();
		this.presenca = obj.getPresenca();
		this.turma = obj.getTurmas();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public List<Presenca> getPresenca() {
		return presenca;
	}

	public void setPresenca(List<Presenca> presenca) {
		this.presenca = presenca;
	}

	public List<Turma> getTurma() {
		return turma;
	}

	public void setTurma(List<Turma> turma) {
		this.turma = turma;
	}
	

}
