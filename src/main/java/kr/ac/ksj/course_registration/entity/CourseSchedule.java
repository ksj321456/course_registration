package kr.ac.ksj.course_registration.entity;

import jakarta.persistence.*;
import kr.ac.ksj.course_registration.entity.enums.DAY;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "course_schedule")
public class CourseSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_schedule_id")
    private Long courseScheduleId;

    @Enumerated(EnumType.STRING)
    @Column(name = "day", nullable = false)
    private DAY day;

    @Column(name = "start_time", nullable = false)
    private LocalTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalTime endTime;

    @ManyToOne
    @JoinColumn(name = "course_section_id")
    private CourseSection courseSection;

}
