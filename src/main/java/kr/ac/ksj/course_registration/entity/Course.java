package kr.ac.ksj.course_registration.entity;

import jakarta.persistence.*;
import kr.ac.ksj.course_registration.entity.enums.Department;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "course",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_course_code",
                        columnNames = {"course_code"}
                )
        }
)
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "course_code", nullable = false)
    private String courseCode;

    @Column(name = "course_name", nullable = false)
    private String courseName;

    @Column(name = "description", nullable = false)
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String description;

    @Column(name = "credits", nullable = false)
    private int credits;


    @Enumerated(EnumType.STRING)
    @Column(name = "department", nullable = false)
    private Department department;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}
