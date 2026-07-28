package kr.ac.ksj.course_registration.repository;

import kr.ac.ksj.course_registration.entity.CourseSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseScheduleRepository extends JpaRepository<CourseSchedule, Long> {
}
