package com.homepage.likelion.posts.service;

import com.homepage.likelion.domain.Post;
import com.homepage.likelion.posts.dto.PostCreateDto;
import com.homepage.likelion.posts.dto.PostListDto;
import com.homepage.likelion.posts.dto.PostUpdateDto;
import com.homepage.likelion.posts.repository.PostRepository;
import com.homepage.likelion.util.response.CustomApiResponse;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Builder
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;

    // 게시글 작성
    @Override
    public ResponseEntity<CustomApiResponse<?>> createPost(PostCreateDto.Req req) {

        // 방법 1 : toEntity
        Post post = req.toEntity();

        // 방법 2 : builder


        Post savedPost = postRepository.save(post);

        // 게시글 정보를 포함한 응답
        PostCreateDto.CreatePost createdPostResponse = new PostCreateDto.CreatePost(savedPost.getId(), savedPost.getCreatedAt());
        CustomApiResponse<PostCreateDto.CreatePost> res = CustomApiResponse.createSuccess(HttpStatus.OK.value(), createdPostResponse, "게시글이 작성되었습니다.");
        return ResponseEntity.ok(res);

    }

    @Override
    public ResponseEntity<CustomApiResponse<?>> modifyPost(Long postId, PostUpdateDto.Req req) {
        // 게시물 검색
        Optional<Post> optionalPost = postRepository.findById(postId);

        // 게시글 업데이트
        Post post = optionalPost.get();
        post.changeTitle(req.getTitle());
        post.changeContent(req.getContent());
        post.changeUserName(req.getPostedUserName());
        postRepository.flush();

        // 수정한 게시글 정보 응답
        PostUpdateDto.UpdatePost data = new PostUpdateDto.UpdatePost(post.getUpdateAt());
        CustomApiResponse<PostUpdateDto.UpdatePost> res = CustomApiResponse.createSuccess(HttpStatus.OK.value(), data, "게시글이 수정되었습니다.");
        return ResponseEntity.ok(res);
    }

    // 게시글 한 개 조회
    @Override
    public ResponseEntity<CustomApiResponse<?>> getOnePost(Long postId) {

        // 게시글 찾기
        Optional<Post> optionalPost = postRepository.findById(postId);

        if (optionalPost.isEmpty()) {
            CustomApiResponse<Void> res = CustomApiResponse.createFailWithout(HttpStatus.NOT_FOUND.value(), "해당하는 게시글을 찾을 수 없습니다");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
        }

        Post post = optionalPost.get();
        PostListDto.PostResponse postResponse = new PostListDto.PostResponse(
                post.getId(), post.getPostedUserName(), post.getTitle(), post.getContent(), post.getUpdateAt());

        // 게시글 한 개 응답
        CustomApiResponse<PostListDto.PostResponse> res = CustomApiResponse.createSuccess(HttpStatus.OK.value(), postResponse, "게시글 1개 조회를 성공했습니다.");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
    }
}
