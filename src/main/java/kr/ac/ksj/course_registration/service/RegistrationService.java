package kr.ac.ksj.course_registration.service;

import kr.ac.ksj.course_registration.entity.Professor;
import kr.ac.ksj.course_registration.repository.ProfessorRepository;
import kr.ac.ksj.course_registration.request_dto.RegistrationProfessorRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final ProfessorRepository professorRepository;

    public RegistrationProfessorRequestDto registrationProfessorService(RegistrationProfessorRequestDto registrationProfessorRequestDto) {

        Professor professor = Professor.builder()
                .professorEmail(registrationProfessorRequestDto.getProfessorEmail())
                .professorName(registrationProfessorRequestDto.getProfessorName())
                .office(registrationProfessorRequestDto.getOffice())
                .department(registrationProfessorRequestDto.getDepartment())
                .phoneNumber(registrationProfessorRequestDto.getPhoneNumber())
                .createdAt(LocalDateTime.now())
                .build();

        professorRepository.save(professor);

        return registrationProfessorRequestDto;
    }
}
