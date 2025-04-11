/** 
 * Interfaz para una cola de prioridad
 */
public interface IPriorityQueue<E> {

    /**
     * Añade un elemento a la cola de prioridad
     * @param e el elemento a añadir
     */
    boolean add(E e);

    /**
     * Remueve y retorna el elemento de mayor prioridad
     * @return 
     */
    E remove();

    /**
     * El tamaño de la cola de prioridad
     * @return 
     */
    int size();

    /**
     * Muestra los elementos en la cola de prioridad
     */
    void displayElements();
    
}
