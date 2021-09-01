
package pessoa;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class FileUtil {
    
    public static Object gravarObjeto(Object obj, String caminho){
        File arquivo= new File(caminho);
        if (!arquivo.exists()){
        try{
            arquivo.createNewFile();
        }catch(Exception e)
        {e.printStackTrace(); 
        return false;}
        }
        try{
            FileOutputStream fileOutput= new FileOutputStream(arquivo);
            ObjectOutputStream objOutput= new ObjectOutputStream(fileOutput);
            
            objOutput.writeObject(obj);
            
            objOutput.flush();
            fileOutput.flush();
            objOutput.close();
            fileOutput.close();
            
            return obj;}
        
        catch(Exception e)
            {e.printStackTrace(); return null;}
    }
    
    public static Object recuperarObjeto(String caminho){
        File arquivo= new File(caminho);
        
        try{
            
            FileInputStream fileInput= new FileInputStream(arquivo);
            ObjectInputStream objectInput= new ObjectInputStream(fileInput);
            
            Object retorno=objectInput.readObject();
            
            objectInput.close();
            objectInput.close();
            
            return retorno;}
        
        catch(Exception e)
        {e.printStackTrace();return null;} }
    
    
    
    
}
