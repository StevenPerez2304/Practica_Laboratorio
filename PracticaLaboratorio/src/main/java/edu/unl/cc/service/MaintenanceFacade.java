package edu.unl.cc.service;

import java.io.Serializable;
import java.time.LocalDate;

public class MaintenanceFacade implements Serializable {

    private LocalDate lastMaintenance;

    private boolean needsMaintenance(int year, int month, int dayOfMonth) {
        lastMaintenance = LocalDate.of(year, month, dayOfMonth);
        LocalDate today = LocalDate.now();

        LocalDate sixMonthsAgo = today.minusMonths(6);
        LocalDate oneYearAgo = today.minusYears(1);

        return lastMaintenance.isBefore(sixMonthsAgo) || lastMaintenance.isBefore(oneYearAgo);
    }

    private void updateDate() {
        lastMaintenance = LocalDate.now(); 
    }
}
