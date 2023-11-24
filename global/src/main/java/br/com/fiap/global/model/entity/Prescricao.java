package br.com.fiap.global.model.entity;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public class Prescricao extends Prontuario {
	private Long idPrescricao;
	@NotNull
	private String diagnostico;
	@NotNull
	private String descricaoMedicamento;
	@NotNull
	private String descricaoPosologia;
	
	public Prescricao() {
	}
	public Prescricao(Long idCadastro, @NotNull String nome, @PastOrPresent LocalDate dataDeNascimentol,
			@NotNull String genero, @NotNull String cep, @NotNull String descricaoLogradouro,
			@NotNull int numeroLogradouro, @NotNull String nomeCidade, @NotNull String nomeEstado,
			@NotNull String numeroTelefone, @NotNull String descricaoEmail, @NotNull String tipoDocumento) {
		super(idCadastro, nome, dataDeNascimentol, genero, cep, descricaoLogradouro, numeroLogradouro, nomeCidade, nomeEstado,
				numeroTelefone, descricaoEmail, tipoDocumento);
	}
	public Prescricao(Long idCadastroPaciente, @NotNull String cpf, @NotNull String tipoSanguineo,
			@NotNull String nomeSeguro, @NotNull String numeroSeguro, @NotNull String descricaoAlergia,
			@NotNull String doencasCronicas, @NotNull String cirurgiasRealizadas) {
		super(idCadastroPaciente, cpf, tipoSanguineo, nomeSeguro, numeroSeguro, descricaoAlergia, doencasCronicas,
				cirurgiasRealizadas);
	}
	public Prescricao(@NotNull @NotNull Long idProntuario) {
		super(idProntuario);
	}
	public Prescricao(Long idPrescricao, @NotNull String diagnostico, @NotNull String descricaoMedicamento,
			@NotNull String descricaoPosologia) {
		this.idPrescricao = idPrescricao;
		this.diagnostico = diagnostico;
		this.descricaoMedicamento = descricaoMedicamento;
		this.descricaoPosologia = descricaoPosologia;
	}
	public Long getIdPrescricao() {
		return idPrescricao;
	}
	public void setIdPrescricao(Long idPrescricao) {
		this.idPrescricao = idPrescricao;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public String getDescricaoMedicamento() {
		return descricaoMedicamento;
	}
	public void setDescricaoMedicamento(String descricaoMedicamento) {
		this.descricaoMedicamento = descricaoMedicamento;
	}
	public String getDescricaoPosologia() {
		return descricaoPosologia;
	}
	public void setDescricaoPosologia(String descricaoPosologia) {
		this.descricaoPosologia = descricaoPosologia;
	}

	
}