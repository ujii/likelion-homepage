package com.homepage.likelion.test;

import lombok.*;

@Getter
@Setter
@Builder // Builder 패턴 사용
@NoArgsConstructor
@AllArgsConstructor
public class SimpleDto {
    private String userId;

    public String email;
}
