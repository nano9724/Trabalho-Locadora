package trabalho;

import java.util.Scanner;

import trabalho.Funcionario;

public class Vapor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Olá, Seja bem vindo ao Vapor, sua locadora de jogos online");
        fazerLogin();
    }

    public static void fazerLogin() {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira o seu login.");
        String login = input.nextLine();
        System.out.println("Insira a sua senha.");
        String senha = input.nextLine();

        if (login.equals("admin") && senha.equals("admin")) {
            System.out.println("Você está em um acesso de *ADMIN*");
            Funcionario.main(null);
        } else {
            System.out.println("Senha incorreta, por favor tente novamente.");
        }
    }
}