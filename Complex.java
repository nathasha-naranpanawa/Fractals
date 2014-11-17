/**************************************************
 *                    Complex numbers 
 * 
 **************************************************/
import java.lang.Math; 


public class Complex { 
    public double real; 
    public double comp; 

    Complex(double real, double comp) { 
	this.real = real; 
	this.comp = comp; 
    }

    Complex() { 
	this.real = 0; 
	this.comp = 0;
    }

    public double getReal() {
	return this.real;
    }

    public double getImg() { 
	return this.comp;
    }

    public Complex add(Complex a) { 
	return new Complex(this.real + a.real, 
			   this.comp + a.comp); 
    }
    
    public static Complex add(Complex a, Complex b) { 
	return new Complex(a.real + b.real, 
			   a.comp + b.comp);
    }

    public Complex addConst(double re) { 
	return new Complex(this.real + re, 
			   this.comp);
    }

    public static Complex addConst(double re, Complex a) { 
	return a.addConst(re);
    }

    public Complex sub(Complex a) { 
	return new Complex(this.real - a.real, 
			   this.comp - a.comp); 
    }
    
    public static Complex sub(Complex a, Complex b) { 
	return a.sub(b); 
    }

    public double getABS() { 
	return Math.sqrt((this.real) * (this.real) + 
			 (this.comp) * (this.comp));
    }

    public double getABSSqr() { 
	return (this.real * this.real + this.comp * this.comp);
    }

    public Complex mul(Complex a) { 
	return new Complex((this.real * a.real - this.comp * a.comp), 
			   (this.real * a.comp + this.comp * a.real));
    }

    public static Complex mul(Complex a, Complex b) { 
	return new Complex((a.real * b.real - a.comp * b.comp), 
			   (a.real * b.comp + a.comp * b.real));
    }

    public Complex squre() { 
	return mul(this, this);
    }	

    public void display() { 
	System.out.println(this.real + " + " + this.comp + "j");
    }
}
	