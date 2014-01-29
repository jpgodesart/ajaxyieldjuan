/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.bean;

/**
 *
 * @author rafa
 */
public class UsuarioBean {

    private Integer id=0;
    private String login="";
    private String password="";

    public UsuarioBean() {

    }

    public UsuarioBean(Integer id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
