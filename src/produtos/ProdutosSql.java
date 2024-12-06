/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produtos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import principal.Conectar;
import principal.GerarCodigos;

/**
 *
 * @author Ana Luisa
 */
public class ProdutosSql {
    static Conectar cc = new Conectar();
    static Connection cn = cc.conexao();
    static PreparedStatement ps;
    
    public static void listar(String busca) {
        DefaultTableModel modelo = (DefaultTableModel) produtos.FrmProdutos.tabelaProduto.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = Produtos.LISTAR;
        } else {
            sql = "SELECT * FROM produtos WHERE (codigoPro like'" + busca + "%' or nomePro like'" + busca + "%') "
                    + " order by nomePro";
            
           
            
        }
        String dados[] = new String[5];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                dados[0] = rs.getString("codigoPro");
                dados[1] = rs.getString("nomePro");
                dados[2] = rs.getString("tipoPro");
                dados[3] = rs.getString("validadePro");
                dados[4] = rs.getString("quantPro");
               
                modelo.addRow(dados);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Produtos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    public static int registrar(Produtos uc) {
        int rsu = 0;
        String sql = Produtos.REGISTRAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, uc.getPrimaryKey());
            ps.setString(2, uc.getNome());
            ps.setString(3, uc.getTipo());
            ps.setString(4, uc.getValidade());
            ps.setString(5, uc.getQuantidade());
           
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql);
        return rsu;
    }
    
    
    
     public static void gerarId(){
        int j;
        int cont = 1;
        String num = "";
        String c = "";
        String SQL = "SELECT MAX(codigoPro) FROM produtos";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                c = rs.getString(1);
            }

            if (c == null) {
            } else {
                char r1 = c.charAt(3);
                char r2 = c.charAt(4);
                char r3 = c.charAt(5);
                char r4 = c.charAt(6);
                String r = "";
                r = "" + r1 + r2 + r3 + r4;
                j = Integer.parseInt(r);
                GerarCodigos gen = new GerarCodigos();
                gen.gerar(j);
                produtos.FrmProdutos.codigo.setText("PRO" + gen.serie());

            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutosSql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     
     
     
      public static int atualizar(Produtos uc) {
        int rsu = 0;
        String sql = Produtos.ATUALIZAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, uc.getNome());
            ps.setString(2, uc.getTipo());
            ps.setString(3, uc.getValidade());
            ps.setString(4, uc.getQuantidade());
            ps.setString(5, uc.getPrimaryKey());
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
        }
        System.out.println(sql);
        return rsu;
    }
      
      
      public static int eliminar(String id) {
        int rsu = 0;
        String sql = Produtos.ELIMINAR;

        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, id);
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql);
        return rsu;
    }

    public static int eliminaTodos() {
        int rsu = 0;
        String sql = Produtos.ELIMINAR_TUDO;
        try {
            ps = cn.prepareStatement(sql);
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql);
        return rsu;
    }
    
    
    
    
    public static void listarCat(String busca) {
        DefaultTableModel modelo = (DefaultTableModel) produtos.FrmListaProd.tabelaProduto.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = Produtos.LISTAR;
        } else {
              sql = "SELECT * FROM produtos WHERE (codigoPro like'" + busca + "%' or nomePro like'" + busca + "%') "
                    + "or tipoPro='" + busca + "' ORDER BY nomePro";
            
            
        }
        String dados[] = new String[5];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                dados[0] = rs.getString("codigoPro");
                dados[1] = rs.getString("nomePro");
                dados[2] = rs.getString("tipoPro");
                dados[3] = rs.getString("validadePro");
                dados[4] = rs.getString("quantidadePro");
               
                modelo.addRow(dados);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Produtos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    public static boolean isNumber(String n) {
        try {
            if (Integer.parseInt(n) > 0) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
    
    
    
}
