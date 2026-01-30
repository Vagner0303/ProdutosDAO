/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.produto.dao;

import br.com.produto.config.ConnectionFactory2;
import br.com.produto.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// Responsabilidade: SQL + CRUD


/**
 *
 * @author Professor
 */
public class ProdutoDAO {
    // CREATE: inserir o aluno no baco
    public void cadastrar(Produto produto){
        // SQL com  ? (parâmetro) para evitar SQL injection
        String sql = "INSERT INTO produtos (nome) VALUES (?)";
        // tratamento de possíveis erros | no caso fecha automaticamente a conexão e  o statement
        try(Connection conn = ConnectionFactory2.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            // Troca o ? pelo nome do aluno
            stmt.setString(1, produto.getNome());
            // Executa o INSERT (podemos utilizar o executeUpdate para INSRT/UPDATE/DELETE)
            stmt.executeUpdate();
            
        } catch (Exception e) {
            // Se der erro, mostramos uma mensagem clara
            throw new RuntimeException ("Erro ao cadastrar produto", e);
        }
        
    }
    // READ: listar todos 
    public List<Produto> listar(){
        // SQL para buscar todos
        String sql = "SELECT id, nome, setor, preco FROM produtos";
        
        // Lista que vamos devolver preenchida
        List<Produto> produtos = new ArrayList<>();
        try(Connection conn = ConnectionFactory2.getConnection();
           PreparedStatement stmt = conn.prepareStatement(sql);
           ResultSet rs = stmt.executeQuery()) {
            // Enquanto tiver linha no resultado
            while(rs.next()) {
                // Pega os dados da linha atual
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int preco = rs.getInt("preco");
                String setor = rs.getString("setor");
                // Monta um objeto Aluno com os dados
                Produto produto = new Produto(id, nome, setor, preco);
                
                // Adiciona na lista
                produtos.add(produto);
            }
            
        } catch (Exception e) {
            throw new RuntimeException( "Erro ao listar produtos", e);
             
        }
        // Devolve a lista pronta
        return produtos;
    }
    
}
