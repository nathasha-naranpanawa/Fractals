import java.awt.Color; 

public class Julia { 
    private static final int maxit = 3000; 

    public static Color getJuliaColor(Complex z0, Complex cons) { 
		int i = 0; 
		Complex z = z0; 
		for(i=0; 
			(i<maxit) && (z.getABSSqr() < 4); 
			i++)
			z = cons.add(z.squre());
		if(i==maxit) return Color.BLACK;
		

		return new Color((10 + i)%256,
				 (i + 634) % 7 * (255/7), 
				 (i+300) % 9 * (255/9));
    }
}
