
/**
 * Factory class to create different types of priority queues
 */

public class Factory {

    /**
     * Crea una cola de prioridad basada en el tipo especificado.
     * @param type el tipo de cola de prioridad a crear (VectorHeap o JCF)
     * @return una instancia de IPriorityQueue
     */
    public static IPriorityQueue<Patient> createPQ(String type) {
        if (type.equals("VectorHeap")) {
            return new VectorHeapPQ<>();
        } else if (type.equals("JCF")) {
            return new JCFPQ<>();
        } else {
            throw new IllegalArgumentException("Invalid priority queue type: " + type);
        }
    }
}

    
