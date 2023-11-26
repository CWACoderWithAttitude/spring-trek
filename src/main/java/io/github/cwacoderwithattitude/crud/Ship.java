package io.github.cwacoderwithattitude.crud;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ship {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   private String name;
   private String sign;
   private String type;

   public Ship(String name, String type) {
      this.type = type;
      this.sign = "n/n";
      this.name = name;
   }

   public Ship(String name, String sign, String type) {
      this.type = type;
      this.sign = sign;
      this.name = name;
   }

   @Override
   public String toString() {
      return String.format("Ship[id=%d, name=%s, sign=%s, type=%s]", id, name, sign, type);
   }
}
