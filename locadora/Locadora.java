
package locadora;

import java.util.ArrayList;
import pessoa.FileUtil;
import pessoa.Usuario;


public class Locadora {
   
   Object locInit(){
      System.out.println("*** Login ***");
      System.out.println("*** Digite o Login ***");
      Scanner teclado =new Scanner(System.in);
      String log=teclado.nextString();
      System.out.println("*** Digite a Senha ***");
      String senha=teclado.nextString();
    
      for(Usuario us: usuarios)
         usuarios.clear();
			usuarios.addAll((ArrayList<Usuario>)Arquivo.readObject());
			for(i=0;i<usuarios.size();i++) {
				if(usuarios.login(log, senha))
               //menu usuário
			}	
      
      for(Funcionario fun: funcionarios)
         funcionarios.clear();
			funcionarios.addAll((ArrayList<Funcionario>)Arquivo.recuperarObjeto());
			for(i=0;i<usuarios.size();i++) {
				if(usuarios.login(log, senha))
      
   
      
   }
   
   
   
   
   
   public static void main(String[] args){
       String caminhoUsuarios="usuarios.txt";
       ArrayList <Usuario>usuarios=new ArrayList<Usuario>();
         ArrayList <Funcionario>funcionarios=new ArrayList<Funcionario>();
      
      System.out.println("*** Locadora de Jogos ***");
      System.out.println("*** Escolha o tipo de Usuário ***");
      System.out.println("1 - Usuário \n 2 - Fuuncionario");
      int opt=0
      while(true){
      
         
               
         
         }
         
      }
       
       usuarios.add(new Usuario("Adriano","12345678910","nano","123456"));
       usuarios.add(new Usuario("Victor", "12452548910","invict","985254"));
       usuarios.add(new Usuario("Gabriel","12254826880","gabs","21547"));
       usuarios.add(new Usuario("Vania",  "12254758274","van","984571"));
       Arquivo.gravarObjeto(usuarios, caminhoUsuarios);
   
   }
    
    
}
