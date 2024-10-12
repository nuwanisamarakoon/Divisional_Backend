package com.twd.SabahaBackend.service.impl;

import lombok.AllArgsConstructor;
import com.twd.SabahaBackend.dto.PostDto;
import com.twd.SabahaBackend.entity.Post;
import com.twd.SabahaBackend.exception.ResourceNotFoundException;
import com.twd.SabahaBackend.mapped.PostMapped;
import com.twd.SabahaBackend.repository.PostRepository;
import com.twd.SabahaBackend.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    @Override
    public PostDto createPost(PostDto postDto) {

        Post post = PostMapped.mapToPost(postDto);
        Post savedPost = postRepository.save(post);

        return PostMapped.mapToPostDto(savedPost);
    }

    @Override
    public PostDto getPostById(Long PostId) {
     Post post =   postRepository.findById(PostId)
        .orElseThrow(() ->
                new ResourceNotFoundException("Post is not Exists with given id:" + PostId));

        return PostMapped.mapToPostDto(post);
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map((post) -> PostMapped.mapToPostDto(post))
                .collect(Collectors.toList());
    }

    @Override
    public PostDto updatePost(Long postId, PostDto updatedPost) {

      Post posts =  postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post is not exists with given Id :" + postId)
        );
      posts.setDirection(updatedPost.getDirection());
      Post updatePostObj = postRepository.save(posts);

        return PostMapped.mapToPostDto(updatePostObj);
    }

    @Override
    public void deletePost(Long PostId) {
        Post post = postRepository.findById(PostId).orElseThrow(
                () -> new ResourceNotFoundException("Post is not exists with given id: " + PostId)
        );
        postRepository.deleteById(PostId);

    }
}
