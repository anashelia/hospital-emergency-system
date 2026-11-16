
HOSPITAL EMERGENCY SYSTEM
=========================

A Java-based simulation of a city's emergency medical response system. 
When emergencies occur, this system coordinates patients, ambulances, 
hospitals, and doctors to ensure patients receive the care they need.


OVERVIEW
--------

This project models an object-oriented solution to an emergency dispatch 
and hospital management scenario. It demonstrates the use of several 
software design patterns and principles, including the State pattern 
(for patient lifecycles) and the Strategy pattern (for hospital 
treatment protocols).

The system reads initial data (hospitals, ambulances, doctors, and 
patients) from text files, runs a simulated dispatch sequence, and 
applies various treatment strategies to heal the patients.


FEATURES
--------

  * Automated Dispatch: Finds available hospitals and ambulances to 
    transport patients.
  * Patient Lifecycle: Tracks patients through states (Waiting, 
    Transit, Admitted, Under Treatment, Recovered).
  * Treatment Strategies:
      - Standard: Applies the doctor's efficiency directly.
      - Intensive: Applies a 1.5x multiplier for patients with severe 
        conditions (severity > 5).
      - Emergency: Boosts efficiency for critical cases using an 
        urgency formula.
  * Data Loading: Reads setup data from external .txt files.


CLASSES & ARCHITECTURE
----------------------

  * EmergencyAlertSystem: The central manager. Registers hospitals 
    and ambulances, finds available resources, and dispatches 
    ambulances to patients.
  * Hospital: Holds patients and doctors. Admits patients (if 
    capacity allows) and coordinates doctors to treat them.
  * Patient: Represents an individual needing care. Holds their name, 
    severity level (1-10), and current state.
  * Doctor: Treats patients based on their assigned efficiency level.
  * Ambulance: Transports patients to the destination hospital.
  * TreatmentStrategy (Interface): The foundation for the Strategy 
    pattern. Implemented by StandardTreatment, IntensiveTreatment, and 
    EmergencyTreatment.
  * PatientState (Enum): Defines the lifecycle states of a patient.


FILES
-----

  Source Code (src/largeassignment/):
    - LargeAssignment.java     : Main entry point and file loaders.
    - EmergencyAlertSystem.java: Dispatch and resource management.
    - Hospital.java            : Patient/doctor management and capacity.
    - Patient.java             : Patient data and state transitions.
    - Doctor.java              : Doctor data and treatment execution.
    - Ambulance.java           : Transport logic.
    - PatientState.java        : Enum for patient lifecycle.
    - TreatmentStrategy.java   : Interface for treatment logic.
    - StandardTreatment.java   : Direct efficiency reduction.
    - IntensiveTreatment.java  : Multiplier for severe patients.
    - EmergencyTreatment.java  : Urgency-based efficiency boost.

  Data Files (root directory):
    - hospitals.txt            : Hospital names and capacities.
    - ambulances.txt           : Ambulance IDs.
    - doctors.txt              : Doctor names, efficiency, and hospital.
    - patients.txt             : Patient names and initial severity.

  Project Files:
    - build.xml                : NetBeans build configuration.


BUILDING AND RUNNING
--------------------

This project was created using Apache NetBeans.

1. Open NetBeans.
2. Go to File -> Open Project and select the project folder.
3. Ensure the data files (hospitals.txt, etc.) are in the root directory 
   of the project.
4. Press F6 (or click the Run Project button) to execute LargeAssignment.java.


DATA FILE FORMATS
-----------------

  hospitals.txt:
    <Hospital_Name> <Capacity>
    Example: General_Hospital 3

  ambulances.txt:
    <Ambulance_ID>
    Example: A1

  doctors.txt:
    <Doctor_Name> <Efficiency> <Hospital_Name>
    Example: Dr_Smith 5 General_Hospital

  patients.txt:
    <Patient_Name> <Severity>
    Example: John 7


LICENSE
-------

This program is provided as-is for educational and demonstration
purposes. Use and modify it freely.
