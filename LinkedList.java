// -------------------------------------------------------
// Deliverable 4
// Written by: Fadi Rasmy, 6235195 Using Dr. Niloufar Salehi Dastjerdi powerpoints notes and
// For “Data Structures and OOP” Section 01– Winter 2024
// --------------------------------------------------------
import java.util.ArrayList;

public class LinkedList<T>
{

    private class Node<T>
    {
        private T data;
        private Node<T> link;

        public Node( )
        {
            data = null;
            link = null;
        }

        public Node(T newData, Node<T> linkValue)
        {
            data = newData;
            link = linkValue;
        }
    }

    private Node<T> head;

    public LinkedList( )
    {
        head = null;
    }

    public void add(T itemData)
    {
        head = new Node<T>(itemData, head);
    }
    public boolean delete( )
    {
        if (head != null)
        {
            head = head.link;
            return true;
        }
        else
            return false;
    }

    public int size( )
    {
        int count = 0;
        Node<T> position = head;
        while (position != null)
        {
            count++;
            position = position.link;
        }
        return count;
    }

    public boolean contains(T item)
    {
        return (find(item) != null);
    }

    private Node<T> find(T target)
    {
        Node<T> position = head;
        T itemAtPosition;
        while (position != null)
        {
            itemAtPosition = position.data;
            if (itemAtPosition.equals(target))
                return position;
            position = position.link;
        }
        return null;
    }

    public T findData(T target)
    {
        return find(target).data;
    }

    public void outputList( )       //prints all data from the linkedlist
    {
        Node<T> position = head;
        while (position != null)
        {
            System.out.println(position.data);
            position = position.link;
        }
    }
    public String textoutputList( )       //returns all data from the linkedlist
    {
        String txt="";
        Node<T> position = head;
        while (position != null)
        {
            txt+=(position.data).toString();
            txt+="\n";
            System.out.println(position.data);
            position = position.link;
        }
        return txt;
    }
    public T returndata(){
        Node<T> position = head;
        return position.data;
    }

    public boolean isEmpty( )
    {
        return (head == null);
    }

    public void clear( )
    {
        head = null;
    }

    public ArrayList<T> toArray(){
        Node<T> position = head;
        ArrayList<T> a = new ArrayList<T>();
        while (position != null)
        {
            a.add(position.data);
            position = position.link;
        }
        return a;
    }
    public boolean equals(Object otherObject)
    {
        if (otherObject == null)
            return false;
        else if (getClass( ) != otherObject.getClass( ))
            return false;
        else
        {
            LinkedList<T> otherList = (LinkedList<T>)otherObject;
            if (size( ) != otherList.size( ))
                return false;
            Node<T> position = head;
            Node<T> otherPosition = otherList.head;
            while (position != null)
            {
                if (!(position.data.equals(otherPosition.data)))
                    return false;
                position = position.link;
                otherPosition = otherPosition.link;
            }
            return true;
        }
    }

}
