package pessoa;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class Funcionario implements Serializable{
	  private String nome,login,senha;
	  private int cpf;

	  public Funcionario(String nome,int cpf,String login,String senha){
	    this.nome=nome;
	    this.cpf=cpf;
	    this.login=login;
	    this.senha=senha;
	  }
	  
	  public void logar(){
	        Scanner input = new Scanner(System.in);
	        System.out.println("Insira o seu login.");
	        String login = input.nextLine();
	        System.out.println("Insira a sua senha.");
	        String senha = input.nextLine();

	        if(login.equals("admin") && senha.equals("admin")) {
	            System.out.println("Olá " + login + " seja bem vindo ao Vapor!");
	        }
	        else{
	            System.out.println("Senha incorreta, por favor tente novamente.");
	            logar();
	        }
	    }

	    public void criaUsuario(){
			FileOutputStream fluxo;
			
			try {
				fluxo= new FileOutputStream("func.ser");
				ObjectOutputStream objarq;
				objarq = new ObjectOutputStream(fluxo);
				objarq.writeObject(this);
				System.out.println("Salvo no arquivo");
				objarq.close();
			} catch (FileNotFoundException e) {
				System.out.println("Passou por aqui");
				e.printStackTrace();
			}
			catch (IOException e) {
				e.printStackTrace();
			}

		
	      }
}
