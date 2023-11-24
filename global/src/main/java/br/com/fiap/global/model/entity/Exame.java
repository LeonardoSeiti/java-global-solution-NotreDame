package br.com.fiap.global.model.entity;

import java.time.LocalDate;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public class Exame extends Prontuario {
	private Long idExame;
	@NotNull
	private String descricaoTipoExame;
	@PastOrPresent
	@FutureOrPresent
	private LocalDate dataDoExame;

	public Exame() {

	}

	public Exame(Long idCadastro, @NotNull String nome, @PastOrPresent LocalDate dataDeNascimentol,
			@NotNull String genero, @NotNull String cep, @NotNull String descricaoLogradouro,
			@NotNull int numeroLogradouro, @NotNull String nomeCidade, @NotNull String nomeEstado,
			@NotNull String numeroTelefone, @NotNull String descricaoEmail, @NotNull String tipoDocumento) {
		super(idCadastro, nome, dataDeNascimentol, genero, cep, descricaoLogradouro, numeroLogradouro, nomeCidade,
				nomeEstado, numeroTelefone, descricaoEmail, tipoDocumento);

	}

	public Exame(Long idCadastroPaciente, @NotNull String cpf, @NotNull String tipoSanguineo,
			@NotNull String nomeSeguro, @NotNull String numeroSeguro, @NotNull String descricaoAlergia,
			@NotNull String doencasCronicas, @NotNull String cirurgiasRealizadas) {
		super(idCadastroPaciente, cpf, tipoSanguineo, nomeSeguro, numeroSeguro, descricaoAlergia, doencasCronicas,
				cirurgiasRealizadas);

	}

	public Exame(@NotNull @NotNull Long idProntuario) {
		super(idProntuario);

	}

	public Exame(Long idExame, @NotNull String descricaoTipoExame,
			@PastOrPresent @FutureOrPresent LocalDate dataDoExame) {
		this.idExame = idExame;
		this.descricaoTipoExame = descricaoTipoExame;
		this.dataDoExame = dataDoExame;
	}

	public Long getIdExame() {
		return idExame;
	}

	public void setIdExame(Long idExame) {
		this.idExame = idExame;
	}

	public String getDescricaoTipoExame() {
		return descricaoTipoExame;
	}

	public void setDescricaoTipoExame(String descricaoTipoExame) {
		this.descricaoTipoExame = descricaoTipoExame;
	}

	public LocalDate getDataDoExame() {
		return dataDoExame;
	}

	public void setDataDoExame(LocalDate dataDoExame) {
		this.dataDoExame = dataDoExame;
	}

}
