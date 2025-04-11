import java.util.Vector;

/** 
 * Un vector heap que implementaa una cola de prioridad.
 * @author https://runestone.academy/ns/books/published/cppds/Trees/BinaryHeapImplementation.html
 * Se hicieron modificaciones para el uso de genericos.
 * y se implementaron los metodos de la interfaz IPriorityQueue
 */
public class VectorHeapPQ <E extends Comparable<E>> implements IPriorityQueue<E> {
    
    private Vector<E> heap; // El vector que representa el heap

    /**
     * Constructor de un VectorHeapPQ
     */

    public VectorHeapPQ() {
        heap = new Vector<>();
    }

    /**
     * El indice del padre de un nodo en el heap
     * @param i el indice del nodo
     * @return el indice del padre
     */
    private int parent(int i) {
        return (i - 1) / 2;
    }

    /**
     * EL indice del hijo izquierdo de un nodo en el heap
     * @param i el indice del nodo
     * @return el indice del hijo izquierdo
     */
    
    private int leftChild(int i) {
        return 2 * i + 1;
    }

    /**
     * El indice del hijo derecho de un nodo en el heap 
     * @param i el indice del nodo
     * @return el indice del hijo derecho
     */
    private int rightChild(int i) {
        return 2 * i + 2;
    }

    /**
     * INtercambia dos nodos en el heap
     * @param i el indice del primer nodo
     * @param j el indice del segundo nodo
     */
    
    private void swap(int i, int j) {
        E temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    /**
     * Organiza el elemento hacia arriba
     * @param i el indice del nodo
     */

    private void percUp(int i) {
        while (i > 0 && heap.get(i).compareTo(heap.get(parent(i))) < 0) {
            swap(i, parent(i));
            i = parent(i);
        }
    }


    /**
     * Organiza el elemento hacia abajo
     * @param i el indice del nodo
     */
    
    private void percDown(int i) {
        int smallest = i;
        int left = leftChild(i);
        int right = rightChild(i);
    
        if (left < heap.size() && heap.get(left).compareTo(heap.get(smallest)) < 0) {
            smallest = left;
        }
    
        if (right < heap.size() && heap.get(right).compareTo(heap.get(smallest)) < 0) {
            smallest = right;
        }
    
        if (smallest != i) {
            swap(i, smallest);
            percDown(smallest);
        }
    }

    /**
     * Agrega un elemento  al heap
     * @param value el elemento a agregar
     * @return true si se agrega bien
     */
    
    public boolean add(E value) {
        heap.add(value);
        percUp(heap.size() - 1);
        return true;
    }

    /**
     * Devuelve el elemento en la cima del heap
     * @return el elemento en la cima
     */
    
    public E remove() {
        if (heap.isEmpty()) return null;
        E min = heap.get(0);
        E last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            percDown(0);
        }
        return min;
    }

    /**
     * Devuelve el tamaño del heap
     * @return el tamaño del heap
     */
    public int size() {
        return heap.size();

    }

    /**
     * Muestra los elementos en el heap. Se crea un vector temporal parair el 
     */

    public void displayElements() {
        // Crear una copia del heap original
        VectorHeapPQ<E> tempHeap = new VectorHeapPQ<>();
        
        // Copiar los elementos manualmente para respetar la estructura de heap
        for (E element : heap) {
            tempHeap.add(element);
        }
    
        // Mostrar los elementos en orden de prioridad
        while (tempHeap.size() > 0) {
            System.out.println(tempHeap.remove());
        }
    }

}