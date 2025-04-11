
/**
 * Clase paciente que implementa la interfaz Comparable
 * para poder comparar pacientes en una cola de prioridad.
 * Cada paciente tiene un nombre, un tiempo de llegada, una descripción y una prioridad.
 * La prioridad se utiliza para determinar el orden de atención en la cola.
 */
public class Patient implements Comparable<Patient> {
    
    public static int count = 1; // Contador de pacientes
    private int arrivalTime; // Tiempo de llegada del paciente
    private String name; // Nombre del paciente
    private String description; // Descripción de los sintomas del paciente
    private String priority; // Prioridad del paciente (A, B, C, D, E), mientras más cerca de A, mayor la prioridad

    /**
     * Contructor de la clase paciente
     * @param name 
     * @param description
     * @param priority
     */
    public Patient(String name, String description, String priority) {
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.arrivalTime = count; // Asigna el tiempo de llegada basado en el contador
        count++; // Incrementa el contador de pacientes
        
    }

    public String getName() {
        return name;
    }

    public String getPriority() {
        return priority;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Compara dos pacientes en base a su prioridad y tiempo de llegada.
     * @param patient el paciente a comparar
     * @return  un entero negativo, cero o positivo si este paciente es menor, igual o mayor que el paciente dado
     */

    @Override
    public int compareTo(Patient patient) {
        // A menor número → mayor prioridad
        int thisPriority = getPriorityValue(this.priority);
        int otherPriority = getPriorityValue(patient.priority);
    
        if (thisPriority != otherPriority) {
            return Integer.compare(thisPriority, otherPriority);
        } else {
            return Integer.compare(this.arrivalTime, patient.arrivalTime);
        }
    }

    /**
     * Convierte la prioridad de un paciente a un valor entero para la comparación.
     * @param priority la prioridad del paciente
     * @return el valor entero correspondiente a la prioridad
     */
    
    private int getPriorityValue(String priority) {
        switch (priority.trim().toUpperCase()) {
            case "A":
                return 1;
            case "B":
                return 2;
            case "C":
                return 3;
            case "D":
                return 4;               
            case "E":
                return 5;
            default:
                return 6;
        }
    }
    

    @Override
    public String toString() {
        return "\nPaciente: " + name + "\nTiempo de Llegada: " + arrivalTime + "\nPrioridad: " + priority;
    }

}