package com.example.libraryconsumer.app.ports;

import com.example.libraryconsumer.app.domain.Library;

public interface SaveBookPort {
    void save(Library library);
}
