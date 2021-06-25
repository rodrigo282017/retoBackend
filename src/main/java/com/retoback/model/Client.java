package com.retoback.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

@Data
@Entity
@Table(name = "CLIENT")
public class Client {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Column(name = "name")
  private String name;

  @NotNull
  @Column(name = "last_name")
  private String lastName;

  @NotNull
  @Column(name = "age")
  private int age;

  @Past
  @NotNull
  @Column(name = "date_of_birth")
  private Date dateOfBirth;

  @Transient
  private Date possibleDateOfDeath;
}
