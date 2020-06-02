package com.coneseo.www.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepsitory extends JpaRepository<Posts, Long> {
}
