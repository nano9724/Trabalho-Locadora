package pessoa;

import java.io.Serializable;

public abstract class Pessoa implements Serializable{
	private String nome;
	private String cpf;
	private String login;
	private String senha;

	Pessoa(String nome, String cpf, String login, String senha){
	  this.nome=nome;
	  this.cpf=cpf;
	  this.login=login;
	  this.senha=senha;
	}

	Pessoa(){
		
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}
	public String getCpf() {
		return cpf;
	}
}
