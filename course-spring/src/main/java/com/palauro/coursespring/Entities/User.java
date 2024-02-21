package com.palauro.coursespring.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

// Camada de dominío (Entities)

// Anotações para o JPA, de como converter os objetos para o modelo relacional.
@Entity
@Table(name = "tb_user") // Cria a tabela de users.
public class User implements Serializable {

    @Id // Mostra que é chave primaria.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto incrementação.
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;

    //Associação "Para muitos" o JPA não carrega -> [Client para muito pedidos = Não carrega os pedidos], lazy loading
    @JsonIgnore // Associação de mão dupla, fica um loop de "Users chamando Orders e Orders chamando Users", @JsonIgnore = Faz oque foi falado acima.
    @OneToMany(mappedBy = "client") // Opcional, Associação de "Um para muitos", colocar o nome do atributo do outro lado da associação.
    private List<Order> orders = new ArrayList<>();

    public User() {
    }

    public User(Long id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
