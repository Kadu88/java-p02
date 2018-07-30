package br.com.carlosbarros.byteBank.model;

public class Cliente {

	String nome;
	String cpf;
	String profissao;
	
	public Cliente() {
		this("N�o informado");
	}
	
	public Cliente(String nome) {
		this(nome, "N�o informado", "N�o informado");
	}
	
	public Cliente(String nome, String cpf, String profissao) {
		this.nome = nome;
		this.cpf = cpf;
		this.profissao = profissao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	
	
}
