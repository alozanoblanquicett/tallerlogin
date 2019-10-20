package com.bean;

//import javax.faces.bean.ManagedBean; error al cargar con face.bean,  no instancia
import com.controlador.UsuarioInterfaceImpl;
import com.dao.UsuarioInterface;
import com.modelo.Usuario;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
//import javax.annotation.ManagedBean;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author DESARROLLADOR
 */
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    private Usuario seleccionar, acceso = new Usuario();
    private UsuarioInterface ui;
    private Usuario[] list = {new Usuario("alberto", "123456"), new Usuario("diego", "654321"),
        new Usuario("rogelio", "163452"), new Usuario("julio", "341652")};

    public void login() {
        FacesContext contex = FacesContext.getCurrentInstance();
        ui = new UsuarioInterfaceImpl();
        boolean validar = ui.validarUsuario(getAcceso());
        if (validar == true) {
            try {
                contex.getExternalContext().redirect("/tallerlogin/faces/bienvenido.xhtml");
            } catch (IOException ex) {
                contex.addMessage(null, new FacesMessage("Error Login", ex.getMessage()));
            }
        } else {
            contex.addMessage(null, new FacesMessage("Error Login", "Usuario no Valido"));
        }
    }

    public void validarSesion() {
        FacesContext contex = FacesContext.getCurrentInstance();
        try {
            if (getAcceso().getUsuario() == null) {
                contex.getExternalContext().redirect("/tallerlogin/faces/index.xhtml");
            }
        } catch (IOException ex) {
            contex.addMessage(null, new FacesMessage("Error Login", ex.getMessage()));
        }
    }

    public void salir() {
        FacesContext contex = FacesContext.getCurrentInstance();
        try {
            if (getAcceso() != null) {
                setAcceso(new Usuario());
            }
            contex.getExternalContext().redirect("/tallerlogin/faces/index.xhtml");
        } catch (IOException ex) {
            contex.addMessage(null, new FacesMessage("Error Login", ex.getMessage()));
        }
    }

    public void msn(Usuario select) {
        setSeleccionar(select);
        System.out.println(getSeleccionar().getUsuario());
    }

    public Usuario getAcceso() {
        return acceso;
    }

    public void setAcceso(Usuario acceso) {
        this.acceso = acceso;
    }

    public UsuarioInterface getUi() {
        return ui;
    }

    public void setUi(UsuarioInterface ui) {
        this.ui = ui;
    }

    public Usuario[] getList() {
        return list;
    }

    public void setList(Usuario[] list) {
        this.list = list;
    }

    public Usuario getSeleccionar() {
        return seleccionar;
    }

    public void setSeleccionar(Usuario seleccionar) {
        this.seleccionar = seleccionar;
    }

}

/*
    public void viewCarsCustomized() {
        Map<String, Object> options = new HashMap();
        FacesContext contex = FacesContext.getCurrentInstance();
        options.put("modal", true);
        options.put("width", 640);
        options.put("height", 340);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
        options.put("headerElement", "customheader");

        //PrimeFaces.current().dialog().openDynamic("viewCars", options, null);
        RequestContext.getCurrentInstance().openDialog("viewCars", options, null);
        System.out.println("hola");
    } */
