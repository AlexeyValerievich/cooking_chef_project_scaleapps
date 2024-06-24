package ru.evgen.cooking_chef_project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "university_groups")
@Getter
@Setter
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "group_number")
    private String number;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    private List<Student> students;

}
