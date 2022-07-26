package com.capstone.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.FetchType.*;
import static javax.persistence.GenerationType.*;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class UserDetails {
    @Id @GeneratedValue(strategy = AUTO)
    private Long id;

    private String username;
    private String password;
    @ManyToMany(fetch = EAGER, cascade = {CascadeType.ALL})
    private Collection<Role> roles = new ArrayList<>();
}