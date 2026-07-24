package kr.ac.ksj.course_registration.request_dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import kr.ac.ksj.course_registration.entity.enums.Department;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequestDto {

    @NotBlank(message = "아이디는 필수입니다.")
    private String loginId;

    @NotBlank(message = "비밀번호는 필수입니다.")
    private String password;

    @NotBlank(message = "이름은 필수입니다.")
    private String userName;

    @NotBlank(message = "전화번호는 필수입니다.")
    private String userPhoneNumber;

    @NotNull(message = "학부는 필수입니다.")
    private Department department;
}
