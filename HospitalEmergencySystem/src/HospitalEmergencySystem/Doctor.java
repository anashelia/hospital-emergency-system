/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package largeassignment;

/**
 *
 * @author anash
 */
public class Doctor {

    private String name;
    private int efficiency;

    public Doctor(String name, int efficiency) {
        this.name = name;
        this.efficiency = efficiency;
    }

    public void treat(Patient p, TreatmentStrategy strategy) {
        strategy.treat(p, this);
    }

    public int getEfficiency() {
        return efficiency;
    }
}