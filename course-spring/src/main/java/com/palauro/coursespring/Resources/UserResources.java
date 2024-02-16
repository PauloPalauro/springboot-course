package com.palauro.coursespring.Resources;

import com.palauro.coursespring.Entities.User;
import com.palauro.coursespring.Services.UserService;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// Classe que disponibiliza um Recurso Web correspondente a entidade User. Testa se o REST do SpringBoot ta funcionando.

@RestController // @RestController = Falando que a classe é um recurso Web, que implementado por um Controlador REST.
@RequestMapping(value = "/users") // @RequestMapping(value = "/users") = Caminho do recurso. "URL"
public class UserResources {

    @Autowired
    private UserService service;

    // Indicar que o método responde do tipo GET do HTTP.
    @GetMapping()
    // Método que vai ser um EndPoint para acessar os usuários.
    public ResponseEntity<List<User>> findAll() { // ResponseEntity<T> = Tipo especifico do Spring para retornar respostas de requisições Web
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list); // ok() = retorna a resposta com sucesso no HTTP , body() = retorna o corpo da resposta.
    }

    // Passar na URL o valor do ID do user, entre "{}".
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) { // @PathVariable = Considerar o id como parametro que vai chegar na URL
        User obj = service.findByID(id);
        return ResponseEntity.ok().body(obj);
    }
}
