package com.example.backendshelter.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.ManyToOne;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
class Volunteer {
    @Id
    private Long id;

    @ManyToOne
    private Shelter shelter;
}
