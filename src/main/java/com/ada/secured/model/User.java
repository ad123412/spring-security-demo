package com.ada.secured.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@ToString
@Table(name="users")
public class User {
    @Id
    private int id;
    private String userName;
    private String password;
    private String role;
    private String email;
}
