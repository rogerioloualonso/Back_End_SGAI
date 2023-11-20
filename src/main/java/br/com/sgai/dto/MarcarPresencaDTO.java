package br.com.sgai.dto;

import java.io.Serializable;

import br.com.sgai.domain.Avaliacao;

public class MarcarPresencaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer idPresenca;
	private String comentario;
	private Integer rating;

	
	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Integer getIdPresenca() {
		return idPresenca;
	}

	public void setIdPresenca(Integer idPresenca) {
		this.idPresenca = idPresenca;
	}

}
