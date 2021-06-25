package com.retoback.model;

import lombok.*;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClientDTO {
  private String name;
  private String lastName;
  private int age;
  private Date dateOfBirth;
}
