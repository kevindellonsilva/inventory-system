package com.nibm.project4.repository;

import com.nibm.project4.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Stockrepo extends JpaRepository<Stock,Integer> {

}
