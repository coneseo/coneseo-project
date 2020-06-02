package com.coneseo.www.service.posts;

import com.coneseo.www.domain.posts.Posts;
import com.coneseo.www.domain.posts.PostsRepsitory;
import com.coneseo.www.web.dto.PostsResponseDto;
import com.coneseo.www.web.dto.PostsSaveRequestDto;
import com.coneseo.www.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepsitory postsRepsitory;

    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepsitory.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepsitory.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepsitory.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        return new PostsResponseDto(entity);
    }
}
