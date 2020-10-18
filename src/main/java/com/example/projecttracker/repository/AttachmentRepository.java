package com.example.projecttracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projecttracker.model.Attachment;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Long>{

}