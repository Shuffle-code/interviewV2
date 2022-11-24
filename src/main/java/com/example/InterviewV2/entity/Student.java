package com.example.InterviewV2.entity;
import lombok.*;
import javax.persistence.*;
@Entity
@Table(name = "student")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "MARK")
    private double mark;

}