package com.tta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tta.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

	//	List<Ticket> findByTitleContaningIgnoreCaseOrDescriptionContainingIgnoreCase(String q);

	@Query(value = "SELECT * FROM tickets t WHERE CONCAT(t.title,' ', t.description) LIKE %:keyword%", nativeQuery = true)
	List<Ticket> findByKeyword(@Param("keyword") String keyword);

}
