/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package largeassignment;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author anash
 */
public class LargeAssignmentTest {

    EmergencyAlertSystem system;
    Hospital hospital;
    Hospital hospital2;
    Ambulance ambulance;
    Ambulance ambulance2;
    Patient patient;
    Patient patient2;
    Doctor doctor;

    @Before
    public void setup() {
        system = new EmergencyAlertSystem();

        hospital = new Hospital("H1", 2);
        hospital2 = new Hospital("H2", 1);

        ambulance = new Ambulance("A1");
        ambulance2 = new Ambulance("A2");

        patient = new Patient("P1", 10);
        patient2 = new Patient("P2", 5);

        doctor = new Doctor("D1", 4);
    }

    @Test
    public void testRegisterHospitalAndFind() {
        system.registerHospital(hospital);
        assertEquals(hospital, system.findAvailableHospital());
    }

    @Test
    public void testRegisterAmbulanceAndFind() {
        system.registerAmbulance(ambulance);
        assertEquals(ambulance, system.findAvailableAmbulance());
    }

    @Test
    public void testDispatch() {
        system.registerHospital(hospital);
        system.registerAmbulance(ambulance);

        system.dispatch(patient);

        assertTrue(patient.getSeverity() >= 0);
    }

    @Test
    public void testAdmitPatient() {
        assertTrue(hospital.admitPatient(patient));
    }

    @Test
    public void testHospitalCapacity() {
        hospital.admitPatient(patient);
        hospital.admitPatient(patient2);

        assertFalse(hospital.hasCapacity());
    }

    @Test
    public void testRegisterDoctor() {
        hospital.registerDoctor(doctor);
        hospital.admitPatient(patient);

        hospital.startTreatment(new StandardTreatment());

        assertTrue(patient.getSeverity() >= 0);
    }

    @Test
    public void testAmbulanceTransport() {
        system.registerHospital(hospital);
        ambulance.transport(patient, hospital);

        assertTrue(ambulance.isAvailable());
    }

    @Test
    public void testDoctorTreatStandard() {
        doctor.treat(patient, new StandardTreatment());

        assertTrue(patient.getSeverity() < 10);
    }

    @Test
    public void testDoctorTreatEmergency() {
        doctor.treat(patient, new EmergencyTreatment());
        doctor.treat(patient2, new StandardTreatment());

        assertNotEquals(patient.getSeverity(), patient2.getSeverity());
    }

    @Test
    public void testDoctorTreatIntensive() {
        doctor.treat(patient, new IntensiveTreatment());

        assertTrue(patient.getSeverity() >= 0);
    }

    @Test
    public void testPatientReduceSeverityAndRecovery() {
        patient.reduceSeverity(100);

        assertTrue(patient.isRecovered());
        assertEquals(0, patient.getSeverity());
    }

    @Test
    public void testMarkRecovered() {
        patient.markRecovered();

        assertTrue(patient.isRecovered());
    }

    @Test

    public void testFindAvailableHospitalWhenFull() {
        system.registerHospital(hospital2);

        Patient p = new Patient("A", 5);
        hospital2.admitPatient(p);

        assertNull(system.findAvailableHospital());
    }

    @Test
    public void testFindAvailableAmbulanceAfterUse() {
        system.registerAmbulance(ambulance);

        ambulance.transport(patient, hospital);

        assertTrue(system.findAvailableAmbulance().isAvailable());
    }
}