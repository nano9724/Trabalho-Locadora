package locadora;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import pessoa.Arquivo;
import pessoa.Funcionario;
import pessoa.Usuario;

public class Locadora {

	public static void UserIntialPage(Usuario u){

		Scanner teclado=new Scanner(System.in);
		System.out.println ("\nDigite:\n"+"(1) - Alugar\n"+"(2) - Ver seus Alugueis\n"+"(3) - Devolução\n"+"(4) - Ver Jogos Disponiveis na Locadora\n"+"(5) - Adicionar fundos\n(6) - Ver Fundos\n(7) - Para sair");   
		int user=teclado.nextInt();
		while(user!=7) {
			switch (user){ 
			case 1:
				Locacoes.locar(u);
				u.setSaldo(u.getSaldo());
				break;

			case 2: 
				Locacoes.leAlug(u);
				break;

			case 3:
				Locacoes.devolucao(u);
				break;

			case 4: 
				Locacoes.leDisp();
				break;
			case 5:
				System.out.println("Quanto deseja adicionar?");
				int val=teclado.nextInt();
				u.setSaldo(u.getSaldo()+val);
				break;
			case 6:
				System.out.println(u.getSaldo());
				break;
			default:
				System.out.println("Digite um valor valido");
			}
			System.out.println ("\nDigite:\n"+"(1) - Alugar\n"+"(2) - Ver seus Alugueis\n"+"(3) - Devolução\n"+"(4) - Ver Jogos Disponiveis na Locadora\n"+"(5) - Adicionar fundos\n(6) - Ver Fundos\n(7) - Para sair");     
			user=teclado.nextInt();
		}
	}



	public static void main(String[] args){
		ArrayList <Usuario>usuarios=new ArrayList<Usuario>();

		String caminhoFuncionarios="funcionarios.txt";// Estrutura para manipular todos os funcionarios
		ArrayList <Funcionario>funcionarios=new ArrayList<Funcionario>();

		String caminhoJogos="jogos.txt";// Estrutura para manipular todos os Jogo (Disponiveis ou não)* ou a gente pode fazer com que o funcionario crie as instancias de Jogo e já adicione em disponíveis 
		ArrayList <Jogo>jogos=new ArrayList<Jogo>();

		System.out.println ("****Locadora****");
		System.out.println ("****Digite o tipo de acesso****\n"+"1 - Usuário\n"+"2 - Funcionario");
		Scanner teclado=new Scanner(System.in);
		int opt=teclado.nextInt();
		int option;
		switch (opt){

		case 1: //Usuário
			System.out.println ("Digite:\n"+"1 - Login\n"+"2 - Cadastro Usuário");   
			int user=teclado.nextInt();
			switch (user){ 
			case 1: 
				boolean aju=false;
				while(aju==false) {
					System.out.println("*** Digite o Login ***");
					teclado =new Scanner(System.in);
					String log=teclado.nextLine();
					System.out.println("*** Digite a Senha ***");
					String senha=teclado.nextLine();

					usuarios.clear();
					usuarios.addAll((ArrayList<Usuario>)Arquivo.recuperarObjeto("usuarios.ser"));
					for(int i=0;i<usuarios.size();i++) {
						aju=usuarios.get(i).logar(log, senha);
						if(aju==true){
							UserIntialPage(usuarios.get(i));
							break;
						}}
					if(aju==false) {
						System.out.println("Login ou Senha incorreto");
						System.out.println("Voce deseja criar uma conta? Se sim digite 2, se nao digite 1");
						int k=teclado.nextInt();
						if(k==2) {
							user=k;
							aju=true;
						}
					}
				}
				if(user!=2) {
					break;
				}
				
			case 2: 
				System.out.println("*** Cadastro ***");
				System.out.println("*** Crie um Login ***");
				teclado =new Scanner(System.in);
				String login=teclado.nextLine();
				System.out.println("*** Crie uma Senha ***");
				String psw=teclado.nextLine();
				System.out.println("*** Qual o seu nome? ***");
				String nome=teclado.nextLine();
				System.out.println("*** Por fim informe o seu cpf ***");
				String cpf=teclado.nextLine();
				Usuario usuario= new Usuario(nome, cpf, login, psw);
				FileInputStream fluxo;
				FileOutputStream fluxo2;
				try {
					fluxo= new FileInputStream("usuarios.ser");
					ObjectInputStream objarq;
					objarq = new ObjectInputStream(fluxo);
					usuarios.clear();
					usuarios.addAll((ArrayList<Usuario>)objarq.readObject());
					usuarios.add(usuario);
					fluxo2= new FileOutputStream("usuarios.ser");
					ObjectOutputStream objarq2;
					objarq2 = new ObjectOutputStream(fluxo2);
					objarq2.writeObject(usuarios);
					System.out.println("Salvo no arquivo");
					System.out.println("O usuario "+ login+ " foi criado");
					objarq.close();
					objarq2.close();

				} catch (FileNotFoundException e) {
					System.out.println("Arquivo nao encontrado");
					Usuario.criaArquivoUsuario();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
				catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				break;



			}
			break;
		case 2:

			String filepath = "account.txt";
			System.out.println("**** Digite o login ****");
			String username = teclado.next();
			System.out.println("**** Digite a senha ****");
			String password = teclado.next();
			while (!Funcionario.verificaLogin(username, password, filepath)) {
				System.out.println("**** Digite o login ****");
				username = teclado.next();
				System.out.println("**** Digite a senha ****");
				password = teclado.next();
			}
			System.out.println("**** Bem vindo ao menu de Funcionário ****");
			System.out.println(
					"Você deseja:\n(1) - Criar uma nova conta de funcionário\n(2) - Adicionar jogo\n(3) - Listar jogos disponiveis\n(4) - Para sair");
			int funcMenu = teclado.nextInt();
			while (funcMenu != 4) {
				switch (funcMenu) {
				case 1:
					Funcionario.criaConta();
					break;
				case 2:
					System.out.println("Digite o nome do jogo:");
					String nome = teclado.next();
					System.out.println("Digite o tipo do jogo:");
					String tipo = teclado.next();
					System.out.println("Digite a classificao do jogo:");
					int classificao = teclado.nextInt();
					System.out.println("Digite o preco do jogo:");
					double preco = teclado.nextDouble();

					Jogo jogo = new Jogo(nome, tipo, classificao, preco);
					Locacoes.addJogo(jogo);
					break;
				case 3:
					Locacoes.leDisp();
					break;
				default:
					System.out.println("Numero invalido");	
				}

				System.out.println(
						"Você deseja:\n(1) - Criar uma nova conta de funcionário\n(2) - Adicionar jogo\n(3) - Listar jogos disponiveis\n(4) - Para sair");
				funcMenu = teclado.nextInt();
			}

		}
	}
}
