/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.produto.model;

/**
 *
 * @author VAGNERMELOPIRES
 */
public class Produto {
       
    private int id;
    private String nome;
    private String setor;
    private double preco;
    
    public Produto(){
    
    }
  
    public Produto(String nome){
    this.nome = nome;
    
    }

    public Produto(int id, String nome, String setor, double preco) {
    this.id = id;
    this.nome = nome;
    this.setor = setor;
    this.preco = preco;
    
    }
   
    public int getId(){
      return id;
    }
    public void setId(int id){
        this.id = id;
    
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
       public double getPreco(){
      return preco;
    }
   public void setPreco(double preco){
    if(preco >= 0){
        this.preco = preco;
    }
    
    } 
    public String getSetor(){
      return setor;
    }
    public void setSetor(String setor){
        this.setor = setor;
    
    } 
}


