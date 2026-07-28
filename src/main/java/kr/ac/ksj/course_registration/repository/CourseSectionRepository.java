package kr.ac.ksj.course_registration.repository;

import kr.ac.ksj.course_registration.entity.CourseSection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSectionRepository extends JpaRepository<CourseSection, Long> {
}
