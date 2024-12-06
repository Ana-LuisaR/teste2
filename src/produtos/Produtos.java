/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produtos;

/**
 *
 * @author Ana Luisa
 */
public class Produtos {
    
    public static String LISTAR = "SELECT * FROM produtos ORDER BY nomePro";
    
    public static String REGISTRAR = "INSERT INTO produtos(codigoPro, nomePro, tipoPro, validadePro, quantPro) "
            + "VALUES(?,?,?,?,?)";
    
    public static String ATUALIZAR = "UPDATE produtos SET "
                + "tipoPro=?, "
                + "nomePro=?, "
                + "validadePro=?, "
                + "quantPro=? WHERE codigoPro=?";
    
    public static String ELIMINAR = "DELETE FROM produtos WHERE codigoPro = ?";
    
    public static String ELIMINAR_TUDO = "DELETE FROM produtos";
    
    private String primaryKey;
    private String nome;
    private String tipo;
    private String validade;
    private String quantidade;

    public Produtos(){
        
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }
    
    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    
}
