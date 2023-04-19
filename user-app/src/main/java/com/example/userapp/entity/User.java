package com.example.userapp.entity;

import com.example.userapp.entity.enums.GenderEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "gender")
    private GenderEnum gender;

    @Column(name = "age")
    private int age;

    @Column(name = "department_id")
    private String departmentId;

    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }
}
