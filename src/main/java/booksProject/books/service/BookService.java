package booksProject.books.service;

import booksProject.books.dto.BookDto;
import booksProject.books.dto.BookForm;

import java.util.List;

public interface BookService {

    List<BookDto> findAll();
    List<BookDto> findAllByAuthor(String author);

    BookDto findByUuid(String uuid);

    BookDto create(BookForm form);

    void delete(String uuid);

    BookDto update(String uuid, BookForm form);
}