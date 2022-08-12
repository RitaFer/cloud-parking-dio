package br.com.rita.cloudparking.services.interfaces;

import br.com.rita.cloudparking.dto.ParkingDtoRequest;
import br.com.rita.cloudparking.models.Parking;

import java.util.List;

public interface IParkingService {
    /**
     * Retorna todos os parkings
     * @return - Lista de parkings
     */
    List<Parking> findAll();

    /**
     * Retorna parking por id
     * @param id - id do parking
     * @return - parking com id enviado
     */
    Parking findById(Long id);

    /**
     * Salva parking no database
     * @param parkingDtoRequest - Dto com os dados para cadastro
     * @return - objeto parking criado
     */
    Parking save(ParkingDtoRequest parkingDtoRequest);

    /**
     * Atualiza parking por id
     * @param id - id do parking para atualizar
     * @param parkingDtoRequest - Dto com os dados para update
     * @return - objeto parking atualizado
     */
    Parking update(Long id, ParkingDtoRequest parkingDtoRequest);

    /**
     * Deleta parking por id
     * @param id - id do parking para deletar
     */
    void delete(Long id);

    /**
     * Insere o horário de saída e o valor a pagar
     * @param id - id do parking
     * @return - parking com horário de saída
     */
    Parking checkOut(Long id);
}
