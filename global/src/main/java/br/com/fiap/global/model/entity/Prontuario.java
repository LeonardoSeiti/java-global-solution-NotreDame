package br.com.fiap.global.model.entity;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public class Prontuario extends Paciente {
	@NotNull
	private Long idProntuario;

	public Prontuario() {
	}

	public Prontuario(Long idCadastro, @NotNull String nome, @PastOrPresent LocalDate dataDeNascimentol,
			@NotNull String genero, @NotNull String cep, @NotNull String descricaoLogradouro,
			@NotNull int numeroLogradouro, @NotNull String nomeCidade, @NotNull String nomeEstado,
			@NotNull String numeroTelefone, @NotNull String descricaoEmail, @NotNull String tipoDocumento) {
		super(idCadastro, nome, dataDeNascimentol, genero, cep, descricaoLogradouro, numeroLogradouro, nomeCidade,
				nomeEstado, numeroTelefone, descricaoEmail, tipoDocumento);
	}

	public Prontuario(Long idCadastroPaciente, @NotNull String cpf, @NotNull String tipoSanguineo,
			@NotNull String nomeSeguro, @NotNull String numeroSeguro, @NotNull String descricaoAlergia,
			@NotNull String doencasCronicas, @NotNull String cirurgiasRealizadas) {
		super(idCadastroPaciente, cpf, tipoSanguineo, nomeSeguro, numeroSeguro, descricaoAlergia, doencasCronicas,
				cirurgiasRealizadas);
	}

	public Prontuario(@NotNull @NotNull Long idProntuario) {
		this.idProntuario = idProntuario;
	}

	public Long getIdProntuario() {
		return idProntuario;
	}

	public void setIdProntuario(@NotNull Long idProntuario) {
		this.idProntuario = idProntuario;
	}

}
