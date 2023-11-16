package br.com.sgai.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import br.com.sgai.domain.Ambiente;
import br.com.sgai.domain.Evento;

public class AmbienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String descricao;
	private Integer capacidade;
	private String tipo;
	private String situacao;
	private LocalDateTime createdAt;
	private LocalDateTime updateAt;
	private List<Evento> eventos;

	public AmbienteDTO(Ambiente obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.descricao = obj.getDescricao();
		this.capacidade = obj.getCapacidade();
		this.tipo = obj.getTipo();
		this.situacao = obj.getSituacao();
		this.createdAt = obj.getCreatedAt();
		this.updateAt = obj.getUpdatedAt();
		this.eventos = obj.getEventos();
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

}
