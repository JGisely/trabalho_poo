/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guanabara;

import static guanabara.Guanabara.listaFuncionario; 
import static guanabara.Guanabara.listaGerente; 
import static guanabara.Guanabara.listaProduto; 
import static guanabara.Guanabara.funcionarioLogado; 
import static guanabara.Guanabara.gerenteLogado; 
import java.util.Scanner;

public class Mercado {

    Compra compra = new Compra();
    Scanner teclado = new Scanner(System.in);
    Historico h = new Historico();
    
    public Mercado() {
        printMenu();
    }
    
    private void printMenu(){
        int opcao = 0;
        while(opcao != 20){
            // Menu Principal
            System.out.println("==================================");
            System.out.println("|        Mercado Guanabara       |");
            System.out.println("==================================");
            System.out.println("| Opções:                        |");
            System.out.println("|        0. Cadastrar Funcionario|");
            System.out.println("|        1. Listar Funcionarios  |");
            System.out.println("|        2. Cadastrar Gerente    |");
            System.out.println("|        3. Listar Gerentes      |");
            System.out.println("|        4. Login Funcionario    |");
            System.out.println("|        5. Login Gerente        |");
            System.out.println("|        6. Cadastrar Produto    |"); // só gerente
            System.out.println("|        7. Listar Produtos      |"); // qualquer um
            System.out.println("|        8. Remover Produtos     |"); // só gerente
            System.out.println("|        9. Editar Produto       |"); // só gerente
            System.out.println("|       10. Adicionar Itens      |"); // só funcionario
            System.out.println("|       11. Listar Itens         |"); // só funcionario
            System.out.println("|       12. Finalizar Compra     |"); // só funcionario
            System.out.println("|       13. Relatório de Vendas  |"); // só gerente
            System.out.println("|       14. Relatório de Estoque |"); // só gerente
            System.out.println("|       15. Buscar Produto       |"); // só gerente
            System.out.println("|       16. Pedir Demissão       |"); // só gerente
            System.out.println("|        20. Sair                |"); 
            System.out.println("|        21. Funcionario Logado  |");
            System.out.println("|        22. Gerente Logado      |");
            System.out.println("==================================");
            System.out.print("Selecione uma opção: ");
        
            opcao = teclado.nextInt();
            teclado.nextLine();
            opcoes(opcao);   
        }
    }    
    
    
    private void opcoes(int opcao){
        switch(opcao) {
                case 0: {
                    listaFuncionario.add(new Funcionario());
                    break;
                }
                case 1: {
                    listarFuncionarios();
                    break;
                }
                case 2: {
                    listaGerente.add(new Gerente());
                    break;
                }
                case 3: {
                    listarGerentes();
                    break;
                }
                case 4: {
                    funcionarioLogado = Funcionario.login();
                    break;
                }
                case 5: {
                    gerenteLogado = Gerente.login();
                    break;
                }
                case 6: {
                    if (loggedGerente()) {
                     cadastrarProduto();   
                    }
                    else {
                        permissaoInvalida();
                    }
                    break;
                }
                case 7: {
                    listarProdutos();
                    break;
                }
                case 8: {
                    if (loggedGerente()) {
                        System.out.println("Qual o nome do produto?");
                        removeProduto(teclado.nextLine());
                    }
                    else {
                        permissaoInvalida();
                    }
                    break;
                }
                case 9: {
                    if (loggedGerente()) {
                        editarProduto();
                    }
                    else {
                        permissaoInvalida();
                    }
                    break;
                }
                case 10: {
                    compra.adicionarItem();
                    break;
                }
                case 11: {
                    compra.listarItens();
                    break;
                }
                case 12: {
                    compra.finalizar();
                    break;
                }
                case 13: {
                    if (loggedGerente()) {
                        relatorioVendas();
                    }
                    else {
                        permissaoInvalida();
                    }
                    break;
                }
                case 14: {
                    System.out.println("#TODO");
                    break;
                }
                case 15: {
                    System.out.println("Qual o produto deseja buscar: ");
                    Produto.getProduto(teclado.nextLine()).imprimeProduto();
                    break;
                }
                case 16: {
                    if (loggedGerente()){
                        gerenteLogado.pedirDemissao();
                    }
                    else if (loggedFuncionario()){
                        funcionarioLogado.pedirDemissao();
                    }
                    break;
                }
                case 21: {
                    if (loggedFuncionario()) {
                        System.out.println(funcionarioLogado.getNome());
                    }
                    break;
                }
                case 22: {
                    if (loggedGerente()){
                        System.out.println(gerenteLogado.getNome());
                    }
                    break;
                }
                default: {
                    break;
                }
            }
    }
    
    
    private void listarFuncionarios(){
        for (Funcionario func : listaFuncionario){
            System.out.println(func.getNome());
        }
    }
    
    private void listarGerentes(){
        for (Gerente gerente : listaGerente) {
            System.out.println(gerente.getNome());
        }
    }
    
    private void cadastrarProduto(){
        listaProduto.add(new Produto());
    }
    
    private void listarProdutos(){
        for (Produto produto : listaProduto){
            System.out.println(produto.getNome() + ": " + produto.getPreco());
        }
    }
    
    private void editarProduto(){
        Produto.editar();
    }
    
    private void removeProduto(String nome){
        Produto.remove(nome);
    }
    
    private void adicionarItem(){
        compra.adicionarItem();
    }

    
    private Boolean loggedFuncionario(){
        try {
            if (funcionarioLogado != null){
                return true;
            }
        } catch (NullPointerException ex) {
            System.out.println(ex);
        }
        return false;
    }
    
    private Boolean loggedGerente(){
        try {
            if (gerenteLogado != null) {
                return true;
            }
        } catch (NullPointerException ex) {
            System.out.println(ex);
        }
        return false;
    }
    
    private void relatorioVendas(){
        h.getRelatorioVendas();
    }
    
    private void permissaoInvalida(){
        System.out.println("Voce não possui permissão!");
    }
}
