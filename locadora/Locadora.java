

package locadora;

import java.util.ArrayList;
import java.util.Scanner;
import pessoa.Arquivo;
import pessoa.Funcionario;
import pessoa.Usuario;



public class Locadora {
    
   
     public static void UserIntialPage(Usuario u){
         Scanner teclado=new Scanner(System.in);
            System.out.println ("Digite:\n"+"1 - Alugar\n"+"2 - Ver seus Alugueis\n"+"3 - Devolução\n"+"4 - Ver Jogos Disponiveis na Locadora\n");   
              int user=teclado.nextInt();
              switch (user){ 
                  case 1:
                  u.alugar();
                               
                  case 2: 
                  u.verAlugueis();
                              
                  case 3:
                  u.devolver();
                    
                  case 4: 
                      u.pesquisarJogos();
                  default:
                           
}}
    
    public void printUsuarios(){
     
    
    }
                       
            
    
   public static void main(String[] args){
       String caminhoUsuarios="usuarios.txt";// Estrutura para manipular todos os usuários
       ArrayList <Usuario>usuarios=new ArrayList<Usuario>();
       
       String caminhoFuncionarios="funcionarios.txt";// Estrutura para manipular todos os funcionarios
       ArrayList <Funcionario>funcionarios=new ArrayList<Funcionario>();
       
       String caminhoJogos="jogos.txt";// Estrutura para manipular todos os Jogo (Disponpiveis ou não)* ou a gente pode fazer com que o funcionario crie as instancias de Jogo e já adicione em disponíveis 
       ArrayList <Jogo>jogos=new ArrayList<Jogo>();
       
       System.out.println ("****Locadora****");
       System.out.println ("****Digite o tipo de acesso****\n"+"1 - Usuário\n"+"2 - Funcionario");
       Scanner teclado=new Scanner(System.in);
      int opt=teclado.nextInt();
      int option;
      switch (opt){
          
          case 1: //Usuário
           
              System.out.println ("Digite:\n"+"1 - Login"+"2 - Cadastro Usuário");   
              int user=teclado.nextInt();
                        switch (user){ 
                            case 1: 
                                System.out.println("*** Digite o Login ***");
                                teclado =new Scanner(System.in);
                                String log=teclado.nextLine();
                                System.out.println("*** Digite a Senha ***");
                                String senha=teclado.nextLine();
    
                                    for(Usuario us: usuarios)
                                            usuarios.clear();
                                            usuarios.addAll((ArrayList<Usuario>)Arquivo.recuperarObjeto(caminhoUsuarios));
                                                for(int i=0;i<usuarios.size();i++) {
                                                    if(usuarios.get(i).logar(log, senha)){
                                                        UserIntialPage(usuarios.get(i));
                                                    }}
      
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
                                    usuarios.clear();
                                    usuarios.addAll((ArrayList<Usuario>)Arquivo.recuperarObjeto(caminhoUsuarios));
                                    usuarios.add(usuario);
                                    Arquivo.gravarObjeto(usuarios,caminhoUsuarios);
                                
                                
                                
                                
                                
                                        }
          case 2: //Funcionario 
              
              
              System.out.println("Digite:\n"+"1 - Ver Usuários"+"2 - Cadastrar Jogo");   
              int user=teclado.nextInt();
                switch (user){ 
                        
                    case 1: 
                        usuarios.clear();
                        usuarios.addAll((ArrayList<Usuario>)Arquivo.recuperarObjeto(caminhoUsuarios));
                        for(Usuarios us: usuarios)
                             usuarios.toString();
                        
                    case 2: 
                        jogos.clear();
                        jogos.addAll((ArrayList<Jogos>)Arquivo.recuperarObjeto(caminhoJogos));
                        Jogo newgame= new Jogo(); 
                        jogos.add(newgame);
                        Arquivo.gravarObjeto(jogos, caminhoJogos);
                        
                        
                }
      }
      
       }}
