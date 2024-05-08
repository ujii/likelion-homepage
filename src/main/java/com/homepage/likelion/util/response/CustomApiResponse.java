package com.homepage.likelion.util.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor // 모든 필드를 갖는 생성자 어노테이션
@NoArgsConstructor
public class CustomApiResponse<T> {

    // status, data, message
    private int status;
    private T data;
    private String message;

    // 성공
    public static <T> CustomApiResponse<T> createSuccess(int status, T data, String message) {
        return new CustomApiResponse<>(status, data, message);
    }

    // 실패
    public static <T> CustomApiResponse<T> createFailWithout(int status, String message) {
        return new CustomApiResponse<>(status, null, message);
    }

}
