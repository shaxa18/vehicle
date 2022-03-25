package com.napa.vehicle.parameters.repositories;

import com.napa.vehicle.parameters.models.Country;
import com.napa.vehicle.parameters.models.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State,Integer> {

}
