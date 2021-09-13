package locadora;

import java.io.Serializable;

public class Jogo implements Serializable{
	  String nome, tipo;
	  int classificao;
	  double preco;

	  Jogo(String nome, String tipo, int classificao, double preco){
	    this.nome=nome;
	    this.tipo=tipo;
	    this.classificao=classificao;
	    this.preco=preco;
	  }
	  
	  Jogo(){
		  
	  }
}
