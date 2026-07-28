package kr.ac.ksj.course_registration.repository;

import kr.ac.ksj.course_registration.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    Optional<Professor> findByProfessorNameAndProfessorEmail(String professorName, String professorEmail);
}
