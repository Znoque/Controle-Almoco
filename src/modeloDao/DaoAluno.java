/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDao;

import entidade.aluno;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import utilitarios.ConectaBanco;

/**
 *
 * @author Znoque
 */
public class DaoAluno {
    ConectaBanco conexao = new ConectaBanco();
    aluno mod = new aluno();
    
    public aluno buscaAluno(aluno mod){
        conexao.conectar();
        conexao.executaSql("select * from alunos where nome like'%"+mod.getPesquisa()+"%'");
        try {
            conexao.rs.first();
            mod.setMatricula(conexao.rs.getInt("matricula"));
            mod.setNome(conexao.rs.getString("nome"));
            mod.setCurso(conexao.rs.getString("curso"));
            mod.setTurma(conexao.rs.getString("turma"));
            mod.setTurno(conexao.rs.getString("turno"));
            mod.setSerie(conexao.rs.getString("serie"));
            mod.setIdCartao(conexao.rs.getString("idcartao"));
            mod.setDia(conexao.rs.getString("dia"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar aluno!\nErro: "+ex.getMessage());
        }
        conexao.desconectar();
        return mod;
    }
    
    /*public void excluir(Aluno mod){
        conexao.conectar();
        PreparedStatement pst;
        try {
            pst = conexao.conn.prepareStatement("delete from alunos where matricula=?");
            pst.setInt(1, Integer.parseInt(txtMatricula.getText()));
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso!\nErro: "+ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir dados!\nErro: "+ex.getMessage());
        }
        
        conexao.desconectar();
    }
    
    public void editar(Aluno mod){
        conexao.conectar();
        try {
            PreparedStatement pst = conexao.conn.prepareStatement("update alunos set matricula=?, nome=?, curso=?, turmav, turno=?, serie=?, idcartao=?, imagem=?, where: matricula=?");
            pst.setInt(1, Integer.parseInt(txtMatricula.getText()));
            pst.setString(2, txtNome.getText());
            pst.setString(3, String.valueOf(jBoxCurso.getSelectedItem()));
            pst.setString(4, String.valueOf(jBoxTurma.getSelectedItem()));
            pst.setString(5, String.valueOf(jBoxTurno.getSelectedItem()));
            pst.setString(6, String.valueOf(jBoxSerie.getSelectedItem()));
            pst.setString(7, lblId.getText());
            pst.setBytes(8, mod.getImagem());
            
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na alteração dos dados!\nERRO: "+ex);
        }
        
        
        conexao.desconectar();
    }*/
}
