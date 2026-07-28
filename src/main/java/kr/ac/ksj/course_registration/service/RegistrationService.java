package kr.ac.ksj.course_registration.service;

import kr.ac.ksj.course_registration.entity.*;
import kr.ac.ksj.course_registration.repository.*;
import kr.ac.ksj.course_registration.request_dto.RegistrationCourseRequestDto;
import kr.ac.ksj.course_registration.request_dto.RegistrationProfessorRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final ProfessorRepository professorRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final CourseSectionRepository courseSectionRepository;
    private final CourseScheduleRepository courseScheduleRepository;

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

    public Long registrationCourseService(RegistrationCourseRequestDto registrationCourseRequestDto) {

        // 요청 DTO에 담긴 교수 확인
        String professorName = registrationCourseRequestDto.getProfessorName();
        String professorEmail = registrationCourseRequestDto.getProfessorEmail();
        Professor professor = professorRepository.findByProfessorNameAndProfessorEmail(professorName, professorEmail)
                .orElseThrow(IllegalArgumentException::new);

        // User 확인
        User user = userRepository.findByUserName(registrationCourseRequestDto.getUserName())
                .orElseThrow(IllegalAccessError::new);

        // 과목 생성
        Course newCourse = Course.builder()
                .courseCode(registrationCourseRequestDto.getCourseCode())
                .courseName(registrationCourseRequestDto.getCourseName())
                .description(registrationCourseRequestDto.getDescription())
                .credits(registrationCourseRequestDto.getCredits())
                .department(registrationCourseRequestDto.getDepartment())
                .createdAt(LocalDateTime.now())
                .build();
        courseRepository.save(newCourse);

        // 분반 생성
        CourseSection section = CourseSection.builder()
                .semester(registrationCourseRequestDto.getSemester())
                .year(registrationCourseRequestDto.getYear())
                .capacity(registrationCourseRequestDto.getCapacity())
                .enrolledCount(registrationCourseRequestDto.getEnrolledCount())
                .classroom(registrationCourseRequestDto.getClassroom())
                .created_at(LocalDateTime.now())
                .user(user)
                .course(newCourse)
                .professor(professor)
                .build();

        CourseSection savedSection = courseSectionRepository.save(section);

        // 시간표 생성
        CourseSchedule schedule = CourseSchedule.builder()
                .day(registrationCourseRequestDto.getDay())
                .startTime(registrationCourseRequestDto.getStartTime())
                .endTime(registrationCourseRequestDto.getEndTime())
                .courseSection(savedSection)
                .build();

        courseScheduleRepository.save(schedule);

        return savedSection.getCourseSectionId();
    }
}
