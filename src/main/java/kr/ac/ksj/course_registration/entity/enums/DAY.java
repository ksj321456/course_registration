package kr.ac.ksj.course_registration.entity.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum DAY {
    MONDAY("월요일"), TUESDAY("화요일"), WEDNESDAY("수요일"), THURSDAY("목요일"), FRIDAY("금요일"), SATURDAY("토요일"), SUNDAY("일요일");


    private final String day;

    DAY(String day) {
        this.day = day;
    }

    @JsonValue
    public String getDay() {
        return day;
    }

    @JsonCreator
    public static DAY from(String day) {
        return Arrays.stream(values())
                .filter(element -> element.day.equals(day))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 요일입니다."));
    }
}
