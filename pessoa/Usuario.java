
package pessoa;

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
        
    void alugar(){
	    Locacoes loc=new Locacoes ();
        	Jogo j=loc.locar();//locar poderia retornar o Jogo alugado
     this.locacoes.addAll((ArrayList <Jogo>)Arquivo.gravarObjeto(j, caminho));
    }
    
    public Jogo procurarAluguel(Jogo j){
    ArrayList<Jogo> obj= (ArrayList<Jogo>) Arquivo.recuperarObjeto(caminho);
        
    for(Jogo jogo: obj){
                if (jogo.getId()==j.getId()){
                   return jogo;}
    }      return null;
}
    
    void verAlugueis(){
        ArrayList<Jogo> obj= (ArrayList<Jogo>) Arquivo.recuperarObjeto(caminho);
        
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
        
     @Override
    public String toString(){
    return String.format("%s\t%s", this.nome, this.cpf); //int %d\t; string %s\t
    }   
	
	
    public boolean logar(){
	        Scanner input = new Scanner(System.in);
	        System.out.println("Insira o seu login.");
	        String login = input.nextLine();
	        System.out.println("Insira a sua senha.");
	        String senha = input.nextLine();

	        if(login.equals(this.getLogin()) && senha.equals(this.getSenha())) {
	            System.out.println("Olá " + this.getNome() + " seja bem vindo ao Vapor!");
		    return true;
	        }
	        else{
	            System.out.println("Senha incorreta, por favor tente novamente.");
	            logar();
	        }
	    }
	
	
	
	public boolean logar(String login, String senha){
	         if(login.equals(this.getLogin()) && senha.equals(this.getSenha())) {
	            System.out.println("Olá " + this.getNome() + " seja bem vindo ao Vapor!");
		    return true;
	        }
	        else{
	            System.out.println("Senha incorreta, por favor tente novamente.");
	            logar();
	        }
	    }
        
        
}
