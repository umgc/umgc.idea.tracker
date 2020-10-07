package edu.umgc.CaPPMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.umgc.CaPPMS.model.FAQ;

@Repository
public interface FAQRepository extends JpaRepository<FAQ, Long>
{

}
