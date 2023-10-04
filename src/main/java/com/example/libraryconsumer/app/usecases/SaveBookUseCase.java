package com.example.libraryconsumer.app.usecases;

import com.example.libraryconsumer.app.domain.Library;
import com.example.libraryconsumer.app.ports.SaveBookPort;
import com.example.libraryconsumer.app.ports.in.DatabasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class SaveBookUseCase implements SaveBookPort {


    private final DatabasePort databasePort;

    @Override
    public void save(Library library) {

        databasePort.save(library);
    }
}
