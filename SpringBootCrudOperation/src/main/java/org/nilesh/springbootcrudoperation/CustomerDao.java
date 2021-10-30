package org.nilesh.springbootcrudoperation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository //makes it as repository
public interface CustomerDao extends JpaRepository<Customers, Long>{ // Implementing JpaRepository
	public Customers findByFirstName(String firstName);//finder api generates Query
}
