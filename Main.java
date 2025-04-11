import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.IOException;

/**
 * Clase principal para la simulación de atención de emergencia
 * que permite seleccionar entre dos implementaciones de cola de prioridad
 * (VectorHeap y JCF) y simular la llegada y atención de pacientes.
 */

public class Main {
    
    public static void main(String[] args) {


        ArrayList<Patient> patients = reader("Pacientes.txt");
        IPriorityQueue<Patient> queue = null;
        
        Scanner scanner = new Scanner(System.in);

        // Menú de selección de implementación
        while (queue == null) {
            System.out.println("\n====== Implementación de Cola de Prioridad ====== ");
            System.out.println("1. VectorHeap");
            System.out.println("2. JCF");
            System.out.println("3. Salir");
            int PQOption = scanner.nextInt();

            switch (PQOption) {
                case 1:
                    queue = Factory.createPQ("VectorHeap");
                    break;
                case 2:
                    queue = Factory.createPQ("JCF");
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    scanner.close();
    
                    return; // Sale del programa
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }

        // Cargar pacientes desde archivo si existe
            if (patients != null) {
            for (Patient patient : patients) {
                queue.add(patient);
            }
        }

        // Menú principal de simulación
        int option = 0;
        while (option != 4) {
            System.out.println("\n ========= Simulación de Atención de Emergencia =========");
            System.out.println("1. Llega un nuevo paciente");
            System.out.println("2. Se atiende al paciente de mayor prioridad");
            System.out.println("3. Ver pacientes en la cola");
            System.out.println("4. Salir");
            option = scanner.nextInt();

            scanner.nextLine(); 

            switch (option) {
                case 1:
                    System.out.print("Nombre del paciente: ");
                    String name = scanner.nextLine();
                    System.out.print("Descripción del paciente: ");
                    String description = scanner.nextLine();
                    System.out.print("Prioridad del paciente: ");
                    String priority = scanner.nextLine();
                    queue.add(new Patient(name, description, priority));
                    break;
                case 2:
                    Patient removed = queue.remove();
                    if (removed != null) {
                        System.out.println("Paciente atendido: " + removed);
                    } else {
                        System.out.println("No hay pacientes en la cola.");
                    }
                    break;
                case 3:
                    System.out.println("\nTamaño de la cola: " + queue.size());
                    System.out.println("Pacientes en la cola:");
                    queue.displayElements();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }

        scanner.close();

    }

    /**
     * Lee un archivo de texto y devuelve una lista de pacientes.
     * @param fileName el nombre del archivo
     * @return una lista de pacientes
     */

    public static ArrayList<Patient> reader(String fileName) {
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            ArrayList<Patient> patients = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                String description = parts[1];
                String priority = parts[2];
                patients.add(new Patient(name, description, priority));
            }
            return patients;
        } catch (IOException e) {
            System.out.println("Error al leer el documento: " + e.getMessage());
            return null;
        }






    }
}
