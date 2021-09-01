
package locadora;

import java.util.ArrayList;
import pessoa.FileUtil;
import pessoa.Usuario;


public class Locadora {
   
   public static void main(String[] args){
       String caminhoUsuarios="usuarios.txt";
       ArrayList <Usuario>usuarios=new ArrayList<Usuario>();
       
       usuarios.add(new Usuario("Adriano","12345678910","nano","123456"));
       usuarios.add(new Usuario("Victor", "12452548910","invict","985254"));
       usuarios.add(new Usuario("Gabriel","12254826880","gabs","21547"));
       usuarios.add(new Usuario("Vania",  "12254758274","van","984571"));
       FileUtil.gravarObjeto(usuarios, caminhoUsuarios);
   
   }
    
    
}
