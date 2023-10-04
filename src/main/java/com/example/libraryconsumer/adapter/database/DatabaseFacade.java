package com.example.libraryconsumer.adapter.database;

import com.example.libraryconsumer.app.domain.Library;
import com.example.libraryconsumer.app.ports.in.DatabasePort;
import org.springframework.stereotype.Component;

@Component
public class DatabaseFacade implements DatabasePort {


    private LibraryRepository repository;


    @Override
    public void save(Library library) {

    }
}
