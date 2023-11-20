package br.com.sgai.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import br.com.sgai.domain.Evento;
import br.com.sgai.domain.Presenca;

public class PresencaDiscenteDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer idEvento;
	private Integer idPresenca;
	private String nomeAmbiente;
	private String nomeTurma;
	private String data;
	private String horaInicio;
	private String horaFim;
	private String situacao;
	private String entrada;
	private String saida;
	
	

	public PresencaDiscenteDTO() {
		
	}
	
	public PresencaDiscenteDTO(Evento evento, Presenca presenca) {
		
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        SimpleDateFormat sdg = new SimpleDateFormat("dd/MM/yyyy");
		
		this.idEvento = evento.getId();
		this.idPresenca = presenca.getId() != null ? presenca.getId() : 0;
		this.data = sdg.format(evento.getDataEvento());
		this.horaInicio = sdf.format(evento.getHoraInicio()) + "h";
		this.horaFim = sdf.format(evento.getHoraFim()) + "h";
		this.nomeTurma = evento.getTurma().getNome();
		this.nomeAmbiente = evento.getAmbiente().getNome();
		this.situacao = presenca.getSituacao();
		this.entrada = presenca.getId() != null & presenca.getHoraInicio() != null  ? sdf.format(presenca.getHoraInicio()) + "h" : "";
		this.saida = presenca.getId() != null & presenca.getHoraFim() != null ? sdf.format(presenca.getHoraFim()) + "h" : "";
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

	public Integer getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Integer idEvento) {
		this.idEvento = idEvento;
	}

	public Integer getIdPresenca() {
		return idPresenca;
	}

	public void setIdPresenca(Integer idPresenca) {
		this.idPresenca = idPresenca;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getEntrada() {
		return entrada;
	}

	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}

	public String getSaida() {
		return saida;
	}

	public void setSaida(String saida) {
		this.saida = saida;
	}

}
