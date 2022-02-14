

/**
 * {@code TestComplex} - тестирующий класс для {@code Complex}
 */
public class ComplexTest {
    public static void main(String[] args) {
        Complex a;
        Complex b;
        
        try {
            a = new Complex(1, 1);
            b = new Complex(2, 2);
            assert new Complex(3, 3).equals(a.add(b)) : "Failed test #1";
            assert !(new Complex(1, 1).equals(a.add(b))) : "Failed test #2";
            
            a = new Complex(1, 1);
            b = new Complex(2, 2);
            assert new Complex(-1, -1).equals(a.sub(b)) : "Failed test #3";
            assert new Complex(0, 0).equals(b.sub(b)) : "Failed test #4";

            a = new Complex(1, 1);
            b = new Complex(2, 2);
            assert !a.equals(b) : "Failed test #5";
            
            b = new Complex(1, 1);
            assert a.equals(b) : "Failed test #6";
            
            a = new Complex(0, 0);
            b = new Complex();
            assert a.equals(b) : "Failed test #7"; 

            a = new Complex(1, 1);
            assert Math.sqrt(2) == a.abs() : "Failed test #8";

            a = new Complex(0, 0);
            assert 0 == a.abs() : "Failed test #9";

            a = new Complex(1, 1);
            assert Math.PI / 4 == a.corner() : "Failed test #10";

            a = new Complex(0, 1);
            assert Math.PI / 2 == a.corner() : "Failed test #11";

            a = new Complex(0, -1);
            assert 3 * Math.PI / 2 == a.corner() : "Failed test #12";

            a = new Complex(0, 1);
            assert 1 == a.getImage() : "Failed test #13";

            a = new Complex(0, 1);
            assert 0 == a.getReal() : "Failed test #14";

            a = new Complex(0, 1);
            a.setImage(2);
            assert 2 == a.getImage() : "Failed test #15";

            a.setImage(3);
            assert 3 == a.getImage() : "Failed test #16";

            a.setImage(4);
            assert 4 == a.getImage() : "Failed test #17";

            a = new Complex(0, 1);
            a.setReal(2);
            assert 2 == a.getReal() : "Failed test #18";

            a.setReal(3);
            assert 3 == a.getReal() : "Failed test #19";

            a.setReal(4);
            assert 4 == a.getReal() : "Failed test #20";

            System.gc();
            
        }
        catch(AssertionError e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("All tests passed!");

    }
}