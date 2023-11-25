package io.github.cwacoderwithattitude.crud;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ShipRepository extends CrudRepository<Ship, Long> {

   List<Ship> findAll();

   List<Ship> findByName(String name);

   Ship findById(long id);
}
