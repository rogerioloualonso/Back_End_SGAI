package br.com.sgai.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import br.com.sgai.domain.Presenca;

public class PresencaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nomeDiscente;
	private String matricula;
	private String inicio;
	private String fim;
	private String situacao;

	public PresencaDTO() {
		
	}
	
	public PresencaDTO(Presenca obj) {
		
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		
		this.id = obj.getId();
		this.nomeDiscente = obj.getDiscente().getNome();
		this.matricula = obj.getDiscente().getMatricula();
		this.inicio = obj.getHoraInicio() != null ? sdf.format(obj.getHoraInicio()) + "h" : "";
		this.situacao = obj.getSituacao();
		this.fim = obj.getHoraFim() != null ? sdf.format(obj.getHoraFim()) + "h" : "";
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

	public String getNomeDiscente() {
		return nomeDiscente;
	}

	public void setNomeDiscente(String nomeDiscente) {
		this.nomeDiscente = nomeDiscente;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getInicio() {
		return inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	public String getFim() {
		return fim;
	}

	public void setFim(String fim) {
		this.fim = fim;
	}

}
