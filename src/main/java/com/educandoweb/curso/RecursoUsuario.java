package com.educandoweb.curso;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuarios")
public class RecursoUsuario {
    @GetMapping
    public ResponseEntity<Usuario> findAll(){
        Usuario user = new Usuario(1L,"gabriela", "ge7384005@gmail.com","67981620657","90302121");
        return ResponseEntity.ok().body(user);

    }

}
