package br.com.fiap.global.model.entity;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public class Paciente extends Cadastro {
	private Long idCadastroPaciente;
	@NotNull
	private String cpf;
	@NotNull
	private String tipoSanguineo;
	@NotNull
	private String nomeSeguro;
	@NotNull
	private String numeroSeguro;
	@NotNull
	private String descricaoAlergia;
	@NotNull
	private String doencasCronicas;
	@NotNull
	private String cirurgiasRealizadas;

	public Paciente() {
	}

	public Paciente(Long idCadastro, @NotNull String nome, @PastOrPresent LocalDate dataDeNascimentol,
			@NotNull String genero, @NotNull String cep, @NotNull String descricaoLogradouro,
			@NotNull int numeroLogradouro, @NotNull String nomeCidade, @NotNull String nomeEstado,
			@NotNull String numeroTelefone, @NotNull String descricaoEmail, @NotNull String tipoDocumento) {
		super(idCadastro, nome, dataDeNascimentol, genero, cep, descricaoLogradouro, numeroLogradouro, nomeCidade,
				nomeEstado, numeroTelefone, descricaoEmail, tipoDocumento);
	}

	public Paciente(Long idCadastroPaciente, @NotNull String cpf, @NotNull String tipoSanguineo,
			@NotNull String nomeSeguro, @NotNull String numeroSeguro, @NotNull String descricaoAlergia,
			@NotNull String doencasCronicas, @NotNull String cirurgiasRealizadas) {
		this.idCadastroPaciente = idCadastroPaciente;
		this.cpf = cpf;
		this.tipoSanguineo = tipoSanguineo;
		this.nomeSeguro = nomeSeguro;
		this.numeroSeguro = numeroSeguro;
		this.descricaoAlergia = descricaoAlergia;
		this.doencasCronicas = doencasCronicas;
		this.cirurgiasRealizadas = cirurgiasRealizadas;
	}

	public Long getIdCadastroPaciente() {
		return idCadastroPaciente;
	}

	public void setIdCadastroPaciente(Long idCadastroPaciente) {
		this.idCadastroPaciente = idCadastroPaciente;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTipoSanguineo() {
		return tipoSanguineo;
	}

	public void setTipoSanguineo(String tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}

	public String getNomeSeguro() {
		return nomeSeguro;
	}

	public void setNomeSeguro(String nomeSeguro) {
		this.nomeSeguro = nomeSeguro;
	}

	public String getNumeroSeguro() {
		return numeroSeguro;
	}

	public void setNumeroSeguro(String numeroSeguro) {
		this.numeroSeguro = numeroSeguro;
	}

	public String getDescricaoAlergia() {
		return descricaoAlergia;
	}

	public void setDescricaoAlergia(String descricaoAlergia) {
		this.descricaoAlergia = descricaoAlergia;
	}

	public String getDoencasCronicas() {
		return doencasCronicas;
	}

	public void setDoencasCronicas(String doencasCronicas) {
		this.doencasCronicas = doencasCronicas;
	}

	public String getCirurgiasRealizadas() {
		return cirurgiasRealizadas;
	}

	public void setCirurgiasRealizadas(String cirurgiasRealizadas) {
		this.cirurgiasRealizadas = cirurgiasRealizadas;
	}

}
