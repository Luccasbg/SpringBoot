/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basicsystem.repository;

import com.basicsystem.model.Usuario;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Leandro
 */
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {  
    Optional<Usuario> findByEmail(String email); 
}
