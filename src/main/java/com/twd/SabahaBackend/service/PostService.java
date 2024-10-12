package com.twd.SabahaBackend.service;

import com.twd.SabahaBackend.dto.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);

    PostDto getPostById(Long PostId);

    List<PostDto> getAllPosts();

    PostDto updatePost(Long postId,PostDto updatedPost);

    void deletePost(Long PostId);
}
