
package pessoa;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import locadora.Jogo;

public class Usuario extends Pessoa implements Serializable{
       private String nome, login,senha, email;
       private int pontoFidelidade,cpf;
       private String caminho="alugueisUsuario.txt";
       List <Jogo> locacoes=new ArrayList <Jogo>();

	public Usuario(String nome, int cpf, String login, String senha){
		super(nome,cpf,login,senha);
        }
        
        
    void alugar(Jogo j){
     this.locacoes.addAll((ArrayList <Jogo>)FileUtil.gravarObjeto(j, caminho));
    }
    
    public Jogo procurarAluguel(Jogo j){
    ArrayList<Jogo> obj= (ArrayList<Jogo>) FileUtil.recuperarObjeto(caminho);
        
    for(Jogo jogo: obj){
                if (jogo.getId()==j.getId()){
                   return jogo;}
    }      return null;
}
    
    void verAlugueis(){
        ArrayList<Jogo> obj= (ArrayList<Jogo>) FileUtil.recuperarObjeto(caminho);
        
            for(Jogo jogo: obj){
                jogo.toString();
            }
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public int getCpf() {
        return cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPontoFidelidade(int pontoFidelidade) {
        this.pontoFidelidade = pontoFidelidade;
    }

    public String getEmail() {
        return email;
    }

    public int getPontoFidelidade() {
        return pontoFidelidade;
    }
        
     @Override
    public String toString(){
    return String.format("%s\t%d", this.nome, this.cpf); //int %d\t; string %s\t
    }   
        
        
}
