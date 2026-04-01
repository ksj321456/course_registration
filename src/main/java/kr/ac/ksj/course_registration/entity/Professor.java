package kr.ac.ksj.course_registration.entity;

import jakarta.persistence.*;
import kr.ac.ksj.course_registration.entity.enums.Department;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "professor_id")
    private Long professorId;

    @Column(name = "professor_name", nullable = false)
    private String professorName;

    @Column(name = "professor_email", nullable = false, unique = true)
    private String professorEmail;

    @Enumerated(EnumType.STRING)
    @Column(name = "department")
    private Department department;

    @Column(name = "office", nullable = false)
    private String office;

    @Column(name = "professor_phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}
