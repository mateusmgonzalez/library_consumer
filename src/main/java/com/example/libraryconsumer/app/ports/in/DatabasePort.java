package com.example.libraryconsumer.app.ports.in;

import com.example.libraryconsumer.app.domain.Library;

public interface DatabasePort {



     void save(Library library);
}
