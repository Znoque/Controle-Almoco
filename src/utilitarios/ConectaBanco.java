package utilitarios;

import entidade.aluno;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
//169.254.78.228:3306
public class ConectaBanco {
    public Statement stm;//RESPONSÁVEL POR PREPARAR E REALIZAR PESQUISAS NO BANCO DE DADOS
    public ResultSet rs;//RESPONSÁVEL POR ARMAZENAR O RESULTADO DE UMA PESQUSA PASSADA PARA O STATEMENT
    private String driver = "com.mysql.jdbc.Driver";//RESPONSÁVEL POR IDENTIFICAR O SERVIÇO DO BANCO DE DADOS
    private String caminho = "jdbc:mysql://localhost:3306/almoco";//RESPONSÁVEL POR SETAR O LOCAL DO BANCO DE DADOS
    private String usuario;
    private String senha;
    public Connection conn;//RESPONSÁVEL POR REALIZAR A CONEXÃO COM O BANCO DE DADOS
    private boolean banco;

    public ConectaBanco(){
    
    }
    
    public ConectaBanco(String usuario, String senha){
        this.usuario=usuario;
        this.senha=senha;
    }
    
    public boolean isBanco() {
        return banco;
    }

    public void setBanco(boolean banco) {
        this.banco = banco;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public void conectar(){//MÉTODO RESPONSÁVEL POR REALIZAR A CONEXÃO COM O BANCO
        try {//TENTATIVA INICIAL
            System.setProperty("jdbc.Drivers", driver);//SETA A PROPRIEDADE DO DRIVER DE CONEXÃO
            conn = DriverManager.getConnection(caminho, usuario, senha);//REALIZA A CONEXÃO COM O BANCO DE DADOS
            setBanco(true);
            //JOptionPane.showMessageDialog(null, "Conectado com sucesso!");//IMPRIME UMA CAIXA DE DIÁLOGO
        } catch (SQLException ex) {//EXCESSÃO
            //Logger.getLogger(ConectaBanco.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro de Conexão!\nErro: "+ex.getMessage());//IMPRIME UMA CAIXA DE DIÁLOGO INFORMANDO QUAL FOI O ERRO
            setBanco(false);
        }
    }
    
    public void executaSql(String sql){
        try {
            stm = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ExecutaSql:\nErro: "+ex.getMessage());
        }
    }    
    
    public void desconectar(){//MÉTODO PARA FECHAR A CONEXÃO COM O BANCO DE DADOS
        try {//TENTATIVA INICIAL
            conn.close();//FECHA A CONEXÃO
            setBanco(false);
        } catch (SQLException ex) {//EXCESSÃO
            //Logger.getLogger(ConectaBanco.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao fechar a Conexão!\nErro: "+ex.getMessage());//IMPRIME UMA CAIXA DE DIÁLOGO INFORMANDO QUAL FOI O ERRO
        }
    }
}