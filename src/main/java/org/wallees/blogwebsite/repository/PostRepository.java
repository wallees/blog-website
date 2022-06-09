package org.wallees.blogwebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.wallees.blogwebsite.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
