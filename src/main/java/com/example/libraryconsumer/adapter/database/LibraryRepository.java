package com.example.libraryconsumer.adapter.database;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Long, LibraryEntity> {

}
