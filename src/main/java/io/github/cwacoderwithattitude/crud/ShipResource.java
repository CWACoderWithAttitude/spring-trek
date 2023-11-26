package io.github.cwacoderwithattitude.crud;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ShipResource {

   @Autowired
   private ShipRepository shipRepository;

   @GetMapping("/ships")
   public List<Ship> retrieveAllShips() {
      return shipRepository.findAll();
   }

   @GetMapping("/ships/{id}")
   public Ship retrieveShip(@PathVariable long id) {
      Ship ship = shipRepository.findById(id);

      return ship;
   }

   @PostMapping("/ships")
   public ResponseEntity<Object> createShip(@RequestBody Ship Ship) {
      Ship savedShip = shipRepository.save(Ship);

      URI location = buildLocation(savedShip);

      return ResponseEntity.created(location).build();
   }

   private URI buildLocation(Ship savedShip) {
      URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(savedShip.getId())
            .toUri();
      return location;
   }

   @DeleteMapping("/ships/{id}")
   public void deleteShip(@PathVariable long id) {
      shipRepository.deleteById(id);
   }
}
