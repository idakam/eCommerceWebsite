package com.ecommerce.ecommerceProject.model;

import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;
//
    @NotEmpty(message = "Please provide a username")
    @Length(min = 3, message = "Your username must have at least 3 characters")
    @Length(max = 15, message = "Your username cannot have more than 15 characters")
    @Pattern(regexp = "[^\\s]+", message = "Your username cannot contain spaces")
    private String username;

//    @Length(min = 5, message = "Your password must have at least 5 characters")
//    @NotEmpty(message = "Please provide a password")
//    @JsonProperty(access = Access.WRITE_ONLY)
    private String password;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private Set<Role> roles;

    @Transient
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @ElementCollection
    private Map<Product, Integer> cart;

    @Transient
    public boolean isAccountNonExpired() {
        return true;
    }

    @Transient
    public boolean isAccountNonLocked() {
        return true;
    }

    @Transient
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Transient
    public boolean isEnabled() {
        return true;
    }

}

