package com.routeshare.server.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "route_room")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RouteRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 2,max = 20)
    private String title;

    @NotBlank
    private String driverName;

    @NotBlank
    private String departure;

    @NotBlank
    private String destination;

    @Positive
    private Integer seatCount;

    @Positive
    private Integer activeCount;

}