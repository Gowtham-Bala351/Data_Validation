package ex.valid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ex.valid.Model.User;

public interface ValidationRepos extends JpaRepository<User, Integer> {

}
