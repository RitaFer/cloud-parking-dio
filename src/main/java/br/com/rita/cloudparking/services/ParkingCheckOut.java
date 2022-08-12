package br.com.rita.cloudparking.services;

import br.com.rita.cloudparking.models.Parking;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ParkingCheckOut {

    private ParkingCheckOut() {
    }

    private static final Double PRICE_PER_HOUR = 5.0;

    /**
     * define o horário de saída
     * @param parking - parking para fazer checkout
     */
    public static void checkOut(Parking parking){
        parking.setExitDate(LocalDateTime.now());
    }

    /**
     * calcula o valor da conta a ser paga
     * @param parking - - parking para definir tarifa
     */
    public static void calculateBill(Parking parking){
        LocalDateTime entryDate = parking.getEntryDate();
        LocalDateTime exitDate = parking.getExitDate();
        long hours = entryDate.until(exitDate, ChronoUnit.HOURS);
        long minutes = entryDate.until(exitDate, ChronoUnit.MINUTES);
        long minuteModulus = minutes % 60;

        Double bill;
        if (minuteModulus > 0){
            bill = PRICE_PER_HOUR * (hours +1);
        }else {
            bill = PRICE_PER_HOUR * hours;
        }

        parking.setBill(String.valueOf(bill));
    }
}
