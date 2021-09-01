
package pessoa;

public abstract class Pessoa{
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


}
