package br.com.sgai.dto;

import java.io.Serializable;
import java.sql.Time;
import java.text.SimpleDateFormat;

import br.com.sgai.domain.Evento;

public class EventoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nomeAmbiente;
	private String nomeTurma;
	private String data;
	private String horaInicio;
	private String horaFim;
	private String situacao;
	
	

	public EventoDTO() {
		
	}
	
	public EventoDTO(Evento obj) {
		
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        SimpleDateFormat sdg = new SimpleDateFormat("dd/MM/yyyy");
		
		this.id = obj.getId();
		this.data = sdg.format(obj.getDataEvento());
		this.horaInicio = sdf.format(obj.getHoraInicio()) + "h";
		this.horaFim = sdf.format(obj.getHoraFim()) + "h";
		this.situacao = obj.getSituacao();
		this.nomeTurma = obj.getTurma().getNome();
		this.nomeAmbiente = obj.getAmbiente().getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getNomeAmbiente() {
		return nomeAmbiente;
	}

	public void setNomeAmbiente(String nomeAmbiente) {
		this.nomeAmbiente = nomeAmbiente;
	}

	public String getNomeTurma() {
		return nomeTurma;
	}

	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(String horaFim) {
		this.horaFim = horaFim;
	}

}
