/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

/**
 *
 * @author Admin
 */
import Models.Login_;
import entity.Usuario;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;



@ManagedBean(name = "LoginController")
@SessionScoped
public class LoginController implements Serializable{
private Models.UsuarioFacade ejbFacade;
    private List<Usuario> items = null;
    private Usuario selected;
    private Login_ log;
    private String username;
    private String password;
   
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
   
    public void login(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;
        message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Los dato llegan");
        if(username != null && log.LoginExists(username, password)==true && password != null) {
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenid@", username);
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Datos incorrectos");
        }
         
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("Loggeado", loggedIn);
       
    }   
}