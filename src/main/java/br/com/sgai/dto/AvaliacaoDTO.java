package br.com.sgai.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import br.com.sgai.domain.Avaliacao;
import br.com.sgai.domain.Evento;

public class AvaliacaoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String justificativa;
	private int rating;
	private LocalDateTime createdAt;
	private LocalDateTime updateAt;
	private Evento evento;

	public AvaliacaoDTO(Avaliacao obj) {
		this.id = obj.getId();
		this.rating = obj.getRating();
		this.justificativa = obj.getJustificativa();
		this.createdAt = obj.getCreatedAt();
		this.updateAt = obj.getupdatedAt();
		this.evento = obj.getEvento();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

}
