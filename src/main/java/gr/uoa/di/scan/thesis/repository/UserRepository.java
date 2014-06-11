package gr.uoa.di.scan.thesis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gr.uoa.di.scan.thesis.entity.User;


public interface UserRepository extends JpaRepository<User, Long>{

}
