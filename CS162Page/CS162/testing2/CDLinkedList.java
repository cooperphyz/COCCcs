import java.io.*;
import java.util.*;
import java.util.Random;
/**
 * Write a description of class LinkedLists here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CDLinkedList<T> implements Interface
{
    private Node<T> start = null;
    private Node<T> last = null;
    private static int size = 0;
    private static Scanner x;
    private static int linesize = 1;
    private static CDLinkedList<Person> list = new CDLinkedList<>();
    private static Random r;

    public static void main(String[] args) {
        int size = 0;
        openFile();
        readFile();
        //list.addFirst(new Person("James", "Lasters", "920519639"));
        //list.addFirst(new Person("Argo", "Sretlas", "192614063"));
        //list.addLast(new Person("Boris", "Aureff", "382857192"));
        //list.add(2, new Person("Yuar", "Boggson", "868337415"));
        //list.addFirst(new Person("Ebocr", "Scrae", "581818574"));
        System.out.println(list);
        closeFile();
    }
    public static void openFile() {
        try{
            x = new Scanner(new File("infofile.txt"));
        } catch(Exception e) {
            System.out.println("Could not open file");
        }
    }
    public static void readFile() {
        if(x != null) {
        while(x.hasNext()) {
            String a = x.next();
            String b = x.next();
            String c = x.next();
            list.addFirst(new Person(a, b, c));
        }
        }
    }
    public String toString() {
        Node<T> node = start;
        String returnstring = "";
        for(int i = 0; i < size; i++) {
        returnstring = returnstring + (node.getName() + " " + node.getLastName() + " " + node.getID() + "\n");
        node = node.next;
        }
        return returnstring;
    }
    public static void closeFile() {
        x.close();
    }
    public Node<T> getFirst() {
        return start;
    }
    
    public static int size() {
        return size;
    }
    public int getSize() {
        return size;
    }
    public Node<T> getLast() {
        return last;
    }
    
    public Node<T> get(int position) {
        Node<T> temp = start;
        if(position > 0 && position <= size) {
        for(int i = 1; i<=size; i++) {
            if(i == position) {
                return temp;
            }
            temp = temp.next;
        }
        }
        return null;
    }
    public boolean contains(String arg) {
        Node<T> temp = start;
        if(size>0) {
            for(int i = 1; i<=size; i++) {
                System.out.println(temp.getName());
                if((temp.getName()).equals(arg) || (temp.getLastName()).equals(arg) || (temp.getID()).equals(arg)) {
                    return true;
                }
                temp = temp.next;
            }
        }
        return false;
    }
    public void addFirst(Person data) {
        Node<T> node = new Node(data);
        
        if(start == null) {
            start = node;
            last = node;
            start.next = node;
            start.previous = node;
        } else {
        node.next = start;
        node.previous = last;
        if (start != null) {
            start.previous = node;
        }
        if (last == null) {
            last = node;
        }
        start = node;
        if (last.next == null) {
            last.next = start;
        }
        }
        size++;
    }
    public void addLast(Person data) {
        Node<T> node = new Node(data);
        
        if(start == null) {
            start = node;
            last = node;
            last.previous = last;
            last.next = last;
            size++;
            return;
        }
            node.previous = last;
            last.next = node;
            start.previous = node;
            node.next = start;
            last = node;
            
            size++;
    }
    public void add(int position, Person data) {
        if(position == 1) {
            addFirst(data);
            return;
          }
        if(position == size+1) {
            addLast(data);
            return;
        }
        Node<T> node = new Node(data);
        Node<T> temp = new Node(data);
        Node<T> tempers = new Node(data);
        temp = start;

        int i = 1;
        for(int j = 2; j <= size; j++) {
            if(j == position) {
                tempers = temp.next;
                temp.next = node;
                node.previous = temp;
                node.next = tempers;
                tempers.previous = node;
            }
            temp = temp.next;
        }
        size++;
    }
    public void removeLast() {
        if(size==1) {
            start = null;
            last = null;
            size--;
            return;
        }
        if(size>0) {
        last = last.previous;
        last.next = start;
        start.previous = last;
        size--;
        return;
        }
    }
    public void removeFirst() {
        if(size == 0) {
            return;
        }
        if(size == 1) {
            start = null;
            last = null;
            size--;
            return;
        } else {
            start = start.next;
            start.previous = last;
            last.next = start;
            size--;
            return;
        }
    }
    public void remove(int position) {
        Node<T> temp = start;
        if(position == 1 && size==1) {
            removeFirst();
        }
        if(position == 1 && size>0) {
            removeFirst();
        }
        if(position == size && size>0) {
            removeLast();
        }
        for(int i = 2; i <= size; i++) {
            if(i == position) {
                Node<T> tempers = temp.previous;
                Node<T> temper = temp.next;
                tempers.next = temper;
                temper.previous = tempers;
                size--;
                return;
            }
            temp = temp.next;
        }
    }
    public void clear() {
        if(start != null) {
        Node<T> temp = start;
        Node<T> tempers = start;
        if(size>0) {
            for(int i = 1; i<=size; i++) {
                tempers = temp.next;
                temp = null;
                temp = tempers;
            }
            start = null;
            last = null;
        }
        }
        size=0;
    }
    public void print() {
        Node<T> node = start;
        System.out.println(start);
        for(int i = 1; i < size; i++) {
            System.out.println(node.next);
            node = node.next;
        }
    }
    public static class Node<T> {
        private Node next;
        private Node previous;
        private Person data;
        private int index;
        
        public Node(Person person) {
            data = person;
            next = null;
            previous = null;
        }
        public String toString() {
            return data.name + " " + data.lastname + " " + data.id;
        }
        public String getName() {
            return data.name;
        }
        public String getLastName() {
            return data.lastname;
        }
        public String getID() {
            return data.id;
        }
    }
}
