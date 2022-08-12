package br.com.rita.cloudparking.controllers;

import br.com.rita.cloudparking.dto.ParkingDtoRequest;
import br.com.rita.cloudparking.models.Parking;
import br.com.rita.cloudparking.services.ParkingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/parking")
@Tag(name = "Parking", description = "The Parking API")
public class ParkingController {

    private final ParkingService parkingService;

    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @Operation(summary = "Find all parkings",
            description = "Find all parkings",
            tags = "Parking")
    @GetMapping
    public ResponseEntity<List<Parking>> findAll(){
        List<Parking> all = parkingService.findAll();
        return ResponseEntity.ok().body(all);
    }

    @Operation(summary = "Find parking by id",
            description = "Find parking by id",
            tags = "Parking")
    @GetMapping("/{id}")
    public ResponseEntity<Parking> findById(@PathVariable Long id){
        Parking byId = parkingService.findById(id);
        return ResponseEntity.ok().body(byId);
    }

    @Operation(summary = "Insert parking",
            description = "Insert parking",
            tags = "Parking")
    @PostMapping()
    public ResponseEntity<Parking> save(@RequestBody @Valid ParkingDtoRequest parkingDtoRequest){
        Parking save = parkingService.save(parkingDtoRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(save.getId()).toUri();
        return ResponseEntity.created(uri).body(save);
    }

    @Operation(summary = "Update parking",
            description = "Update parking",
            tags = "Parking")
    @PutMapping("/{id}")
    public ResponseEntity<Parking> update(@PathVariable Long id, @RequestBody @Valid ParkingDtoRequest parkingDtoRequest){
        Parking update = parkingService.update(id, parkingDtoRequest);
        return ResponseEntity.ok().body(update);
    }

    @Operation(summary = "Delete parking",
            description = "Delete parking",
            tags = "Parking")
    @DeleteMapping("/{id}")
    public ResponseEntity<Parking> delete(@PathVariable Long id){
        parkingService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Checkout parking",
            description = "Checkout parking",
            tags = "Parking")
    @PutMapping("/checkout/{id}")
    public ResponseEntity<Parking> checkout(@PathVariable Long id){
        Parking parking = parkingService.checkOut(id);
        return ResponseEntity.ok().body(parking);
    }

}
