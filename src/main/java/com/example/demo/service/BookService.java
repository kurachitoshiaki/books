package com.example.demo.service;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
/**
 * 書籍情報 Service
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class BookService {
  /**
   * 書籍情報 Repository
   */
  @Autowired
  private BookRepository bookRepository;
  /**
   * 書籍一覧
   * @return 書籍一覧
   */
  public List<Book> searchAll() {
    return bookRepository.findAll();
  }
  /**
   * 書籍 主キー検索
   * @return 検索結果
   */
  public Book findById(Long id) {
    return bookRepository.findById(id).get();
  }
}