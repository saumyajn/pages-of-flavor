package com.pagesofflavor.repositories;

import com.pagesofflavor.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
}
