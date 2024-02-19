package com.palauro.coursespring.Resources;

import com.palauro.coursespring.Entities.User;
import com.palauro.coursespring.Services.UserService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// Classe que disponibiliza um Recurso Web correspondente a entidade User. Testa se o REST do SpringBoot ta funcionando.

@RestController // @RestController = Falando que a classe é um recurso Web, que implementado por
                // um Controlador REST.
@RequestMapping(value = "/users") // @RequestMapping(value = "/users") = Caminho do recurso. "URL"
public class UserResources {

    @Autowired
    private UserService service;

    // Indicar que o método responde do tipo GET do HTTP.
    @GetMapping()
    // Método que vai ser um EndPoint para acessar os usuários.
    public ResponseEntity<List<User>> findAll() { // ResponseEntity<T> = Tipo especifico do Spring para retornar
                                                  // respostas de requisições Web
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list); // ok() = retorna a resposta com sucesso no HTTP , body() = retorna o
                                               // corpo da resposta.
    }

    // Passar na URL o valor do ID do user, entre "{}".
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) { // @PathVariable = Considerar o id como parametro que
                                                                  // vai chegar na URL
        User obj = service.findByID(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping // Indicar que o método responde do tipo POST do HTTP.
    public ResponseEntity<User> insert(@RequestBody User obj) { // @RequestBody = Dizer que vai chegar um objeto "JSON"
                                                                // e que ele será deserializado para um objeto "User"
        obj = service.insert(obj);
        // Quando queremos adicionar um recurso queremos o codigo 201 do HTTP
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); // Forma padrão de gerar esse endereço. Criando a URI.
        return ResponseEntity.created(uri).body(obj); 
        // ResponseEntity.created(URI) = Espera um Objeto "URI", por que
        // no padrão HTTP, quando voce retorna um 201 é esperado que a
        // resposta contenha um cabeçalho chamado "location" contendo o
        // endereço do novo recurso que voce inseriu.
    }


    @DeleteMapping(value = "/{id}") // Indicar que o método responde do tipo DELETE do HTTP.
    public ResponseEntity<Void> delete(@PathVariable Long id){ // Void porque não retorna nada.
        service.delete(id);
        return ResponseEntity.noContent().build(); // ResponseEntity.noContent() = resposta sem corpo, codigo HTTP 204.
    }

}
