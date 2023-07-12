package com.example.mediquiz.security.user;


import com.example.mediquiz.security.role.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String email;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = { @JoinColumn(name = "user_id")},
            inverseJoinColumns = { @JoinColumn(name = "role_id")}
    )
    private Collection<Role> roles = new ArrayList<>();

    public User(String password, String name, String email, Collection<Role> roles) {
        this.password = password;
        this.email = email;
        this.roles = roles;
        this.name = name;
    }
}
