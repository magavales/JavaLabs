

public class Complex {

    double a;
    double b;



    public Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Complex() {
        this.a = 0;
        this.b = 0;
    }

    public Complex add(Complex num) {
        return new Complex(this.a + num.a, this.b + num.b);
    }

    public Complex sub(Complex num) {
        return new Complex(this.a - num.a, this.b - num.b);
    }

    public Complex mul(Complex num) {
        return new Complex(this.a * num.a - this.b * num.b, this.a * num.b + this.b * num.a);
    }

    public double abs() {
        double sum = this.a * this.a + this.b * this.b;
        return Math.sqrt(sum);
    }
    
    public double corner(){
        if(this.a == 0 && this.b > 0){
            return Math.PI / 2;
        }
        if(this.a == 0 && this.b < 0){
            return 3 * Math.PI / 2;
        }
        if(this.a == 0 && this.b == 0){
            return Double.NaN;
        }
        if(this.a < 0 && this.b < 0){
            return Math.atan(this.b / this.a) - Math.PI;
        }
        if(this.a < 0 && this.b >= 0){
            return Math.atan(this.b / this.a) + Math.PI;
        }
        return Math.atan(this.b / this.a);
    }
    
    public Complex setImage(double image){
        this.b = image;
        return this;
    }

    public Complex setReal(double real){
        this.a = real;
        return this;
    }

    public double getImage(){
        return this.b;
    }

    public double getReal(){
        return this.a;
    }

    public String toString(Complex sum){
        if(sum.b > 0){
            String s_1 = String.valueOf(sum.a);
            String s_2 = String.valueOf(sum.b);
            return s_1 + " " + "+" + " " + s_2 + "i";
        }
        else{
            String s_1 = String.valueOf(sum.a);
            String s_2 = String.valueOf(sum.b);
            return s_1 + " " + "-" + " " + s_2 + "i";
        }
        
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(a);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(b);
        result = prime * result + (int) (temp ^ (temp >>> 32));
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
        Complex other = (Complex) obj;
        if (Double.doubleToLongBits(a) != Double.doubleToLongBits(other.a))
            return false;
        if (Double.doubleToLongBits(b) != Double.doubleToLongBits(other.b))
            return false;
        return true;
    }

    public static void main(String[] args) {
        Complex a = new Complex(1, Math.sqrt(3));
        Complex b = new Complex(3, 2);
        Complex sum = new Complex(0, 0);
        Double k;
        k = a.corner();
        System.out.println(k);
        System.out.println();

    }
}
