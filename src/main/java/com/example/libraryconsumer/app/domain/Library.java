package com.example.libraryconsumer.app.domain;


import lombok.Data;

@Data
public class Library{

    Integer libraryId;
    String libraryType;
    Book book;
}
