public class myVectorTest {
    public static void main(String[] args) {
        try {
            myVector array = new myVector(5);
            array.addElement(0);
            array.addElement(1);
            array.addElement(2);
            array.addElement(3);
            array.addElement(4);

            assert array.get(0).equals(0) : "Failed test #1";
            assert array.get(1).equals(1) : "Failed test #1";
            assert array.get(2).equals(2) : "Failed test #1";
            assert array.get(3).equals(3) : "Failed test #1";
            assert array.get(4).equals(4) : "Failed test #1";


            
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            myVector array = new myVector(5);
            array.addElement(0);
            array.addElement(1);
            array.addElement(2);
            array.addElement(3);
            array.addElement(4);

            array.addElement(5, 2);
            assert array.get(2).equals(5) : "Failed test #2";

            array.addElement(6, 3);
            assert array.get(3).equals(6) : "Failed test #2";
            
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            myVector array = new myVector(5);
            array.addElement(0);
            array.addElement(1);
            array.addElement(2);
            array.addElement(3);
            array.addElement(4);

            array.delElement();
            assert array.get(4).equals(null) : "Failed test #3";

            array.delElement();
            assert array.get(3).equals(null) : "Failed test #3";
            
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            myVector array = new myVector(5);
            array.addElement(0);
            array.addElement(1);
            array.addElement(2);
            array.addElement(3);
            array.addElement(4);

            array.delElement(4);
            assert array.get(4).equals(null) : "Failed test #4";

            array.delElement(3);
            assert array.get(3).equals(null) : "Failed test #4";
            
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            myVector array = new myVector(5);
            array.addElement(0);
            array.addElement(1);
            array.addElement(2);
            array.addElement(3);
            array.addElement(4);

            array.clear();
            assert 0 == array.getElements() : "Failed test #5";
            
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
