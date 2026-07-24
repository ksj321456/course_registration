package kr.ac.ksj.course_registration.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import kr.ac.ksj.course_registration.entity.enums.Department;
import kr.ac.ksj.course_registration.request_dto.LoginRequestDto;
import kr.ac.ksj.course_registration.request_dto.SignUpRequestDto;
import kr.ac.ksj.course_registration.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping("/signup")
    public String signUpPage(Model model) {
        model.addAttribute("signUpRequestDto", new SignUpRequestDto());
        model.addAttribute("departments", Department.values());
        return "signup";
    }

    @PostMapping("/signup")
    public String signUp(@ModelAttribute @Valid SignUpRequestDto signUpRequestDto, BindingResult bindingResult, Model model) {

        // Validation 실패
        if (bindingResult.hasErrors()) {

            model.addAttribute("departments", Department.values());

            return "signup";
        }

        authService.signUp(signUpRequestDto);

        return "redirect:/auth/login";
    }

    @GetMapping("/login")
    public String loginPage(Model model) {

        model.addAttribute("loginRequestDto", new LoginRequestDto());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute @Valid LoginRequestDto loginRequestDto, BindingResult bindingResult,  HttpSession httpSession) {

        if (bindingResult.hasErrors()) {
            return "login";
        }

        // 로그인 로직
        authService.login(loginRequestDto, httpSession);

        // home 화면으로 redirect
        return "redirect:/home";
    }

    @PostMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/auth/login";
    }
}
