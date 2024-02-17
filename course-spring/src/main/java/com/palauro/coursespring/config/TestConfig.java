package com.palauro.coursespring.config;

import java.time.Instant;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import com.palauro.coursespring.Entities.Category;
import com.palauro.coursespring.Entities.Order;
import com.palauro.coursespring.Entities.User;
import com.palauro.coursespring.Entities.enums.OrderStatus;
import com.palauro.coursespring.Repository.CategoryRepository;
import com.palauro.coursespring.Repository.OrderRepository;
import com.palauro.coursespring.Repository.UserRepository;

// Arquivo auxiliar para fazer algumas configurações no projeto. Servir agora para -> Popular o Banco de Dados.

@Configuration // Mostrar para o Spring que uma classe especifica de configuração.
@Profile("test") // Configuração especifica para o perfil de "test".

public class TestConfig implements CommandLineRunner {

    @Autowired // Associar uma instancida de "UserRepository" no "TestConfig"
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    // Método para executar os comando quando o progrma for iniciado. Nessecita --> CommandLineRunner.
    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers"); 

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); // id gerado pelo DB
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

        // Chamando o objeto que acessa os dados
        userRepository.saveAll(Arrays.asList(u1, u2)); // saveAll = Passa uma lista de objeto e salva no DB
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
    }
}
