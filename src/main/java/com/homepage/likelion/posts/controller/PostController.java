package com.homepage.likelion.posts.controller;

import com.homepage.likelion.domain.Post;
import com.homepage.likelion.posts.dto.PostCreateDto;
import com.homepage.likelion.posts.dto.PostUpdateDto;
import com.homepage.likelion.posts.service.PostService;
import com.homepage.likelion.util.response.CustomApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class PostController {

    private final PostService postService;

    // 게시글 작성
    @PostMapping
    public ResponseEntity<CustomApiResponse<?>> createPost(@Valid @RequestBody PostCreateDto.Req req) {

        ResponseEntity<CustomApiResponse<?>> result = postService.createPost(req);
        return result;
    }

    // 게시글 수정
    // api/post/1234 -> postId 1234인 게시글 수정
    // @PathVariable은 요청 URL의 경로 변수 값을 메소드 파라미터에 바인딩할 때 사용
    @PutMapping("/{postId}")
    public ResponseEntity<CustomApiResponse<?>> modifyPost(@PathVariable("postId") Long postId, @RequestBody PostUpdateDto.Req req) {
        ResponseEntity<CustomApiResponse<?>> result = postService.modifyPost(postId, req);
        return result;
    }

    // 게시글 한 개 조회
    @GetMapping
    public ResponseEntity<CustomApiResponse<?>> getOnePost(@RequestParam("postId") Long postId) {
        ResponseEntity<CustomApiResponse<?>> result = postService.getOnePost(postId);
        return result;
    }

    @GetMapping("/all")
    public ResponseEntity<CustomApiResponse<?>> getAllPosts() {
        ResponseEntity<CustomApiResponse<?>> result = postService.getAllPosts();
        return result;
    }

}
