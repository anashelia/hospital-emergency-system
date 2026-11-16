/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package largeassignment;

import java.io.*;
import java.util.*;
/**
 *
 * @author anash
 */
public class LargeAssignment {

    public static void main(String[] args) {

        List<Hospital> hospitals = loadHospitals("hospitals.txt");
        List<Ambulance> ambulances = loadAmbulances("ambulances.txt");
        List<Patient> patients = loadPatients("patients.txt");

        loadDoctors("doctors.txt", hospitals);

        EmergencyAlertSystem system = new EmergencyAlertSystem();

        for (Hospital h : hospitals) {
            system.registerHospital(h);
        }
        for (Ambulance a : ambulances) {
            system.registerAmbulance(a);
        }

        for (Patient p : patients) {
            system.dispatch(p);
        }

        for (Hospital h : hospitals) {
            h.startTreatment(new StandardTreatment());
        }

        for (Hospital h : hospitals) {
            h.startTreatment(new EmergencyTreatment());
        }
    }

    static List<Hospital> loadHospitals(String file) {
        List<Hospital> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                String[] p = line.split("\\s+");

                if (p.length < 2) {
                    System.out.println("Bad line: " + line);
                    continue;
                }

                list.add(new Hospital(p[0], Integer.parseInt(p[1])));
            }

        } catch (IOException e) {
            System.out.println("Error reading hospitals file");
        }

        return list;
    }

    static List<Ambulance> loadAmbulances(String file) {
        List<Ambulance> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    list.add(new Ambulance(line));
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading ambulances file");
        }

        return list;
    }

    static List<Patient> loadPatients(String file) {
        List<Patient> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = br.readLine()) != null) {

                line = line.trim();
                if (line.isEmpty()) continue;

                String[] p = line.split("\\s+");

                if (p.length < 2) {
                    System.out.println("Bad line: " + line);
                    continue;
                }

                list.add(new Patient(p[0], Integer.parseInt(p[1])));
            }

        } catch (IOException e) {
            System.out.println("Error reading patients file");
        }

        return list;
    }

    static void loadDoctors(String file, List<Hospital> hospitals) {

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = br.readLine()) != null) {

                line = line.trim();
                if (line.isEmpty()) continue;

                String[] p = line.split("\\s+");

                if (p.length < 3) {
                    System.out.println("Bad line: " + line);
                    continue;
                }

                Doctor d = new Doctor(p[0], Integer.parseInt(p[1]));

                boolean found = false;

                for (Hospital h : hospitals) {
                    if (h.getName().equals(p[2])) {
                        h.registerDoctor(d);
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("No hospital: " + line);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading doctors file");
        }
    }
}