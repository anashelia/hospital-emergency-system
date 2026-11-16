/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package largeassignment;

/**
 *
 * @author anash
 */
public class Ambulance {

    private String id;
    private boolean available = true;
    private Hospital destination;

    public Ambulance(String id) {
        this.id = id;
    }

    public boolean isAvailable() {
        return available;
    }

    public void transport(Patient p, Hospital h) {

        destination = h;
        available = false;

        System.out.println("Ambulance " + id + " transporting " + p);

        p.setState(PatientState.TRANSIT);

        if (h.admitPatient(p)) {
            System.out.println("Patient delivered successfully.");
        } else {
            System.out.println("hospital full! please wait");
            p.setState(PatientState.WAITING);
        }

        available = true;
        destination = null;
    }
}
