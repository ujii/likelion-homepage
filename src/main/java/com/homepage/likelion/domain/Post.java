package com.homepage.likelion.domain;

import com.homepage.likelion.util.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "POSTS")
@Builder
public class Post extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "POSTS_ID")
    private Long id;

    @Column(name = "POSTS_TITLE")
    private String title;

    @Column(name = "POSTS_CONTENT")
    private String content;

    @Column(name = "POSTED_USER_NAME")
    private String postedUserName;

    @Column(name = "POSTS_PASSWORD")
    private String password;

    // 게시글 제목을 수정하는 메소드
    public void changeTitle(String title) {
        this.title = title;
    }

    // 게시물 내용을 수정하는 메소드
    public void changeContent(String content) {
        this.content = content;
    }

    // 게시물 작성자 이름을 수정하는 메소드
    public void changeUserName(String postedUserName) {
        this.postedUserName = postedUserName;
    }
}
