import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class VHPQUnitTests {

    private VectorHeapPQ<Patient> queue;
    private Patient patient1;
    private Patient patient2;
    private Patient patient3;
    

    @Before

    public void setUp() {
        queue = new VectorHeapPQ<>();
        patient1 = new Patient("","", "A");
        patient2 = new Patient("","", "B");
        patient3 = new Patient("","", "C");
    }


    @Test
    public void shouldBeAbleToAddPatients() {
        queue.add(patient1);
        queue.add(patient2);
        queue.add(patient3);
        assertEquals(3, queue.size());
    }

    @Test
    public void shouldBeAbleToCheckSize() {
        queue.add(patient1);
        queue.add(patient2);
        queue.add(patient3);
        assertEquals(3, queue.size());
    }

    @Test
    public void shouldBeAbleToRemoveByPriority() {
        queue.add(patient1);
        queue.add(patient2);
        queue.add(patient3);
        assertEquals(patient1, queue.remove());
        assertEquals(2, queue.size());
        
    }


}
