package com.nit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PAN_DetailsRepo extends JpaRepository<PAN_Details, Integer> {

}
