package com.example.libraryconsumer.adapter.events;

import lombok.*;
import org.apache.avro.reflect.AvroName;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class LibraryEventTransport {

    @AvroName("libraryId")
    private Integer libraryEventId;

    @AvroName("libraryType")
    private String libraryType;

    @AvroName("book")
    private BookTransport book;
}