import java.util.*;

public class myIterator implements Iterator{
    
    public myList ml;

    public myIterator(myList ml){
        this.ml = ml;
    }
    
    @Override
    public boolean hasNext(){
        return ml.head != null;
    }

    @Override
    public Object next() throws NoSuchElementException{
        myListNode a = ml.head;
        ml.head = ml.head.next;
        return a.data;
    }
}


class myListNode{
    myListNode next;
    Object data;
}

class myList implements Iterable{
    myListNode head;
    myListNode end;

    public myList(){
        this.head = head;
        this.end = end;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((end == null) ? 0 : end.hashCode());
        result = prime * result + ((head == null) ? 0 : head.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        myList other = (myList) obj;
        if (end == null) {
            if (other.end != null)
                return false;
        } else if (!end.equals(other.end))
            return false;
        if (head == null) {
            if (other.head != null)
                return false;
        } else if (!head.equals(other.head))
            return false;
        return true;
    }

    public myList(myList list){
        this.head = list.head;
        this.end = list.end;
    }

    public void add_element_to_head(Object data){
        myListNode a = new myListNode();
        a.data = data;
        
        if(head == null){
            head = a;
            end = a;
        }
        else{
            a.next = head;
            head = a;
        }
    }

    public void add_element_to_end(Object data){
        myListNode a = new myListNode();
        a.data = data;

        if(end == null){
            head = a;
            end = a;
        }
        else{
            end.next = a;
            end = a;
        }
    }

    public void del_element(Object data){
        
        if (head == null) {
            return;
        }

        if (head.data.equals(data)) {
            head = head.next;
            return;
        }

        myListNode temp = head;

        while(temp.next != null){
            if(temp.next.data.equals(data)){
                if(temp.next == end){
                    end = temp;
                }
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }

    }

    public int Length() {
        int length = 1;
        if(head != null){
            myListNode a = head;
            while(a.next != null) {
                a = a.next;
                length++;
            }
    
            return length;
        }
        else{
            return 0;
        }
        
    }

    public void printList() {
        myListNode a = head;       
        while (a != null) {
            System.out.print(a.data + " ");
            a = a.next;
        }
    }

    public myList clear(myList list){
        list.head = null;
        return list;
    }

    @Override
	public Iterator iterator() {
    		return new myIterator(this);
	}
    
}

class Main {
    public static void main(String[] args) {
        int length = 0;
        myList ml = new myList();
        ml.add_element_to_end(1);
        ml.add_element_to_end(2);
        ml.add_element_to_end(3);
        ml.add_element_to_head(6);
        ml.add_element_to_head('h');

        myList t = new myList(ml);
        
        t.printList();
        System.out.println();
 
        ml.del_element('h');
        ml.printList();
        System.out.println();

        Iterator iter = ml.iterator();

        while(iter.hasNext()){
         
            System.out.print(iter.next() + " ");
        }

    }
}