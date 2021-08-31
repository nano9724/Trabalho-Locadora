package locadora;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


import pessoa.Usuario;

public class Locacoes implements Serializable{
	ArrayList<Jogo> Disponiveis= new ArrayList<Jogo>();

	void locar(Jogo j, Usuario u){


	}
	void devolucao(Jogo j, Usuario u){

	}

	void addJogo(Jogo j) {
		FileInputStream fluxo;
		FileOutputStream fluxo2;
		try {
			fluxo= new FileInputStream("dispon.ser");
			ObjectInputStream objarq;
			objarq = new ObjectInputStream(fluxo);
			this.Disponiveis.addAll((ArrayList<Jogo>)objarq.readObject());
			fluxo2= new FileOutputStream("dispon.ser");
			ObjectOutputStream objarq2;
			objarq2 = new ObjectOutputStream(fluxo2);
			objarq2.writeObject(this.Disponiveis);
			System.out.println("Salvo no arquivo");
			objarq.close();
			objarq2.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
