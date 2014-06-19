package gr.uoa.di.scan.thesis.repository;

import gr.uoa.di.scan.thesis.entity.Post;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long>{

}
