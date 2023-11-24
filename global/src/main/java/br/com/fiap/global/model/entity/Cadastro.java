package br.com.fiap.global.model.entity;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public class Cadastro {
	private Long idCadastro;
	@NotNull
	private String nome;
	@PastOrPresent
	private LocalDate dataDeNascimentol;
	@NotNull
	private String genero;
	@NotNull
	private String cep;
	@NotNull
	private String descricaoLogradouro;
	@NotNull
	private int numeroLogradouro;
	@NotNull
	private String nomeCidade;
	@NotNull
	private String nomeEstado;
	@NotNull
	private String numeroTelefone;
	@NotNull
	private String descricaoEmail;
	@NotNull
	private String tipoDocumento;
	
	public Cadastro() {
	}
	public Cadastro(Long idCadastro, @NotNull String nome, @PastOrPresent LocalDate dataDeNascimentol,
			@NotNull String genero, @NotNull String cep, @NotNull String descricaoLogradouro,
			@NotNull int numeroLogradouro, @NotNull String nomeCidade, @NotNull String nomeEstado,
			@NotNull String numeroTelefone, @NotNull String descricaoEmail, @NotNull String tipoDocumento) {
		this.idCadastro = idCadastro;
		this.nome = nome;
		this.dataDeNascimentol = dataDeNascimentol;
		this.genero = genero;
		this.cep = cep;
		this.descricaoLogradouro = descricaoLogradouro;
		this.numeroLogradouro = numeroLogradouro;
		this.nomeCidade = nomeCidade;
		this.nomeEstado = nomeEstado;
		this.numeroTelefone = numeroTelefone;
		this.descricaoEmail = descricaoEmail;
		this.tipoDocumento = tipoDocumento;
	}
	public Long getIdCadastro() {
		return idCadastro;
	}
	public void setIdCadastro(Long idCadastro) {
		this.idCadastro = idCadastro;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataDeNascimentol() {
		return dataDeNascimentol;
	}
	public void setDataDeNascimentol(LocalDate dataDeNascimentol) {
		this.dataDeNascimentol = dataDeNascimentol;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getDescricaoLogradouro() {
		return descricaoLogradouro;
	}
	public void setDescricaoLogradouro(String descricaoLogradouro) {
		this.descricaoLogradouro = descricaoLogradouro;
	}
	public int getNumeroLogradouro() {
		return numeroLogradouro;
	}
	public void setNumeroLogradouro(int numeroLogradouro) {
		this.numeroLogradouro = numeroLogradouro;
	}
	public String getNomeCidade() {
		return nomeCidade;
	}
	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}
	public String getNomeEstado() {
		return nomeEstado;
	}
	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}
	public String getNumeroTelefone() {
		return numeroTelefone;
	}
	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}
	public String getDescricaoEmail() {
		return descricaoEmail;
	}
	public void setDescricaoEmail(String descricaoEmail) {
		this.descricaoEmail = descricaoEmail;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	
}
