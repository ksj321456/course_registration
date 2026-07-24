package kr.ac.ksj.course_registration.service;

import jakarta.servlet.http.HttpSession;
import kr.ac.ksj.course_registration.entity.User;
import kr.ac.ksj.course_registration.repository.UserRepository;
import kr.ac.ksj.course_registration.request_dto.LoginRequestDto;
import kr.ac.ksj.course_registration.request_dto.SignUpRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    @Transactional
    public void signUp(SignUpRequestDto signUpRequestDto) {

        if (userRepository.existsByLoginId(signUpRequestDto.getLoginId())) {
            throw new IllegalArgumentException("이미 회원등록된 회원입니다.");
        }

        if (userRepository.existsByUserPhoneNumber(signUpRequestDto.getUserPhoneNumber())) {
            throw new IllegalArgumentException("이미 등록되어 있는 전화번호입니다.");
        }

        User user = User.builder()
                .loginId(signUpRequestDto.getLoginId())
                .password(signUpRequestDto.getPassword())
                .userName(signUpRequestDto.getUserName())
                .userPhoneNumber(signUpRequestDto.getUserPhoneNumber())
                .department(signUpRequestDto.getDepartment())
                .created_at(LocalDateTime.now())
                .build();

        userRepository.save(user);
    }

    public void login(LoginRequestDto request, HttpSession session) {

        User user = userRepository.findByLoginId(request.getLoginId())
                .orElseThrow(() -> new IllegalArgumentException("아이디 또는 비밀번호가 틀렸습니다."));

        if (!request.getPassword().equals(user.getPassword())) {
            throw new IllegalArgumentException("아이디 또는 비밀번호가 틀렸습니다.");
        }


        // 로그인 성공 후 세션에 저장
        session.setAttribute("loginUser", user);
    }

}
