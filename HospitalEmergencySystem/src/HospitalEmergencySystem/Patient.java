/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package largeassignment;

/**
 *
 * @author anash
 */
public class Patient {

    private String name;
    private int severity;
    private boolean recovered;
    private PatientState state;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
        this.recovered = false;
        this.state = PatientState.WAITING;
    }
    
    public int getSeverity() {
        return severity;
    }
    
    public void setState(PatientState state) {
        this.state = state;
    }

    
    public void reduceSeverity(int amount) {
        severity -= amount;

        if (severity <= 0) {
            severity = 0;
            recovered = true;
            state = PatientState.RECOVERED;
        }
    }
    
    public boolean isRecovered() {
        return recovered;
    }

    public void markRecovered() {
        recovered = true;
        state = PatientState.RECOVERED;
    }
    
    @Override
    public String toString() {
        return name + " severity = " + severity;
    }
}