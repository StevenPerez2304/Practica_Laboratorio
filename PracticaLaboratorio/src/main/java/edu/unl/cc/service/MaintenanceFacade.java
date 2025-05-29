package edu.unl.cc.service;

import java.io.Serializable;
import java.time.LocalDate;

public class MaintenanceFacade implements Serializable {

    private LocalDate lastMaintenance;
    private LocalDate today; 

    private String needsMaintenance(int year, int month, int dayOfMonth) {
        lastMaintenance = LocalDate.of(year, month, dayOfMonth);
        today = LocalDate.now(); 

        if (lastMaintenance.isBefore(today)){ //arreglar a 6 meses / 1 anio 
            
        }
        return "";
    }

    private void updateDate() {

    }
}
