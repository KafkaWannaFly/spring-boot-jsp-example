package com.kms.mvcjsp.repositories;

import com.kms.mvcjsp.models.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class _Seeder {
    private final Logger logger = LoggerFactory.getLogger(_Seeder.class);

    private final BookRepository bookRepository;

    @Autowired
    public _Seeder(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @EventListener
    public void seed() {
        this.seedBooksTable();
    }

    private void seedBooksTable() {
        logger.info("Seeding Books table");

        var books = bookRepository.findAll();
        if (books.size() <= 0) {
            var insertedBooks = List.of(
                    new Book("Kafka on the shore", "Haruki Murakami"),
                    new Book("Parallel worlds", "Michio Kaku"),
                    new Book("Gun, Gem and Steel", "Diamond Jared"),
                    new Book("Homo Sapiens", "Yuval Noah Harari"),
                    new Book("Red luck", "Vu Trong Phung")
            );

            var results = bookRepository.saveAll(insertedBooks);
            logger.info("Saved " + results);
        } else {
            logger.info("No need to seed");
        }
    }
}
