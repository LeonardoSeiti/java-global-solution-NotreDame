package br.com.fiap.global.model.entity;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public class ContatoEmergencia extends Paciente {
	private Long idContatoEmergencia;
	@NotNull
	private String nomeEmergencial;
	@NotNull
	private String numeroDeTelefone;
	@NotNull
	private String descricaoFiliacao;

	public ContatoEmergencia() {
	}

	public ContatoEmergencia(Long idCadastro, @NotNull String nome, @PastOrPresent LocalDate dataDeNascimentol,
			@NotNull String genero, @NotNull String cep, @NotNull String descricaoLogradouro,
			@NotNull int numeroLogradouro, @NotNull String nomeCidade, @NotNull String nomeEstado,
			@NotNull String numeroTelefone, @NotNull String descricaoEmail, @NotNull String tipoDocumento) {
		super(idCadastro, nome, dataDeNascimentol, genero, cep, descricaoLogradouro, numeroLogradouro, nomeCidade,
				nomeEstado, numeroTelefone, descricaoEmail, tipoDocumento);
	}

	public ContatoEmergencia(Long idCadastroPaciente, @NotNull String cpf, @NotNull String tipoSanguineo,
			@NotNull String nomeSeguro, @NotNull String numeroSeguro, @NotNull String descricaoAlergia,
			@NotNull String doencasCronicas, @NotNull String cirurgiasRealizadas) {
		super(idCadastroPaciente, cpf, tipoSanguineo, nomeSeguro, numeroSeguro, descricaoAlergia, doencasCronicas,
				cirurgiasRealizadas);
	}

	public ContatoEmergencia(Long idContatoEmergencia, @NotNull String nomeEmergencial,
			@NotNull String numeroDeTelefone, @NotNull String descricaoFiliacao) {
		this.idContatoEmergencia = idContatoEmergencia;
		this.nomeEmergencial = nomeEmergencial;
		this.numeroDeTelefone = numeroDeTelefone;
		this.descricaoFiliacao = descricaoFiliacao;
	}

	public Long getIdContatoEmergencia() {
		return idContatoEmergencia;
	}

	public void setIdContatoEmergencia(Long idContatoEmergencia) {
		this.idContatoEmergencia = idContatoEmergencia;
	}

	public String getNomeEmergencial() {
		return nomeEmergencial;
	}

	public void setNomeEmergencial(String nomeEmergencial) {
		this.nomeEmergencial = nomeEmergencial;
	}

	public String getNumeroDeTelefone() {
		return numeroDeTelefone;
	}

	public void setNumeroDeTelefone(String numeroDeTelefone) {
		this.numeroDeTelefone = numeroDeTelefone;
	}

	public String getDescricaoFiliacao() {
		return descricaoFiliacao;
	}

	public void setDescricaoFiliacao(String descricaoFiliacao) {
		this.descricaoFiliacao = descricaoFiliacao;
	}

}