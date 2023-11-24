package br.com.fiap.global.model.entity;

import java.time.LocalDate;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public class Consulta extends Prontuario{
	private Long idConsulta;
	@PastOrPresent
	@FutureOrPresent
	private LocalDate dataDaConsulta;
	private String horaDaConsulta;
	@NotNull
	private String descricaoMotivo;
	@NotNull
	private String descricaoSintomas;
	@NotNull
	private String descricaoDiagnstico;
	public Consulta() {
	}
	public Consulta(Long idCadastro, @NotNull String nome, @PastOrPresent LocalDate dataDeNascimentol,
			@NotNull String genero, @NotNull String cep, @NotNull String descricaoLogradouro,
			@NotNull int numeroLogradouro, @NotNull String nomeCidade, @NotNull String nomeEstado,
			@NotNull String numeroTelefone, @NotNull String descricaoEmail, @NotNull String tipoDocumento) {
		super(idCadastro, nome, dataDeNascimentol, genero, cep, descricaoLogradouro, numeroLogradouro, nomeCidade, nomeEstado,
				numeroTelefone, descricaoEmail, tipoDocumento);
	}
	public Consulta(Long idCadastroPaciente, @NotNull String cpf, @NotNull String tipoSanguineo,
			@NotNull String nomeSeguro, @NotNull String numeroSeguro, @NotNull String descricaoAlergia,
			@NotNull String doencasCronicas, @NotNull String cirurgiasRealizadas) {
		super(idCadastroPaciente, cpf, tipoSanguineo, nomeSeguro, numeroSeguro, descricaoAlergia, doencasCronicas,
				cirurgiasRealizadas);
	}
	public Consulta(@NotNull @NotNull Long idProntuario) {
		super(idProntuario);
	}
	public Consulta(Long idConsulta, @PastOrPresent @FutureOrPresent LocalDate dataDaConsulta, String horaDaConsulta,
			@NotNull String descricaoMotivo, @NotNull String descricaoSintomas, @NotNull String descricaoDiagnstico) {
		this.idConsulta = idConsulta;
		this.dataDaConsulta = dataDaConsulta;
		this.horaDaConsulta = horaDaConsulta;
		this.descricaoMotivo = descricaoMotivo;
		this.descricaoSintomas = descricaoSintomas;
		this.descricaoDiagnstico = descricaoDiagnstico;
	}
	public Long getIdConsulta() {
		return idConsulta;
	}
	public void setIdConsulta(Long idConsulta) {
		this.idConsulta = idConsulta;
	}
	public LocalDate getDataDaConsulta() {
		return dataDaConsulta;
	}
	public void setDataDaConsulta(LocalDate dataDaConsulta) {
		this.dataDaConsulta = dataDaConsulta;
	}
	public String getHoraDaConsulta() {
		return horaDaConsulta;
	}
	public void setHoraDaConsulta(String horaDaConsulta) {
		this.horaDaConsulta = horaDaConsulta;
	}
	public String getDescricaoMotivo() {
		return descricaoMotivo;
	}
	public void setDescricaoMotivo(String descricaoMotivo) {
		this.descricaoMotivo = descricaoMotivo;
	}
	public String getDescricaoSintomas() {
		return descricaoSintomas;
	}
	public void setDescricaoSintomas(String descricaoSintomas) {
		this.descricaoSintomas = descricaoSintomas;
	}
	public String getDescricaoDiagnstico() {
		return descricaoDiagnstico;
	}
	public void setDescricaoDiagnstico(String descricaoDiagnstico) {
		this.descricaoDiagnstico = descricaoDiagnstico;
	}
	
	
}
