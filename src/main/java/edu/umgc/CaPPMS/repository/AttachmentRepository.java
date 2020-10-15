package edu.umgc.CaPPMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.umgc.CaPPMS.model.Attachment;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Long>{

}