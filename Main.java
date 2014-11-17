/**********************************************************
 *                      E/11/269                          *
 **********************************************************/

import java.awt.*; /* java abstract window toolkit */
import java.awt.event.*; 
import javax.swing.*;
import javax.imageio.*;
import java.awt.geom.Line2D;

public class Main extends JPanel { 

    /* title for the panel */
    public static final String TITLE   = "TEST IMAGE";

    /* how big should my panel be */
    public static final int IMG_WIDTH  = 600; 
    public static final int IMG_HEIGHT = 600; 

    /* where to map the panel to complex plane 
     * Basically min and max for real and complex axis
     * You can change these numbers and see what you get
     */

    public static final double minRe = -1.50;
    public static final double maxRe = 1;
    public static final double minIm = -1.5;
    public static final double maxIm = 1.5;
    
   /* 
    * following array keeps track of colour for each pixel 
    */
    public static Color [][] image;

    public static final double XFAC = (maxRe - minRe) / IMG_WIDTH;
    public static final double YFAC = (maxIm - minIm) / IMG_HEIGHT;

    public Main(String [] args) { 
	/* set the size of the frame */
	setPreferredSize(new Dimension(IMG_WIDTH, IMG_HEIGHT)); 

	/* new image 
	 * we create the image later and paint it
	 */
	image = new Color[IMG_WIDTH][IMG_HEIGHT];
	
	try{
			Read(args); 
		} catch (ArrayIndexOutOfBoundsException x){
			System.out.println("Give correct input values.");
			System.exit(-1);
		}
    }

	
	public void Read(String [] args){
		int length = args.length;
		for(int i=0;i<length;i++){
			if (args[i].equals("Julia")) {
				
				Complex c2 = getSeperate(args);
                generateJuliaImage(c2);

            }else if (args[0].equals("Mandelbrot")){
				generateMandelbrotImage();
			}
		}

	}


	public Complex getSeperate(String [] args){
		int length = args.length;
		String num = args[length-1];
				char realsign = '\0';
		char imagsign = '\0';

		for (int j = 0; j < num.length(); j++) 
		{
		char a = num.charAt(j);
		  
			if(a =='+'){
				if(j==0){ 
					realsign = a;
				}else{
					imagsign=a;
				}
			  
			}else if(a=='-'){

				if(j==0){ 
					realsign = a;
				}else{
					imagsign=a;
				}
	 
			}else if ((Character.isDigit(a))&&(j==0)){   
			  
				realsign = '+';
			}   
		} 
		String c = "";
	
		if (realsign=='-'){
			for(int k=1;k<num.length()-1;k++){
			char b = num.charAt(k);
			 c += b;
			}
		}else{
			c=num;
		}
	
		String [] s = c.split("[-+*/]");
						
		String [] imagarr = s[1].split("i");
		
		double realnum = Double.parseDouble(s[0]);
		double imagnum = Double.parseDouble(imagarr[0]);
						
		double real=0;
		double imag=0;
						
		if (realsign=='+'){
			real = realnum;
		}else{
			real = -realnum;
		}
						
		if (imagsign=='+'){
			imag = imagnum;
		}else{
			imag = -imagnum;
		}
			
		Complex c2 = new Complex(real,imag);
		return c2;
}
	
	
    public void paintComponent(Graphics g) { 
	/* call the paintComponent from super class
	 * sets up the window 
	 */
	super.paintComponent(g); 
	paintImage((Graphics2D)g); 
    }

    public static void printPoint(Graphics2D frame, 
				  Color z, Points p) { 
	frame.setColor(z); 
	frame.draw(new Line2D.Double(p.x, p.y, p.x, p.y));
    }
    
	 public static void generateMandelbrotImage() { 
	for(int x=0; x < IMG_WIDTH; x++) { 
	    for(int y=0; y < IMG_HEIGHT; y++) { 
		Points  p   = new Points(x, y);
		Complex c   = mapToComplexPlane(p); 
		image[x][y] = Mandelbrot.getMandelbrotColor(c);
	    }
	}
	System.out.println("Image Generated!");
    }

    public static void generateJuliaImage(Complex cons) { 
	for(int x=0; x < IMG_WIDTH; x++) { 
	    for(int y=0; y < IMG_HEIGHT; y++) { 
		Points  p   = new Points(x, y);
		Complex z   = mapToComplexPlane(p); 
		image[x][y] = Julia.getJuliaColor(z,cons);
	    }
	}
	System.out.println("Image Generated!");
    }

	
	
	
    public static void paintImage(Graphics2D frame) { 
	for(int x=0; x < IMG_WIDTH; x++) { 
	    for(int y=0; y < IMG_HEIGHT; y++) { 
		printPoint(frame, image[x][y], new Points(x,y));
	    }
	}
	System.out.println("Image Printed!");
    }    

    public static Complex mapToComplexPlane(Points p) { 
	return new Complex(p.x * XFAC + minRe, 
			   p.y * YFAC + minIm);
    }

    public static void main(String [] args) { 

	JFrame frame = new JFrame(TITLE); 

	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

	

	frame.setContentPane(new Main(args)); 

	frame.pack(); 

	frame.setLocationRelativeTo(null); 

	frame.setVisible(true); 
    }

} /* end of class */

    
