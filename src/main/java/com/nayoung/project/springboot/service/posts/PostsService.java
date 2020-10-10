package com.nayoung.project.springboot.service.posts;

import com.nayoung.project.springboot.domain.posts.Posts;
import com.nayoung.project.springboot.domain.posts.PostsRepository;
import com.nayoung.project.springboot.web.dto.PostsListResponseDto;
import com.nayoung.project.springboot.web.dto.PostsResponseDto;
import com.nayoung.project.springboot.web.dto.PostsSaveRequestDto;
import com.nayoung.project.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// Autowired없이 final이 선언된 모든 필드를 인자값으로 생성하는 생성자를 대신해 줌
// 사용 이유 : 해당 클래스의 의존성 관계가 변경될 때마다 생성자 코드를 계속해서 수정해야하기 때문에
@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        // 1. 트랜잭션 안에서 디비를 가져오는 것 -> 영속성 컨텐스트 유지된 상태
        // 2. 해당 상태에서 데이터 값 변경시 트랜잭션 끝나는 시점에 해당 쿼리 변경분 반영
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id =" + id));
        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        postsRepository.delete(posts);
    }
}
