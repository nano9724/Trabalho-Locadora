package pessoa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import locadora.Jogo;
import locadora.Locacoes;


public class Usuario extends Pessoa implements Serializable{
	private String  caminhoUsuario;
	private double saldo;
	static ArrayList <Usuario>usuarios=new ArrayList<Usuario>();
	ArrayList<Jogo> Alugados= new ArrayList<Jogo>();

	public Usuario(String nome, String cpf, String login, String senha){
		super(nome,cpf,login,senha);
		this.caminhoUsuario=login.concat("User.ser");
		FileOutputStream fluxo;
		try {
			fluxo= new FileOutputStream(caminhoUsuario);
			ObjectOutputStream objarq;
			objarq = new ObjectOutputStream(fluxo);
			Alugados.clear();
			objarq.writeObject(Alugados);
			objarq.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Usuario() {

	}


	public static void criaArquivoUsuario( ) {
		FileOutputStream fluxo;
		try {
			fluxo= new FileOutputStream("usuarios.ser");
			ObjectOutputStream objarq;
			objarq = new ObjectOutputStream(fluxo);
			usuarios.clear();
			objarq.writeObject(usuarios);
			objarq.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/*
	public static void leUsur() {
		FileInputStream fluxo;
		try {
			int i;
			fluxo= new FileInputStream("usuarios.ser");
			ObjectInputStream objarq;
			objarq = new ObjectInputStream(fluxo);
			System.out.println("oi");
			usuarios=(ArrayList<Usuario>)objarq.readObject();
			System.out.println("oi2");
			for(i=0;i<usuarios.size();i++) {
				System.out.println(i+": "+usuarios.get(i).getLogin()+ " "+usuarios.get(i).getSenha());
			}
			objarq.close();


		} catch (FileNotFoundException e) {

			//e.printStackTrace();
			System.out.println("Passou por aqui");
		}
		catch (IOException e) {
			//e.printStackTrace();
			System.out.println("Passou por aqui2");
		} catch (ClassNotFoundException e) {
			System.out.println("Passou por aqui3");
			//e.printStackTrace();
		}


	}

*/
  

	public boolean logar(String login, String senha){
		if(login.equals(this.getLogin()) && senha.equals(this.getSenha())) {
			System.out.println("Olá " + this.getNome() + " seja bem vindo ao Vapor!");
			return true;
		}
		else{
			return false;
		}

	}



	public String getCaminhoUsuario() {
		return caminhoUsuario;
	}




	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double valor) {
		FileInputStream fluxo;
		FileOutputStream fluxo2;
		try {
			int i;
			fluxo= new FileInputStream("usuarios.ser");
			ObjectInputStream objarq;
			objarq = new ObjectInputStream(fluxo);
			usuarios=(ArrayList<Usuario>)objarq.readObject();
			for(i=0;i<usuarios.size();i++) {
				//System.out.println(usuarios.get(i).getLogin());
				if(usuarios.get(i).getLogin().equals(this.getLogin())==true) {
					usuarios.get(i).saldo=valor;
					this.saldo=valor;
					
				}
			}
			fluxo2= new FileOutputStream("usuarios.ser");
			ObjectOutputStream objarq2;
			objarq2 = new ObjectOutputStream(fluxo2);
			objarq2.writeObject(usuarios);
			objarq.close();
			objarq2.close();

		} catch (FileNotFoundException e) {

			//e.printStackTrace();
			System.out.println("Passou por aqui");
		}
		catch (IOException e) {
			//e.printStackTrace();
			System.out.println("Passou por aqui2");
		} catch (ClassNotFoundException e) {
			System.out.println("Passou por aqui3");
			//e.printStackTrace();
		}
	}

}
