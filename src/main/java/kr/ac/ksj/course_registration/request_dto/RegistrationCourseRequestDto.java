package kr.ac.ksj.course_registration.request_dto;

import kr.ac.ksj.course_registration.entity.enums.DAY;
import kr.ac.ksj.course_registration.entity.enums.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalTime;

@Getter
@AllArgsConstructor
public class RegistrationCourseRequestDto {

    private String userName;

    private String courseCode;

    private String courseName;

    private String description;

    private int credits;

    private Department department;

    private DAY day;

    private LocalTime startTime;

    private LocalTime endTime;

    private String semester;

    private int year;

    private String capacity;

    private int enrolledCount;

    private String classroom;

    private String professorName;

    private String professorEmail;

    private DAY courseDay;

    private LocalTime courseStartTime;

    private LocalTime courseEndTime;
}
