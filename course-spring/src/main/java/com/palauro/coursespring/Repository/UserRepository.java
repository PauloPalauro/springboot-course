package com.palauro.coursespring.Repository;

import com.palauro.coursespring.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

// Arquivo responsavel por fazer operações com a entidade User

public interface UserRepository extends JpaRepository<User, Long> {

    // Não precisa implementar porque com a definição "extends JpaRepository<T, ID>" ja tem as implementações padrões.

}