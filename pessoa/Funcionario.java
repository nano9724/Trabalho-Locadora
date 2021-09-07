package trabalho;

import java.util.Scanner;
import static java.lang.System.*;
import java.io.FileOutputStream;
import java.io.IOException;

public class Funcionario {

    private String login, senha, nome, email;
    private Int cpf, birthdate;

    public Funcionario(String login, String senha, String nome, String email, Int cpf, Int birthdate) {
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.birthdate = birthdate;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Você deseja: \n(1)-Criar conta\n(2)-Excluir conta");
        int escolhaFuncionario = input.nextInt();

        if (escolhaFuncionario == 1) {
            criaConta();
            Funcionario.main(args);
        }
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
            fos.write(":".getBytes());
            fos.write(createSenha.getBytes());
            fos.write(10);
            fos.close();
            System.out.println("Conta cadastrada com sucesso!");

        } catch (IOException e) {
            out.println("ERROR!");
        }
    }
}