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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@SuppressWarnings("deprecation")
public class Evento implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne(optional =false,fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ambiente")
	@JsonIgnore
	private Ambiente ambiente;
	@ManyToOne(optional =false,fetch = FetchType.LAZY)
	@JoinColumn(name = "id_turma")
	@JsonIgnore
	private Turma turma;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'z'", timezone = "GMT-3")
	private LocalDateTime createdAt;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'z'", timezone = "GMT-3")
	private LocalDateTime updatedAt;
	
	@OneToMany(mappedBy = "evento", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@LazyToOne(LazyToOneOption.NO_PROXY)
	private List<Presenca> presenca;

	public Evento() {

	}

	public Evento(Integer id, Ambiente ambiente, Turma turma,
			LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.ambiente = ambiente;
		this.turma = turma;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Ambiente getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getupdatedAt() {
		return updatedAt;
	}

	public void setupdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Presenca> getPresenca() {
		return presenca;
	}

	public void setPresenca(List<Presenca> presenca) {
		this.presenca = presenca;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Evento that = (Evento) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}
