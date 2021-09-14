package pessoa;

import java.util.Scanner;
import static java.lang.System.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

public class Funcionario {
	private static Scanner x;

	private String nome, login, senha;
	private int cpf;

	public Funcionario(String nome, int cpf, String login, String senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.login = login;
		this.senha = senha;
	}

	public static void main(String[] args) {
		String username = "";
		String password = "";
		String filepath = "account.txt";
		criaConta();

		Scanner input = new Scanner(System.in);
		System.out.println("**** Digite o login ****");
		username = input.next();
		System.out.println("**** Digite a senha ****");
		password = input.next();
		verificaLogin(username, password, filepath);
	}

	public static boolean verificaLogin(String username, String password, String filepath) {
		boolean found = false;
		String tempLogin = "";
		String tempSenha = "";

		try {
			x = new Scanner(new File(filepath));
			x.useDelimiter("[,\n]");

			while (x.hasNext() && !found) {
				tempLogin = x.next();
				tempSenha = x.next();

				if (tempLogin.trim().equals(username) && tempSenha.trim().equals(password)) {
					found = true;
				}
			}
			x.close();
			if (found) {
				System.out.println("**** Usuário e senha corretos ****");
				return true;
			} else {
				System.out.println("**** Usuário e senha incorretos ****");
				return false;
			}
		} catch (Exception e) {
			System.out.println("Nenhuma conta de ADM encontrada, crie uma conta para acessar o menu de funcionário");
			criaConta();
		}
		return found;
	}

	public static void criaConta() {
		Scanner input = new Scanner(System.in);
		try {
			FileOutputStream fos = new FileOutputStream("account.txt", true);
			System.out.println("Qual será o nome do usuário?");
			String createLogin = input.next();
			System.out.println("Qual será a senha?");
			String createSenha = input.next();

			fos.write(createLogin.getBytes());
			fos.write(",".getBytes());
			fos.write(createSenha.getBytes());
			fos.write(10);
			fos.close();
			System.out.println("Conta cadastrada com sucesso!");

		} catch (IOException e) {
			out.println("ERROR!");
		}
	}
}
