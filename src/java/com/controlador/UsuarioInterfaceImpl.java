/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.dao.UsuarioInterface;
import com.modelo.Usuario;


public class UsuarioInterfaceImpl implements UsuarioInterface {

    @Override
    public boolean validarUsuario(Usuario u) {
        return u.getUsuario().equals("diego") && u.getPasswd().equals("123456");
    }
    
}
