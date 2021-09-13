
package locadora;

import java.util.ArrayList;
import pessoa.FileUtil;
import pessoa.Usuario;


public class Locadora {
   
 
   
   public static void main(String[] args){
       String caminhoUsuarios="usuarios.txt";
       ArrayList <Usuario>usuarios=new ArrayList<Usuario>();
       ArrayList <Funcionario>funcionarios=new ArrayList<Funcionario>();
      
      System.out.println ("****Locadora****");
       System.out.println ("****Digite o tipo de acesso****\n"+"1 - Usuário\n"+"2 - Funcionario");
       Scanner teclado =new Scanner(System.in);
      int opt=teclado.nextInt();
      int option;
      switch (opt){
          
          case 1: 
           
              System.out.println ("Digite:\n"+"1 - Login"+"2 - Cadastro Usuário");   
              int user=teclado.nextInt();
                        switch (user){ 
                            case 1: 
                                System.out.println("*** Digite o Login ***");
                                Scanner teclado =new Scanner(System.in);
                                String log=teclado.nextLine();
                                System.out.println("*** Digite a Senha ***");
                                String senha=teclado.nextLine();
    
                                    for(Usuario us: usuarios)
                                            usuarios.clear();
                                            usuarios.addAll((ArrayList<Usuario>)Arquivo.readObject());
                                                for(i=0;i<usuarios.size();i++) {
                                                    if(usuarios.logar())
       
       usuarios.add(new Usuario("Adriano","12345678910","nano","123456"));
       usuarios.add(new Usuario("Victor", "12452548910","invict","985254"));
       usuarios.add(new Usuario("Gabriel","12254826880","gabs","21547"));
       usuarios.add(new Usuario("Vania",  "12254758274","van","984571"));
       Arquivo.gravarObjeto(usuarios, caminhoUsuarios);
   
   }
    
    
}
