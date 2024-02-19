package com.palauro.coursespring.config;

import java.time.Instant;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import com.palauro.coursespring.Entities.Category;
import com.palauro.coursespring.Entities.Order;
import com.palauro.coursespring.Entities.OrderItem;
import com.palauro.coursespring.Entities.Product;
import com.palauro.coursespring.Entities.User;
import com.palauro.coursespring.Entities.enums.OrderStatus;
import com.palauro.coursespring.Repository.CategoryRepository;
import com.palauro.coursespring.Repository.OrderItemRepository;
import com.palauro.coursespring.Repository.OrderRepository;
import com.palauro.coursespring.Repository.ProductRepository;
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

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    // Método para executar os comando quando o progrma for iniciado. Nessecita --> CommandLineRunner.
    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers"); 

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));


        // Adicionando um produto a uma categoria.
        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);


        // Salvando novamente
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));


        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); // id gerado pelo DB
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

        
        // Chamando o objeto que acessa os dados
        userRepository.saveAll(Arrays.asList(u1, u2)); // saveAll = Passa uma lista de objeto e salva no DB
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
        
    }
}
