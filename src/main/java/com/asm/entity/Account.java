package com.asm.entity;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Accounts")
public class Account {
    
    @Id
    String username;
    String password;
    String fullname;
    String email;
    String photo;
    @OneToMany(fetch = FetchType.EAGER,mappedBy="account",cascade = CascadeType.ALL)
    List<Authority> authorities;
    @OneToMany(mappedBy="account")
    List<Order> orders;
}
