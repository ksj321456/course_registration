package kr.ac.ksj.course_registration.entity.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
public enum Department {

    COMPUTER_ENGINEERING("컴퓨터공학과"),
    AI("AI학과");

    private final String description;

    Department(String description) {
        this.description = description;
    }

    @JsonValue
    public String getDescription() {
        return description;
    }

    @JsonCreator
    public static Department from(String description) {

        return Arrays.stream(values())
                .filter(element -> element.description.equals(description))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 학부명입니다."));
    }
}