package com.book.service.impl;

import com.book.entity.Book;
import com.book.mapper.BookMapper;
import com.book.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    BookMapper mapper;

    @Override
    public List<Book> getAllBook() {
        return mapper.allBookGet();
    }
}
