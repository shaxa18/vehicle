package com.project.vehicle.parameters.repositories;

import com.project.vehicle.parameters.models.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CrudRepository<Location,Integer> {
}
