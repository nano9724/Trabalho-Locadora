package pessoa;

public abstract class Pessoa{
	private String nome;
	private int cpf;
	private String login;
	private String senha;

	Pessoa(String nome, int cpf, String login, String senha){
	  this.nome=nome;
	  this.cpf=cpf;
	  this.login=login;
	  this.senha=senha;
	}


}
