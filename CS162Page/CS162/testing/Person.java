/**
 * Write a description of class Main here.
 *
 * @author me
 * @version 1
 */
public class Person
{
    protected String name;
    protected String lastname;
    protected String id;
    
    public Person(String name, String lastname, String id) {
        this.name = name;
        this.lastname = lastname;
        this.id = id;
    }
    public String toString() {
        return name + " " + lastname + " " + id;
    }
}
