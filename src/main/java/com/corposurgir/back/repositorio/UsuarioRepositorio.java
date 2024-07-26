package com.corposurgir.back.repositorio;

import com.corposurgir.back.modelo.EntidadUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<EntidadUsuario, String> {
}
