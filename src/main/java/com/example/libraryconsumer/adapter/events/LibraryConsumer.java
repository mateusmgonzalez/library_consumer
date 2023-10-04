package com.example.libraryconsumer.adapter.events;


import com.example.libraryconsumer.app.domain.Book;
import com.example.libraryconsumer.app.domain.Library;
import com.example.libraryconsumer.app.ports.SaveBookPort;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.generic.GenericData;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class LibraryConsumer {

    private final SaveBookPort useCase;

    @KafkaListener(topics = "${spring.kafka.topics}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(GenericData.Record record) {

        try{

            Gson gson = new Gson();


            LibraryEventTransport libraryEventTransport = gson.fromJson(record.toString(), LibraryEventTransport.class);

            log.info("{}",  libraryEventTransport.toString());

            Book book = new Book();
            book.setBookId(libraryEventTransport.getBook().getBookId());
            book.setBookName(libraryEventTransport.getBook().getBookName());
            book.setBookAuthor(libraryEventTransport.getBook().getBookAuthor());
            Library library = new Library();
            library.setLibraryId(libraryEventTransport.getLibraryEventId());
            library.setLibraryType(libraryEventTransport.getLibraryType());
            library.setBook(book);

            useCase.save(library);
        } catch (Exception e) {

            log.error(e.getMessage());
        }

    }
}
