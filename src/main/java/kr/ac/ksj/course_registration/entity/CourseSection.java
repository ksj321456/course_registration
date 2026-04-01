package kr.ac.ksj.course_registration.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CourseSection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_section_id")
    private Long courseSectionId;

    @Column(name = "semester", nullable = false)
    private String semester;

    @Column(name = "year", nullable = false)
    private int year;

    @Column(name = "capacity", nullable = false)
    private String capacity;

    @Column(name = "enrolled_count", nullable = false)
    private int enrolledCount = 0;

    @Column(name = "classroom", nullable = false)
    private String classroom;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime created_at;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

}
