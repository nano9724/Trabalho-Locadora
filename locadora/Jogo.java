package locadora;

import java.io.Serializable;

public class Jogo implements Serializable{
	private String nome, tipo;
	private int classificacao;
	private double preco;

	Jogo(String nome, String tipo, int classificao, double preco){
		this.nome=nome;
		this.tipo=tipo;
		this.classificacao=classificao;
		this.preco=preco;
	}

	Jogo(){

	}

	public String getNome() {
		return this.nome;
	}
	public String getTipo() {
		return this.tipo;
	}
	public int getClassificacao() {
		return this.classificacao;
	}
	public double getPreco() {
		return this.preco;
	}
}
