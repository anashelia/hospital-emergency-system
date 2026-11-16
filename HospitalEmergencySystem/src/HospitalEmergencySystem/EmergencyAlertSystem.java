/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package largeassignment;

import java.util.*;

/**
 *
 * @author anash
 */

public class EmergencyAlertSystem {

    private List<Hospital> hospitals = new ArrayList<>();
    private List<Ambulance> ambulances = new ArrayList<>();

    public void registerHospital(Hospital h) {
        hospitals.add(h);
    }

    public void registerAmbulance(Ambulance a) {
        ambulances.add(a);
    }

    public Hospital findAvailableHospital() {
        for (Hospital h : hospitals)
            if (h.hasCapacity()) return h;
        return null;
    }

    public Ambulance findAvailableAmbulance() {
        for (Ambulance a : ambulances)
            if (a.isAvailable()) return a;
        return null;
    }

    public void dispatch(Patient p) {
        Hospital h = findAvailableHospital();
        Ambulance a = findAvailableAmbulance();

        if (h == null || a == null) {
            System.out.println("please wait.");
            return;
        }

        a.transport(p, h);
    }
}
