
package pessoa;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import locadora.Jogo;
import locadora.Locacoes;


public class Usuario extends Pessoa implements Serializable{
       private String nome, login,senha, email,cpf, caminhoUsuario, caminhoJogos;
       private int pontoFidelidade;
       private Conta conta;
       List <Jogo> locacoes=new ArrayList <Jogo>();

	public Usuario(String nome, String cpf, String login, String senha){
		super(nome,cpf,login,senha);
                this.conta=new Conta();
                this.caminhoUsuario=login.concat("User.ser");
                File arquivo= new File(caminhoUsuario);
                    if (!arquivo.exists()){
                        try{
                        arquivo.createNewFile();
                         }catch(Exception e)
                            {e.printStackTrace();}
                        
                this.caminhoUsuario=login.concat("Jogos.ser");
                File arquivoJogo= new File(caminhoJogos);
                    if (!arquivo.exists()){
                        try{
                        arquivo.createNewFile();
                         }catch(Exception e)
                            {e.printStackTrace();}        
        }}}
        
        
        
        
    public void alugar(){
        Locacoes.locar(this);
        this.locacoes.addAll((ArrayList<Jogo>) Arquivo.recuperarObjeto(caminhoJogos));
        this.pontoFidelidade+=5;
        
     }
    
    public Jogo procurarAluguel(Jogo j){
    ArrayList<Jogo> obj= (ArrayList<Jogo>) Arquivo.recuperarObjeto(caminhoJogos);
        
    for(Jogo jogo: obj){
                if (jogo.getId()==j.getId()){
                   return jogo;}
    }      return null;
}
    
   public void verAlugueis(){
        ArrayList<Jogo> obj= (ArrayList<Jogo>) Arquivo.recuperarObjeto(caminhoJogos);
        
            for(Jogo jogo: obj){
                jogo.toString();
            }
    }    
   
  public void pesquisarJogos(){
       Locacoes.leDisp();
   }
   
   public void devolver(){
        Locacoes.devolucao(this);
        this.locacoes.addAll((ArrayList<Jogo>) Arquivo.recuperarObjeto(caminhoJogos));
        
   }
        
     @Override
    public String toString(){
    return String.format("%s\t%s", this.nome, this.cpf); //int %d\t; string %s\t
    }   
        
    public boolean logar(String login, String senha){
	         if(login.equals(this.getLogin()) && senha.equals(this.getSenha())) {
	            System.out.println("Olá " + this.getNome() + " seja bem vindo ao Vapor!");
		    return true;
	        }
	        else{
	            System.out.println("Senha incorreta, por favor tente novamente.");
	            return false;
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

    public void setCpf(String cpf) {
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

    public String getCaminhoUsuario() {
        return caminhoUsuario;
    }

    public String getCaminhoJogos() {
        return caminhoJogos;
    }

    public String getCpf() {
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
    
    
        
}
