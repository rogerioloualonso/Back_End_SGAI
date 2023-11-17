package br.com.sgai.domain;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@SuppressWarnings("deprecation")
public class Turma implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne(optional =false,fetch = FetchType.LAZY)
	@JoinColumn(name = "id_docente")
	@JsonIgnore
	private Docente docente;
	private String turno;
	private String situacao;
	private String nome;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'z'", timezone = "GMT-3")
	private LocalDateTime createdAt;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'z'", timezone = "GMT-3")
	private LocalDateTime updatedAt;
	
	@OneToMany(mappedBy = "turma", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@LazyToOne(LazyToOneOption.NO_PROXY)
	private List<Evento> evento;
	
	@ManyToMany
    @JoinTable(
        name = "matriculado",
        joinColumns = @JoinColumn(name = "id_turma"),
        inverseJoinColumns = @JoinColumn(name = "id_discente")
    )
    private List<Discente> discentes;


	public Turma() {

	}
	
	public Turma(Integer id, Docente docente, String turno, String situacao, String nome, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.docente = docente;
		this.turno = turno;
		this.situacao = situacao;
		this.nome = nome;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Evento> getEvento() {
		return evento;
	}

	public void setEvento(List<Evento> evento) {
		this.evento = evento;
	}
	
	public List<Discente> getDiscentes() {
		return discentes;
	}

	public void setDiscentes(List<Discente> discentes) {
		this.discentes = discentes;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Turma that = (Turma) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}
