/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guanabara;

import java.util.Scanner;

/**
 *
 * @author isouza
 */
public class PagamentoCartao extends Pagamento {

    public PagamentoCartao(Double total) {
        super(total);
    }
    
    public void pagar(){
        inserir();
    }
    
    public void inserir() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Conectando...");
        System.out.println("Insira o cartão");
        System.out.println("Insira a senha");
        teclado.nextLine();
        System.out.println("Aprovado com sucesso!");
    }
}
