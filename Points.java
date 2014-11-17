public class Points { 
    public double x; 
    public double y; 

    public Points(double x, double y) { 
	this.x = x; 
	this.y = y; 
    }

    public Points(int x, int y) { 
	this.x = (double)x;
	this.y = (double)y;
    }
}