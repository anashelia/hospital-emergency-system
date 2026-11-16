/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package largeassignment;

/**
 *
 * @author anash
 */
public class EmergencyTreatment implements TreatmentStrategy {

    @Override
    public void treat(Patient p, Doctor d) {

        double boost = (p.getSeverity() / 10.0) + 1;

        int amount = (int)(d.getEfficiency() * boost);

        p.reduceSeverity(amount);
    }
}