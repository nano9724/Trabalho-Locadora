
package pessoa;

public class Negativo extends Exception{
	
    @Override
    public String getMessage() {
		return "Esse numero será negativo";
	}
}