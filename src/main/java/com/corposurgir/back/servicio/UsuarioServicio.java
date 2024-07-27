package com.corposurgir.back.servicio;

import com.corposurgir.back.modelo.EntidadUsuario;

import java.util.List;

public interface UsuarioServicio {

    public EntidadUsuario crearUsuario(EntidadUsuario usuario);

    public EntidadUsuario modificarUsuario(String documento, EntidadUsuario usuario);

    public EntidadUsuario obtenerPorDocumento(String documento);

    public List<EntidadUsuario> obtenerTodosUsuarios();

    public EntidadUsuario eliminarUsuario(String documento);
}
