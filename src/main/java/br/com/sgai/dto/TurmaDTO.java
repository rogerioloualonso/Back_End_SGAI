package br.com.sgai.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.sgai.domain.Docente;
import br.com.sgai.domain.Evento;
import br.com.sgai.domain.Turma;

@JsonIgnoreProperties({"docente", "evento"})
public class TurmaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String turno;
	private String situacao;
	private Docente docente;
	private List<Evento> evento;

	public TurmaDTO(Turma obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.turno = obj.getTurno();
		this.situacao = obj.getSituacao();
		this.docente = obj.getDocente();
		this.evento = obj.getEvento();
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

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public List<Evento> getEvento() {
		return evento;
	}

	public void setEvento(List<Evento> evento) {
		this.evento = evento;
	}

}
