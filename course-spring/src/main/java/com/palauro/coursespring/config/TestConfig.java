package com.palauro.coursespring.config;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import com.palauro.coursespring.Entities.User;
import com.palauro.coursespring.Repository.UserRepository;

// Arquivo auxiliar para fazer algumas configurações no projeto. Servir agora para -> Popular o Banco de Dados.

@Configuration // Mostrar para o Spring que uma classe especifica de configuração.
@Profile("test") // Configuração especifica para o perfil de "test".

public class TestConfig implements CommandLineRunner {

    @Autowired // Associar uma instancida de "UserRepository" no "TestConfig"
    private UserRepository userRepository;

    // Método para executar os comando quando o progrma for iniciado. Nessecita -->
    // CommandLineRunner.
    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); // id gerado pelo DB
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        // Chamando o objeto que acessa os dados
        userRepository.saveAll(Arrays.asList(u1, u2)); // saveAll = Passa uma lista de objeto e salva no DB
    }
}
