package com.homepage.likelion.posts.dto;

import com.homepage.likelion.domain.Post;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.sql.Update;

import java.time.LocalDateTime;

public class PostUpdateDto {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Req {

        private String title;
        private String content;
        private String postedUserName;
        private String password;
    }

    // 수정 api Response
    // 게시글 수정 : updatedAt
    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class UpdatePost {
        private LocalDateTime updatedAt;
        public UpdatePost(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
        }
    }

}
