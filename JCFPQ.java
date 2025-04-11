import java.util.PriorityQueue;
/**
 * Una implementación de una cola de prioridad usando la clase PriorityQueue de Java
 */
public class JCFPQ<E> implements IPriorityQueue<E> {
    
    private PriorityQueue<E> queue; // La cola de prioridad

    /**
     * Contructor de la clase JCFPQ
     */
    public JCFPQ() {
        queue = new PriorityQueue<>();
    }

    /**
     * Añado un elemento a la cola de prioridad
     * @param patient el elemento a añadir
     */
    public boolean add(E e) {
        return queue.add(e); 
    }
    /**
     * Remueve y retorna el elemento de mayor prioridad
     * @return el elemento de mayor prioridad
     */
    public E remove() {
        return (E) queue.poll(); 
    }

    /**
     * EL tamaño de la cola de prioridad
     * @return el tamaño de la cola
     */
    public int size() {
        return queue.size();
    }

    /**
     * Muestra los elementos en la cola de prioridad
     */

    public void displayElements() {
        PriorityQueue<E> tempQueue = new PriorityQueue<>(queue);
        while (!tempQueue.isEmpty()) {
        System.out.println(tempQueue.remove());
        }
    }  
}
