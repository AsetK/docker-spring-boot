package com.epam.docker.springbootdocker.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "person")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @Column(name = "person_id")
    @SequenceGenerator(name = "document_id_seq_gen", sequenceName = "seq_person", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "document_id_seq_gen")
    private int personID;

    @NonNull
    @Column(name = "first_name")
    private String firstName;

    @NonNull
    @Column(name = "last_name")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String lastName;


}
