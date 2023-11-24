package br.com.fiap.global.model.entity;

import java.time.LocalDate;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public class Tarefa extends Prontuario{
	private Long idTarefa;
	@NotNull
	private String descricaoTarefa;
	@PastOrPresent
	private LocalDate dataInicioTerefa;
	@FutureOrPresent
	private LocalDate dataFimTarefa;
	@NotNull
	private String descricaoProcedimento;
	
	public Tarefa() {
	}
	public Tarefa(Long idCadastro, @NotNull String nome, @PastOrPresent LocalDate dataDeNascimentol,
			@NotNull String genero, @NotNull String cep, @NotNull String descricaoLogradouro,
			@NotNull int numeroLogradouro, @NotNull String nomeCidade, @NotNull String nomeEstado,
			@NotNull String numeroTelefone, @NotNull String descricaoEmail, @NotNull String tipoDocumento) {
		super(idCadastro, nome, dataDeNascimentol, genero, cep, descricaoLogradouro, numeroLogradouro, nomeCidade, nomeEstado,
				numeroTelefone, descricaoEmail, tipoDocumento);
	}
	public Tarefa(Long idCadastroPaciente, @NotNull String cpf, @NotNull String tipoSanguineo,
			@NotNull String nomeSeguro, @NotNull String numeroSeguro, @NotNull String descricaoAlergia,
			@NotNull String doencasCronicas, @NotNull String cirurgiasRealizadas) {
		super(idCadastroPaciente, cpf, tipoSanguineo, nomeSeguro, numeroSeguro, descricaoAlergia, doencasCronicas,
				cirurgiasRealizadas);
	}
	public Tarefa(@NotNull @NotNull Long idProntuario) {
		super(idProntuario);
	}
	public Tarefa(Long idTarefa, @NotNull String descricaoTarefa, @PastOrPresent LocalDate dataInicioTerefa,
			@FutureOrPresent LocalDate dataFimTarefa, @NotNull String descricaoProcedimento) {
		this.idTarefa = idTarefa;
		this.descricaoTarefa = descricaoTarefa;
		this.dataInicioTerefa = dataInicioTerefa;
		this.dataFimTarefa = dataFimTarefa;
		this.descricaoProcedimento = descricaoProcedimento;
	}
	public Long getIdTarefa() {
		return idTarefa;
	}
	public void setIdTarefa(Long idTarefa) {
		this.idTarefa = idTarefa;
	}
	public String getDescricaoTarefa() {
		return descricaoTarefa;
	}
	public void setDescricaoTarefa(String descricaoTarefa) {
		this.descricaoTarefa = descricaoTarefa;
	}
	public LocalDate getDataInicioTerefa() {
		return dataInicioTerefa;
	}
	public void setDataInicioTerefa(LocalDate dataInicioTerefa) {
		this.dataInicioTerefa = dataInicioTerefa;
	}
	public LocalDate getDataFimTarefa() {
		return dataFimTarefa;
	}
	public void setDataFimTarefa(LocalDate dataFimTarefa) {
		this.dataFimTarefa = dataFimTarefa;
	}
	public String getDescricaoProcedimento() {
		return descricaoProcedimento;
	}
	public void setDescricaoProcedimento(String descricaoProcedimento) {
		this.descricaoProcedimento = descricaoProcedimento;
	}
	
	

}
