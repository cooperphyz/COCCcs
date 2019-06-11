

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CDLinkedListTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CDLinkedListTest
{
    private CDLinkedList cDLinked1;
    private Person John;
    private Person Garfield;
    private Person Boris;

    /**
     * Default constructor for test class CDLinkedListTest
     */
    public CDLinkedListTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        cDLinked1 = new CDLinkedList();
        John = new Person("John", "Jones", "195183612");
        Garfield = new Person("Garfield", "Doe", "862831679");
        Boris = new Person("Boris", "Jaris", "968714125");
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
        cDLinked1.clear();
    }

    @Test
    public void TestAddFirst()
    {
        cDLinked1.addFirst(Boris);
        cDLinked1.addFirst(John);
        cDLinked1.addFirst(Garfield);
        cDLinked1.print();
    }

    @Test
    public void TestAddLast()
    {
        cDLinked1.addLast(Boris);
        cDLinked1.addLast(John);
        cDLinked1.addLast(Garfield);
        cDLinked1.print();
    }

    @Test
    public void TestFirstAndLastTogether()
    {
        cDLinked1.addFirst(Boris);
        cDLinked1.addLast(John);
        cDLinked1.addLast(Garfield);
        cDLinked1.print();
    }

    @Test
    public void TestAdd()
    {
        cDLinked1.add(1, Boris);
        cDLinked1.add(2, John);
        cDLinked1.add(2, Garfield);
        cDLinked1.print();
    }

    @Test
    public void TestAddFirstAddLastAdd()
    {
        cDLinked1.addFirst(Boris);
        cDLinked1.addLast(John);
        cDLinked1.add(2, Garfield);
        cDLinked1.print();
    }

    @Test
    public void TestGetFirst()
    {
        cDLinked1.addFirst(Boris);
        assertNotNull(cDLinked1.getFirst());
    }

    @Test
    public void TestGetLast()
    {
        cDLinked1.addFirst(Boris);
        cDLinked1.addLast(John);
        assertNotNull(cDLinked1.getLast());
    }

    @Test
    public void TestRemoveFirst()
    {
        cDLinked1.addFirst(Boris);
        cDLinked1.removeFirst();
        cDLinked1.print();
        cDLinked1.addFirst(Boris);
        cDLinked1.addFirst(John);
        cDLinked1.removeFirst();
        cDLinked1.print();
    }

    @Test
    public void TestRemoveLast()
    {
        cDLinked1.addLast(Boris);
        cDLinked1.removeLast();
        cDLinked1.addFirst(John);
        cDLinked1.addLast(Garfield);
        cDLinked1.removeLast();
        cDLinked1.print();
    }


    @Test
    public void TestClear()
    {
        cDLinked1.clear();
        cDLinked1.print();
        cDLinked1.addFirst(John);
        cDLinked1.print();
        cDLinked1.clear();
        cDLinked1.print();
    }
}












