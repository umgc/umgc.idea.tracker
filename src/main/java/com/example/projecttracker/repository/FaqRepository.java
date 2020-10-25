package com.example.projecttracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projecttracker.model.Faq;

@Repository
public interface FaqRepository extends JpaRepository<Faq, Long> {

}
