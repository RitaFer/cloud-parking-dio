package br.com.rita.cloudparking.repositories;

import br.com.rita.cloudparking.models.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Long> {

   Optional<Parking> findByLicense(String license);
}
