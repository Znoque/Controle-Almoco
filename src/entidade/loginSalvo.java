/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

/**
 *
 * @author Znoque
 */
public class loginSalvo {
    private static String usuario;
    private static String senha;

    public static String getUsuario() {
        return usuario;
    }

    public static void setUsuario(String usuario) {
        loginSalvo.usuario = usuario;
    }

    public static String getSenha() {
        return senha;
    }

    public static void setSenha(String senha) {
        loginSalvo.senha = senha;
    }
}
