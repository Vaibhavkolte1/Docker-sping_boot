package com.college.e_commarce.entity;

import com.college.e_commarce.enums.Role;
import com.college.e_commarce.enums.UserStatus;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @ToString.Exclude
    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String address;

    private UserStatus active;

    @ToString.Exclude
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(
            mappedBy = "seller",
            orphanRemoval = true,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @ToString.Exclude
    private List<Product> productList = new ArrayList<>();

    @ToString.Exclude
    @OneToMany(
            mappedBy = "buyer",
            orphanRemoval = true,
            cascade = CascadeType.ALL
    )
    private List<Order> orderList = new ArrayList<>();

    @OneToOne(mappedBy = "owner", cascade = CascadeType.ALL)
    private Cart cart;

    // ---------------
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> "ROLE_" + role.name());
    }

    @Override
    public String getUsername() {
        return this.email;
    }
}
