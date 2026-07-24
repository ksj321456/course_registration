package kr.ac.ksj.course_registration.controller;

import jakarta.validation.Valid;
import kr.ac.ksj.course_registration.entity.Professor;
import kr.ac.ksj.course_registration.request_dto.RegistrationProfessorRequestDto;
import kr.ac.ksj.course_registration.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("/professor")
    public ResponseEntity<?> registrationProfessor(@RequestBody @Valid RegistrationProfessorRequestDto registrationProfessorRequestDto) {

        // 요청 DTO DB에 저장
        RegistrationProfessorRequestDto dto = registrationService.registrationProfessorService(registrationProfessorRequestDto);

        // 저장된 내용 클라이언트에 반환
        return ResponseEntity.ok().body(dto);
    }
}
