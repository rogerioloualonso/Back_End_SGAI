package br.com.sgai.dto;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import br.com.sgai.domain.Evento;

public class EventonewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer idAmbiente;
	private Integer idTurma;
	private Date data;
	private Time horaInicio;
	private Time horaFim;
	private String Situacao;
	
	

	public EventonewDTO() {
		
	}
	
	
	public EventonewDTO(Evento obj) {
		this.id = obj.getId();
		this.data = obj.getDataEvento();
		this.horaInicio = obj.getHoraInicio();
		this.horaFim = obj.getHoraFim();
		this.Situacao = obj.getSituacao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	public Time getHoraInicio() {
		return horaInicio;
	}


	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}


	public Time getHoraFim() {
		return horaFim;
	}


	public void setHoraFim(Time horaFim) {
		this.horaFim = horaFim;
	}


	public String getSituacao() {
		return Situacao;
	}


	public void setSituacao(String situacao) {
		Situacao = situacao;
	}

	public Integer getIdAmbiente() {
		return idAmbiente;
	}


	public void setIdAmbiente(Integer idAmbiente) {
		this.idAmbiente = idAmbiente;
	}


	public Integer getIdTurma() {
		return idTurma;
	}


	public void setIdTurma(Integer idTurma) {
		this.idTurma = idTurma;
	}
	

}
