package locadora;

import java.io.Serializable;

public class Jogo implements Serializable{
	  String nome, tipo;
	  int classificao;

	  Jogo(String nome, String tipo, int classificao){
	    this.nome=nome;
	    this.tipo=tipo;
	    this.classificao=classificao;
	  }
	  
	  Jogo(){
		  
	  }
}
