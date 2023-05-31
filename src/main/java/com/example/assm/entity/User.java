package com.example.assm.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    @Column(name = "Name")
    private String name;
    @Column(name = "fullname")
    private String fullname;
    @Column(name = "Password")
    private String password;
    @Column(name = "Phone")
    private String phone;
    @Column(name = "Email")
    private String email;
    @Column(name = "Addresss")
    private String address;
    @Column(name = "Roles")
    private Boolean role;
    @Column(name = "Created_time")
    private Date createdtime;
    @Column(name = "Updated_time")
    private Date updateedtime;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Order> orderSet=new HashSet<>();


}
