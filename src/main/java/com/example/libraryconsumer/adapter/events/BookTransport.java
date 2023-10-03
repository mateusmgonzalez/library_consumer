package com.example.libraryconsumer.adapter.events;

import lombok.*;
import org.apache.avro.reflect.AvroName;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class BookTransport {

    @AvroName("bookId")
    private Integer bookId;

    @AvroName("bookName")
    private String bookName;

    @AvroName("bookAuthor")
    private String bookAuthor;
}
