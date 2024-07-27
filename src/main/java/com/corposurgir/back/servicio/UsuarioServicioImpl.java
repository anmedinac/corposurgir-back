package com.corposurgir.back.servicio;

import com.corposurgir.back.modelo.EntidadUsuario;
import com.corposurgir.back.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicioImpl implements UsuarioServicio{

    /**
     * Voy a enviar la información a la base de datos
     * */
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public EntidadUsuario crearUsuario(EntidadUsuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    @Override
    public EntidadUsuario modificarUsuario(String documento, EntidadUsuario usuario) {
        // primer busco si existe lo que me envian para hacer la modificación
        EntidadUsuario usuarioAModificar= usuarioRepositorio.findById(documento).orElse(null);
        // operador de validación
        if(usuarioAModificar == null){
            // error
        }
        // va a modificar el usuario
        usuarioAModificar.setApellido(usuario.getApellido());
        usuarioAModificar.setClave(usuario.getClave());
        usuarioAModificar.setCorreo(usuario.getCorreo());
        usuarioAModificar.setDireccion(usuario.getDireccion());
        usuarioAModificar.setNombre(usuario.getNombre());
        usuarioAModificar.setTipodocumento(usuario.getTipodocumento());
        usuarioAModificar.setTelefono(usuario.getTelefono());
        return usuarioRepositorio.save(usuarioAModificar);
    }

    @Override
    public EntidadUsuario obtenerPorDocumento(String documento) {
        return usuarioRepositorio.findById(documento).orElse(null);
    }

    @Override
    public List<EntidadUsuario> obtenerTodosUsuarios() {
        return usuarioRepositorio.findAll();
    }

    @Override
    public EntidadUsuario eliminarUsuario(String documento) {
        EntidadUsuario usuarioAEliminar = usuarioRepositorio.findById(documento).orElse(null);
        usuarioRepositorio.deleteById(documento);
        return usuarioAEliminar;
    }
}
