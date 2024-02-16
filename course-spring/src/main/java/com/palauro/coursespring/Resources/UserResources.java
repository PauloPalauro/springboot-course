package com.palauro.coursespring.Resources;

import com.palauro.coursespring.Entities.User;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

// Classe que disponibiliza um Recurso Web correspondente a entidade User. Testa se o REST do SpringBoot ta funcionando.

@RestController // @RestController = Falando que a classe é um recurso Web, que implementado por um Controlador REST.
@RequestMapping(value = "/users") // @RequestMapping(value = "/users") = Caminho do recurso. "URL"
public class UserResources {
    
    // Indicar que o método responde do tipo GET do HTTP.
    @GetMapping() 
    // Método que vai ser um EndPoint para acessar os usuários.
    public ResponseEntity<User> findAll() { // ResponseEntity<T> = Tipo especifico do Spring para retornar respostas de requisições Web
        User u = new User(1L, "Maria", "maria@gmail.com", "777", "123");
        return ResponseEntity.ok().body(u); // ok() = retorna a resposta com sucesso no HTTP , body() = retorna o corpo da resposta.
    }
}
