package com.responsywnie.thymleaf.dao;

import com.responsywnie.thymleaf.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface BookDAO extends JpaRepository<Book, Long> {

}
