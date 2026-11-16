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

public class Hospital {

    private String name;
    private int capacity;
    private List<Patient> patients = new ArrayList<>();
    private List<Doctor> doctors = new ArrayList<>();

    public Hospital(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }
    
    public String getName() {
        return name;
    }

    public boolean admitPatient(Patient p) {

        if (patients.size() >= capacity)
            return false;

        patients.add(p);
        p.setState(PatientState.ADMITTED);

        System.out.println(p + " admitted to " + this.name);
        return true;
    }

    public void registerDoctor(Doctor d) {
        doctors.add(d);
    }

    public boolean hasCapacity() {
        return patients.size() < capacity;
    }

    public void startTreatment(TreatmentStrategy strategy) {

        for (Patient p : patients) {

            if (!p.isRecovered()) {

                p.setState(PatientState.UNDER_TREATMENT);

                for (Doctor d : doctors) {
                    d.treat(p, strategy);
                }

                if (p.isRecovered()) {
                    System.out.println(p + " is recovered");
                }
            }
        }
    }
}
