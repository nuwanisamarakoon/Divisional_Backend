package com.twd.SabahaBackend.mapped;

import com.twd.SabahaBackend.dto.PostDto;
import com.twd.SabahaBackend.entity.Post;

public class PostMapped {
    public static PostDto mapToPostDto(Post post){
      return new PostDto(
              post.getId(),
              post.getDirection(),
              post.getUrl()
      );
    }

public static Post mapToPost(PostDto postDto){
    return new Post(
            postDto.getId(),
            postDto.getDirection(),
            postDto.getUrl()
    );
  }
}