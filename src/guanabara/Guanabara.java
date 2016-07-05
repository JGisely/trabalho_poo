/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guanabara;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author isouza
 */

public class Guanabara {
    static ArrayList<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
    static ArrayList<Gerente> listaGerente = new ArrayList<Gerente>();
    static ArrayList<Produto> listaProduto = new ArrayList<Produto>();
    static Compra compra = new Compra();
    static Funcionario funcionarioLogado;
    static Gerente gerenteLogado;
    
    public static void main(String[] args) {
        printMenu();
    }
    
    private static void printMenu(){
        Scanner teclado = new Scanner(System.in);
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
            System.out.println("|        20. Sair                |"); 
            System.out.println("|        21. Funcionario Logado  |");
            System.out.println("|        22. Gerente Logado      |");
            System.out.println("==================================");
            System.out.print("Selecione uma opção: ");
        
            opcao = teclado.nextInt();
            teclado.nextLine();
            switch(opcao) {
                case 0: {
                    cadastrarFuncionario();
                    break;
                }
                case 1: {
                    listarFuncionarios();
                    break;
                }
                case 2: {
                    cadastrarGerente();
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
                    gerenteLogado = Gerente.login(listaGerente);
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
                    adicionarItem();
                    break;
                }
                case 11: {
                    listarItens();
                    break;
                }
                case 12: {
                    finalizarCompra();
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
                    buscaProduto();
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
    }    
    
    private static void cadastrarFuncionario(){
        Funcionario f = new Funcionario();
        f.create();
        System.out.println("Cadastrado com sucesso!");
    }
    
    private static void listarFuncionarios(){
        for (Funcionario func : listaFuncionario){
            System.out.println(func.getNome());
        }
    }
    
    private static void cadastrarGerente(){
        Gerente g = new Gerente();
        g.create();
    }
    
    private static void listarGerentes(){
        for (Gerente gerente : listaGerente) {
            System.out.println(gerente.getNome());
        }
    }
    
    private static void cadastrarProduto(){
        Produto p = new Produto();
        p.create(listaProduto);
    }
    
    private static void listarProdutos(){
        for (Produto produto : listaProduto){
            System.out.println(produto.getNome() + ": " + produto.getPreco());
        }
    }
    
    private static void editarProduto(){
        Produto.editar();
    }
    
    private static void removeProduto(String nome){
        Produto.remove(nome);
    }
    
    private static void adicionarItem(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Qual item voce quer adicionar?");
        Produto p = Produto.getProduto(teclado.nextLine());
        Item item = new Item();
        System.out.println("Qual a quantidade desejada?");
        item.setItem(p,teclado.nextInt());
        compra.addItem(item);
    }
    
    private static void listarItens() {
        try {
            compra.listarItens();
        }
        catch (NullPointerException ex) {
            System.out.println(ex);
        }
        
    }
    
    
    private static void finalizarCompra(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("==================================");
        System.out.println("|       Formas de Pagamento      |");
        System.out.println("==================================");
        System.out.println("| Opções:                        |");
        System.out.println("|        1. Debito               |");
        System.out.println("|        2. Dinheiro             |");
        System.out.println("==================================");
        System.out.println("| OBS:  Não aceitamos cheques    |");
        System.out.println("==================================");
        int opcao = teclado.nextInt();
        switch (opcao) {
            case 1: {
                PagamentoCartao pc = new PagamentoCartao(compra.getTotal());
                break;
            }
            case 2: {
                PagamentoDinheiro pd = new PagamentoDinheiro(compra.getTotal());
                break;
            }
            default: {
                break;
            }
        }
            
    }
    
    private static Boolean loggedFuncionario(){
        try {
            if (funcionarioLogado != null){
                return true;
            }
        } catch (NullPointerException ex) {
            System.out.println(ex);
        }
        return false;
    }
    
    private static Boolean loggedGerente(){
        try {
            if (gerenteLogado != null) {
                return true;
            }
        } catch (NullPointerException ex) {
            System.out.println(ex);
        }
        return false;
    }
    
    private static void relatorioVendas(){
        Historico h = new Historico();
        h.getRelatorioVendas();
    }
    
    private static void permissaoInvalida(){
        System.out.println("Voce não possui permissão!");
    }
    
    private static void buscaProduto(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Qual produto vc quer saber detalhes?");
        Produto p = Produto.getProduto(teclado.nextLine());
        p.imprimeProduto();
    }
}
