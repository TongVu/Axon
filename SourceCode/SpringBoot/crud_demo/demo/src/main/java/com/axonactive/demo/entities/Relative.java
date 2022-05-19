package com.axonactive.demo.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@Entity
@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "relatives")
public class Relative {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max=255)
    private String fullName;

    @NotNull
    private int gender;

    @NotNull
    @Size(max=255)
    private String phoneNumber;

    @NotNull
    @Size(max=255)
    private String relationship;

    @ManyToOne
    @JoinColumn (name = "employeeid")
    private Employee employee;
}
