import java.util.Iterator;

public class myListTest {
    public static void main(String[] args) {
        try {
            myList lst = new myList();
            lst.add_element_to_end(0);
            lst.add_element_to_end(1);
            lst.add_element_to_end(2);
            lst.add_element_to_end(3);
            lst.add_element_to_end(4);
            assert lst.get(0).equals(1) : "Failed test #1";
            assert lst.get(1).equals(2) : "Failed test #1";
            assert lst.get(2).equals(3) : "Failed test #1";
            assert lst.get(3).equals(4) : "Failed test #1";
            assert lst.get(4).equals(5) : "Failed test #1";


            
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }


        
        try {
            myList lst = new myList();
            lst.add_element_to_end(1);
            lst.add_element_to_end(2);
            lst.add_element_to_end(3);
            lst.add_element_to_end(4);
            lst.add_element_to_end(5);

            myList other = new myList(lst);
            assert other.get(0).equals(1) : "Failed test #2";
            assert other.get(1).equals(2) : "Failed test #2";
            assert other.get(2).equals(3) : "Failed test #2";
            assert other.get(3).equals(4) : "Failed test #2";
            assert other.get(4).equals(5) : "Failed test #2";
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            myList lst = new myList();
            lst.add_element_to_end(1);
            lst.add_element_to_end(2);
            lst.add_element_to_end(3);
            lst.add_element_to_end(4);
            lst.add_element_to_end(5);

            lst.add_element_to_head(0);
            assert lst.get(0).equals(0) : "Failed test #3";
            assert lst.get(1).equals(1) : "Failed test #3";
            assert lst.get(2).equals(2) : "Failed test #3";
            assert 6 == lst.Length() : "Failed test #3";

            lst.add_element_to_head(-1);
            assert lst.get(0).equals(-1) : "Failed test #4";
            assert lst.get(1).equals(0) : "Failed test #4";
            assert lst.get(2).equals(1) : "Failed test #4";
            assert 7 == lst.Length() : "Failed test #4";
            
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            myList lst = new myList();
            lst.add_element_to_end(1);
            lst.add_element_to_end(2);
            lst.add_element_to_end(3);
            lst.add_element_to_end(4);
            lst.add_element_to_end(5);

            lst.add_element_to_end(0);
            assert lst.get(5).equals(0) : "Failed test #5";
            assert lst.get(4).equals(5) : "Failed test #5";
            assert lst.get(3).equals(4) : "Failed test #5";
            assert 6 == lst.Length() : "Failed test #5";

            lst.add_element_to_end(-1);
            assert lst.get(6).equals(-1) : "Failed test #6";
            assert lst.get(5).equals(0) : "Failed test #6";
            assert lst.get(4).equals(5) : "Failed test #6";
            assert 7 == lst.Length() : "Failed test #6";
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }




        try {
            myList lst = new myList();
            lst.add_element_to_end(1);
            lst.add_element_to_end(2);
            lst.add_element_to_end(3);
            lst.add_element_to_end(4);
            lst.add_element_to_end(5);

            lst.del_element_head();
            assert lst.equals(1) : "Failed test #7";
            assert 4 == lst.Length() : "Failed test #7";

            lst.del_element_head();
            assert lst.equals(2) : "Failed test #8";
            assert 3 == lst.Length() : "Failed test #8";

            lst.del_element_head();
            lst.del_element_head();
            lst.del_element_head();
            assert lst.equals(5) : "Failed test #9";
            assert 0 == lst.Length() : "Failed test #9";            
            
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        

        try {
        myList lst = new myList();
        lst.add_element_to_end(1);
        lst.add_element_to_end(2);
        lst.add_element_to_end(3);
        lst.add_element_to_end(4);
        lst.add_element_to_end(5);

        lst.del_element(2);
        assert lst.get(1).equals(1) : "Failed test #13";
        assert 4 == lst.Length() : "Failed test #13";

        lst.del_element(5);
        assert lst.get(1).equals(3) : "Failed test #14";
        assert 3 == lst.Length() : "Failed test #14";

        lst.del_element(2);
        assert 3 == lst.Length() : "Failed test #15";
            
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }


        try {
            
            myList lst = new myList();
            lst.add_element_to_end(1);
            lst.add_element_to_end(2);
            lst.add_element_to_end(3);
            lst.add_element_to_end(4);
            lst.add_element_to_end(5);

            lst.del_element(1);
            assert lst.get(1).equals(0) : "Failed test #16";
            assert 4 == lst.Length() : "Failed test #16";

            lst.del_element(5);
            assert lst.get(3).equals(0) : "Failed test #17";
            assert 3 == lst.Length() : "Failed test #17";

            lst.del_element(2);
            assert lst.get(3).equals(0) : "Failed test #18";
            assert 2 == lst.Length() : "Failed test #18";
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }


        try {
            
            myList lst = new myList();
            lst.add_element_to_end(1);
            lst.add_element_to_end(2);
            lst.add_element_to_end(3);
            lst.add_element_to_end(4);
            lst.add_element_to_end(5);

            lst.clear(lst);
            assert 0 == lst.Length() : "Faailed test #19";
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}