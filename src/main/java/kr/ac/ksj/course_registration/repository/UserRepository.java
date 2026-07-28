package kr.ac.ksj.course_registration.repository;

import kr.ac.ksj.course_registration.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLoginId(String loginId);

    Optional<User> findByUserName(String userName);

    boolean existsByLoginId(String loginId);

    boolean existsByUserPhoneNumber(String userPhoneNumber);
}
