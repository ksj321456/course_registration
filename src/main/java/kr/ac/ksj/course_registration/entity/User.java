package kr.ac.ksj.course_registration.entity;

import jakarta.persistence.*;
import kr.ac.ksj.course_registration.entity.enums.Department;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(
                name = "uk_user_phone_number",
                columnNames = {"user_phone_number"}
        )
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "id", nullable = false)
    private String loginId;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "user_phone_number", nullable = false)
    private String userPhoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "department", nullable = false)
    private Department department;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime created_at;

}
