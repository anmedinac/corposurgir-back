package com.corposurgir.back.controlador;

import com.corposurgir.back.modelo.EntidadUsuario;
import com.corposurgir.back.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UsuarioControlador {

    /***
     * Funciones de una api rest
     * POST -> CREAR
     * PUT-> MODIFICAR UN CAMPO DEL OBJETO O UN SOLO OBJETO
     * GET-> OBTENER INFORMACIÓN
     * DELETE-> ELIMINAR UN RECURSO
     * ****/
    @Autowired
    private UsuarioServicio usuarioServicio;

    @PostMapping("/crear-usuario")
    public ResponseEntity<?> crearUsuario(@RequestBody EntidadUsuario usuario) {
        return ResponseEntity.ok(usuarioServicio.crearUsuario(usuario));
    }

    @PutMapping("/modificar-usuario/{documento}")
    public ResponseEntity<?> modificarUsuario(@RequestBody EntidadUsuario usuario, @PathVariable String documento){
        return ResponseEntity.ok(usuarioServicio.modificarUsuario(documento,usuario));
    }

    @GetMapping("/usuario-por-documento/{documento}")
    public ResponseEntity<?> obtenerUsuarioPorDocumento(@PathVariable String documento){
        return ResponseEntity.ok(usuarioServicio.obtenerPorDocumento(documento));
    }


    @GetMapping( "/todos-los-usuarios")
    public ResponseEntity<?> obtenerTodosLosUsuarios(){
        return ResponseEntity.ok(usuarioServicio.obtenerTodosUsuarios());
    }

    @DeleteMapping("/eliminar-usuario/{documento}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable String documento){
        usuarioServicio.eliminarUsuario(documento);
        return ResponseEntity.ok("Se elimina usuario correctamente");
    }

}
