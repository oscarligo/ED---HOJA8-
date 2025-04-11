import java.util.PriorityQueue;


/**
 * Factory class to create different types of priority queues
 */
public class Factory {

    /**
     * Creates a priority queue based on the specified type
     * @param type the type of priority queue to create
     * @return the created priority queue
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

    
