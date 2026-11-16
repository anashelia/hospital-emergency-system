/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package largeassignment;

/**
 *
 * @author anash
 */
public class StandardTreatment implements TreatmentStrategy {

    @Override
    public void treat(Patient p, Doctor d) {
        p.reduceSeverity(d.getEfficiency());
    }
}
