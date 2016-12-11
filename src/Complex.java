import java.util.Scanner;

/**
 * Created by smtt on 10/3/16.
 */
public class Complex {
    public double re, im;


    public Complex() {
    }


    public Complex(double x) {
        re = x;
    }


    public Complex(double x, double y) {
        re = x;
        im = y;
    }

    public Complex power(double x) {
        double modulus = Math.sqrt(re*re + im*im);
        double arg = Math.atan2(im,re);
        double log_re = Math.log(modulus);
        double log_im = arg;
        double x_log_re = x * log_re;
        double x_log_im = x * log_im;
        double modulus_ans = Math.exp(x_log_re);
        return new Complex(modulus_ans*Math.cos(x_log_im), modulus_ans*Math.sin(x_log_im));
    }
    public Complex inverse() {
        double length = re*re+im*im;
        return new Complex( re/length, -im/length );
    }
    public static void main(String [] args){
        Complex x = new Complex(0.5,-Math.sqrt(3)/2);
        Complex y = new Complex(0.5,Math.sqrt(3)/2);

        Scanner scanner = new Scanner(System.in);
        int n =scanner.nextInt();
        Complex l = x.power(n);
        Complex j = y.power(n);
        Complex o = l.inverse();
        Complex p=  j.inverse();

        Complex finalA = l.plus(j);
        finalA =finalA.plus(o);
        finalA = finalA.plus(p);

        System.out.println((int)(Math.floor(finalA.re) +Math.floor(finalA.im)) );


    }
    public Complex plus(Complex c) {
        return new Complex(re + c.re, im + c.im);
    }

}
