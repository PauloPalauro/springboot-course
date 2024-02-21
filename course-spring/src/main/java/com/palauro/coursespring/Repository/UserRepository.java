package com.palauro.coursespring.Repository;

import com.palauro.coursespring.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

// Camada de acesso a dados / Data access Layer (Repository)

// Arquivo responsavel por fazer operações com a entidade User

public interface UserRepository extends JpaRepository<User, Long> {

    // Não precisa implementar porque com a definição "extends JpaRepository<T, ID>" ja tem as implementações padrões.

}
