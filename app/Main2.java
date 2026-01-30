package br.com.produto.app;

import br.com.produto.model.Produto;
import br.com.produto.dao.ProdutoDAO;

import java.util.Scanner;

/**
 *
 * @author VAGNERMELOPIRES
 */
public class Main2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ProdutoDAO dao = new ProdutoDAO();

        System.out.println("Quantos produtos deseja cadastrar? ");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 1; i <= quantidade; i++) {
            System.out.println("Produto " + i);

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Setor: ");
            String setor = scanner.nextLine();

            System.out.print("Preco: ");
            int preco = scanner.nextInt();
            scanner.nextLine(); 

            Produto produto = new Produto();

            produto.setNome(nome);
            produto.setSetor(setor);
            produto.setPreco(preco);

            dao.cadastrar(produto);
        }

        System.out.println("\n=== PRODUTOS CADASTRADOS ===");
        dao.listar().forEach(produto -> {
            System.out.println(
                produto.getId() + " - " +
                produto.getNome() + " - " +
                produto.getSetor() + " - R$ " +
                produto.getPreco()
            );
        });

        scanner.close();
    }
}


