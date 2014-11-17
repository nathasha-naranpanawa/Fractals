import java.awt.Color; 

public class Mandelbrot { 
    private static final int maxit = 3000; 

    public static Color getMandelbrotColor(Complex t) { 
	int i = 0; 
	Complex z = new Complex(0, 0); 
	for(i=0; 
	    (i<maxit) && (z.getABSSqr() < 4); 
	    i++)
	    z = t.add(z.squre());
	if(i==maxit) return Color.BLACK;
	return new Color((10 + i)%256, 
			 (i + 234) % 7 * (255/7), 
			 (i+100) % 9 * (255/9));
    }
}

    