package pessoa;


public class Conta {
    
	private float limite;
	private float saldo;
	private float valorLimite;
	
	public void sacar(float valor) throws Negativo{
		try {
			if(this.saldo-valor<0) {
				throw new Negativo();
			}
			else {
				this.saldo=this.saldo-valor;
			}
		}
		catch(IllegalArgumentException ex) {
			System.out.println("Voce digitou uma String");
		}
	}
	
	public void setValorLimite(float valor) throws Negativo{
		try {
			if(valor<0) {
				throw new Negativo();
			}
			else {
				this.valorLimite=valor;
			}
		}
		catch(IllegalArgumentException ex) {
			System.out.println("Voce digitou uma String");
		}
	}
	
	public void depositar(float valor) throws Negativo{
		try {
			if(this.saldo+valor<0) {
				throw new Negativo();
			}
			else {
				this.saldo=this.saldo+valor;
			}
		}
		catch(IllegalArgumentException ex) {
			System.out.println("Voce digitou uma String");
		}
	}
}
