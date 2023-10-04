package com.example.libraryconsumer.adapter.database;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class LibraryEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;





}
