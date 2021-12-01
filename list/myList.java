

class myListNode{
    myListNode next;
    Object data;
}

public class myList {
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

    public void del_element_head(){
        
        if (head == null) {
            return;
        }
        else{
            head = head.next;
            return;
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

    public Object get(int index) {
        if(index >= this.Length() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        
        myListNode t = this.head;
        for(int i = 1; i <= index; i++) {
            t = t.next;
        }

        return t.data;
    }

    public myList clear(myList list){
        list.head = null;
        return list;
    }

}