package locadora;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import pessoa.Usuario;

public class Locacoes implements Serializable {
	static ArrayList<Jogo> Disponiveis = new ArrayList<Jogo>();
	static ArrayList<Jogo> Alugados = new ArrayList<Jogo>();

	public static void locar(Usuario usur) {
		FileInputStream fluxo;
		FileInputStream fluxo2;
		FileOutputStream fluxo3;
		FileOutputStream fluxo4;
		int i, num;
		try {
			fluxo = new FileInputStream("dispon.ser");
			ObjectInputStream objarq;
			objarq = new ObjectInputStream(fluxo);
			Disponiveis.clear();
			Disponiveis.addAll((ArrayList<Jogo>) objarq.readObject());
			for (i = 0; i < Disponiveis.size(); i++) {
				System.out.println(i + ": " + Disponiveis.get(i).getNome() + " " + Disponiveis.get(i).getTipo() + " "
						+ Disponiveis.get(i).getClassificacao() + " " + Disponiveis.get(i).getPreco());
			}
			System.out.println("Digite o numero do jogo que voce quer");
			Scanner entrada = new Scanner(System.in);
			num = entrada.nextInt();
			Jogo req = new Jogo();
			req = Disponiveis.get(num);
			if (usur.getSaldo() - req.getPreco() < 0) {
				objarq.close();
				System.out.println("Voce nao tem fundos suficiente");
				return;
			} else {
				usur.setSaldo(usur.getSaldo() - req.getPreco());
				Disponiveis.remove(num);
				fluxo2 = new FileInputStream(usur.getCaminhoUsuario());
				ObjectInputStream objarq2;
				objarq2 = new ObjectInputStream(fluxo2);
				Alugados.clear();
				Alugados.addAll((ArrayList<Jogo>) objarq2.readObject());
				Alugados.add(req);
				fluxo3 = new FileOutputStream("dispon.ser");
				ObjectOutputStream objarq3;
				objarq3 = new ObjectOutputStream(fluxo3);
				objarq3.writeObject(Disponiveis);
				fluxo4 = new FileOutputStream(usur.getCaminhoUsuario());
				ObjectOutputStream objarq4;
				objarq4 = new ObjectOutputStream(fluxo4);
				objarq4.writeObject(Alugados);
				objarq.close();
				objarq2.close();
				objarq3.close();
				objarq4.close();
			}

		} catch (FileNotFoundException e) {
			criaArquivos();
			System.out.println("Nenhum arquivo foi encontrado\nArquivo sendo criado...");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void devolucao(Usuario usur) {
		FileInputStream fluxo;
		FileInputStream fluxo2;
		FileOutputStream fluxo3;
		FileOutputStream fluxo4;
		int i, num;
		try {
			fluxo = new FileInputStream(usur.getCaminhoUsuario());
			ObjectInputStream objarq;
			objarq = new ObjectInputStream(fluxo);
			Alugados.clear();
			Alugados.addAll((ArrayList<Jogo>) objarq.readObject());
			for (i = 0; i < Alugados.size(); i++) {
				System.out.println(i + ": " + Alugados.get(i).getNome() + " " + Alugados.get(i).getTipo() + " "
						+ Alugados.get(i).getClassificacao() + " " + Alugados.get(i).getPreco());
			}
			System.out.println("Digite o numero do jogo que voce quer devolver");
			Scanner entrada = new Scanner(System.in);
			num = entrada.nextInt();
			Jogo req = new Jogo();
			req = Alugados.get(num);
			Alugados.remove(num);
			fluxo2 = new FileInputStream("dispon.ser");
			ObjectInputStream objarq2;
			objarq2 = new ObjectInputStream(fluxo2);
			Disponiveis.clear();
			Disponiveis.addAll((ArrayList<Jogo>) objarq2.readObject());
			Disponiveis.add(req);
			fluxo3 = new FileOutputStream("dispon.ser");
			ObjectOutputStream objarq3;
			objarq3 = new ObjectOutputStream(fluxo3);
			objarq3.writeObject(Disponiveis);
			fluxo4 = new FileOutputStream(usur.getCaminhoUsuario());
			ObjectOutputStream objarq4;
			objarq4 = new ObjectOutputStream(fluxo4);
			objarq4.writeObject(Alugados);
			objarq.close();
			objarq2.close();
			objarq3.close();
			objarq4.close();

		} catch (FileNotFoundException e) {
			criaArquivos();
			System.out.println("Nenhum arquivo foi encontrado\nArquivo sendo criado...");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void addJogo(Jogo j) {
		FileInputStream fluxo;
		FileOutputStream fluxo2;
		try {
			fluxo = new FileInputStream("dispon.ser");
			ObjectInputStream objarq;
			objarq = new ObjectInputStream(fluxo);
			Disponiveis.clear();
			Disponiveis.addAll((ArrayList<Jogo>) objarq.readObject());
			Disponiveis.add(j);
			fluxo2 = new FileOutputStream("dispon.ser");
			ObjectOutputStream objarq2;
			objarq2 = new ObjectOutputStream(fluxo2);
			objarq2.writeObject(Disponiveis);
			System.out.println("Salvo no arquivo");
			objarq.close();
			objarq2.close();

		} catch (FileNotFoundException e) {
			criaArquivos();
			System.out.println("Nenhum arquivo foi encontrado\nArquivo sendo criado...");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void criaArquivos() {
		FileOutputStream fluxo;
		try {
			fluxo = new FileOutputStream("dispon.ser");
			ObjectOutputStream objarq;
			objarq = new ObjectOutputStream(fluxo);
			Disponiveis.clear();
			objarq.writeObject(Disponiveis);
			objarq.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void leDisp() {
		FileInputStream fluxo;
		try {
			int i;
			fluxo = new FileInputStream("dispon.ser");
			ObjectInputStream objarq;
			objarq = new ObjectInputStream(fluxo);
			Disponiveis = (ArrayList<Jogo>) objarq.readObject();
			for (i = 0; i < Disponiveis.size(); i++) {
				System.out.println(i + ": " + Disponiveis.get(i).getNome() + " " + Disponiveis.get(i).getTipo() + " "
						+ Disponiveis.get(i).getClassificacao() + " " + Disponiveis.get(i).getPreco());
			}
			objarq.close();

		} catch (FileNotFoundException e) {
			criaArquivos();
			System.out.println("Nenhum arquivo foi encontrado\nArquivo sendo criado...");
		} catch (IOException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

	public static void leAlug(Usuario usur) {
		FileInputStream fluxo;
		try {
			int i;
			fluxo = new FileInputStream(usur.getCaminhoUsuario());
			ObjectInputStream objarq;
			objarq = new ObjectInputStream(fluxo);
			Alugados = (ArrayList<Jogo>) objarq.readObject();
			for (i = 0; i < Alugados.size(); i++) {
				System.out.println(i + ": " + Alugados.get(i).getNome() + " " + Alugados.get(i).getTipo() + " "
						+ Alugados.get(i).getClassificacao() + " " + Alugados.get(i).getPreco());
			}
			objarq.close();

		} catch (FileNotFoundException e) {
			criaArquivos();
			System.out.println("Nenhum arquivo foi encontrado\nArquivo sendo criado...");
		} catch (IOException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

}
