package com.napa.vehicle.parameters.repositories;

import com.napa.vehicle.parameters.models.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location,Integer> {
}