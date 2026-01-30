
package br.com.produto.dao;

import br.com.produto.config.ConnectionFactory2;
import br.com.produto.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author VAGNERMELOPIRES
 */
public class ProdutoDAO {
 
    public void cadastrar(Produto produto){
     
        String sql = "INSERT INTO produtos (nome) VALUES (?)";
  
        try(Connection conn = ConnectionFactory2.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
           
            stmt.setString(1, produto.getNome());
         
            stmt.executeUpdate();
            
        } catch (Exception e) {
          
            throw new RuntimeException ("Erro ao cadastrar produto", e);
        }
        
    }
   
    public List<Produto> listar(){
       
        String sql = "SELECT id, nome, setor, preco FROM produtos";
        
   
        List<Produto> produtos = new ArrayList<>();
        try(Connection conn = ConnectionFactory2.getConnection();
           PreparedStatement stmt = conn.prepareStatement(sql);
           ResultSet rs = stmt.executeQuery()) {
           
            while(rs.next()) {
               
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int preco = rs.getInt("preco");
                String setor = rs.getString("setor");
              
                Produto produto = new Produto(id, nome, setor, preco);
                
                
                produtos.add(produto);
            }
            
        } catch (Exception e) {
            throw new RuntimeException( "Erro ao listar produtos", e);
             
        }
      
        return produtos;
    }
    
}


