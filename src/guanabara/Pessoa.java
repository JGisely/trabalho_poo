/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guanabara;

/**
 *
 * @author isouza
 */
public abstract class Pessoa {
    protected String nome;
    protected String senha;
    
    public void setNome(String novoNome){
        nome = novoNome;
    }
    
    public void setSenha(String novaSenha){
        senha = novaSenha;
    }
    
    public String getSenha(){
        return senha;
    }
    
    public String getNome(){
        return nome;
    }
    
    public abstract void create();
}
