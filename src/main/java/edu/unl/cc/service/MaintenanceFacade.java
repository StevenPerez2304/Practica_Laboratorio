/**
 * Link del repositorio: https://github.com/StevenPerez2304/Practica_Laboratorio.git
 * Integrantes:
 * Coello Anderson
 * Flores Emilio
 * Jumbo Steven
 * Perez Steven*/
package edu.unl.cc.service;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class MaintenanceFacade implements Serializable {

    private LocalDate lastMaintenance;

    public MaintenanceFacade(LocalDate lastMaintenance) {
        this.lastMaintenance = lastMaintenance;
    }

    public LocalDate getLastMaintenance() {
        return lastMaintenance;
    }

    public boolean needsMaintenance() {
        LocalDate today = LocalDate.now();
        LocalDate sixMonthsAgo = today.minusMonths(6);
        return lastMaintenance.isBefore(sixMonthsAgo);
    }

    public void updateMaintenanceDate() {
        lastMaintenance = LocalDate.now();
    }

    /**
     * 
     * @param dateStr
     * @throws IllegalArgumentException 
     */
    public void setLastMaintenance(String dateStr) throws IllegalArgumentException {
        try {
            LocalDate date = LocalDate.parse(dateStr); 
            this.lastMaintenance = date;
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato no valido, Debe ser YYYY-MM-DD.");
        }
    }
}