package br.com.fiap.global.model.entity;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;


public class Medico extends Cadastro {
	private Long idCadastroMedico;
	@NotNull
	private String crm;
	@NotNull
	private String especialidade;
	public Medico() {
	}
	public Medico(Long idCadastro, @NotNull String nome, @PastOrPresent LocalDate dataDeNascimentol,
			@NotNull String genero, @NotNull String cep, @NotNull String descricaoLogradouro,
			@NotNull int numeroLogradouro, @NotNull String nomeCidade, @NotNull String nomeEstado,
			@NotNull String numeroTelefone, @NotNull String descricaoEmail, @NotNull String tipoDocumento) {
		super(idCadastro, nome, dataDeNascimentol, genero, cep, descricaoLogradouro, numeroLogradouro, nomeCidade, nomeEstado,
				numeroTelefone, descricaoEmail, tipoDocumento);
	}
	public Medico(Long idCadastroMedico, @NotNull String crm, @NotNull String especialidade) {
		this.idCadastroMedico = idCadastroMedico;
		this.crm = crm;
		this.especialidade = especialidade;
	}
	public Long getIdCadastroMedico() {
		return idCadastroMedico;
	}
	public void setIdCadastroMedico(Long idCadastroMedico) {
		this.idCadastroMedico = idCadastroMedico;
	}
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
}
	