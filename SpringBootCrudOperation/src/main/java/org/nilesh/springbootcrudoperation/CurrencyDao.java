package org.nilesh.springbootcrudoperation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository //makes it as repository
public interface CurrencyDao extends JpaRepository<Currencies, Long>{ // Implementing JpaRepository

}
