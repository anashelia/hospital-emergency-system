/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package largeassignment;

/**
 *
 * @author anash
 */
public class IntensiveTreatment implements TreatmentStrategy {

    @Override
    public void treat(Patient p, Doctor d) {

        int eff = d.getEfficiency();

        if (p.getSeverity() > 5) {
            eff *= 1.5;
        }

        p.reduceSeverity(eff);
    }
}
