package kr.ac.ksj.course_registration.request_dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import kr.ac.ksj.course_registration.entity.enums.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RegistrationProfessorRequestDto {

    @NotBlank(message = "교수 이름을 입력해주세요.")
    private String professorName;

    @NotBlank(message = "교수 이메일을 입력해주세요.")
    private String professorEmail;

    @NotNull(message = "학부를 선택해주세요.")
    private Department department;

    @NotBlank(message = "사무실을 입력해주세요.")
    private String office;

    @NotBlank(message = "전화번호를 입력해주세요.")
    private String phoneNumber;
}
