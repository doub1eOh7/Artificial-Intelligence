//Create shape class - id, offsetX, offsetY, number of blocks, other blocks locations.
public class Shape {
	
	private int id;
	private int size;
	private int x1, x2, x3, x4;
	private int y1, y2, y3, y4;
	
	//Two Block Shape Constructor
	public Shape(int newid, int newsize, int newx1, int newy1, int newx2, int newy2)
	{
		id = newid;
		size = newsize;
		x1 = newx1;
		y1 = newy1;
		x2 = newx2;
		y2 = newy2;
	}
	
	//Three Block Shape Constructor
	public Shape(int newid, int newsize, int newx1, int newy1, int newx2, int newy2, int newx3, int newy3)
	{
		id = newid;
		size = newsize;
		x1 = newx1;
		y1 = newy1;
		x2 = newx2;
		y2 = newy2;
		x3 = newx3;
		y3 = newy3;
	}

	//Four Block Shape Constructor
	public Shape(int newid, int newsize, int newx1, int newy1, int newx2, int newy2, int newx3, int newy3, int newx4, int newy4)
	{
		id = newid;
		size = newsize;
		x1 = newx1;
		y1 = newy1;
		x2 = newx2;
		y2 = newy2;
		x3 = newx3;
		y3 = newy3;
		x4 = newx4;
		y4 = newy4;
	}
	
	public int getId()
	{
		return id;
	}
	
	public int getSize()
	{
		return size;
	}
	
	public int getX1()
	{
		return x1;
	}
	public int getX2()
	{
		return x2;
	}
	public int getX3()
	{
		return x3;
	}
	public int getX4()
	{
		return x4;
	}
	public int getY1()
	{
		return y1;
	}
	public int getY2()
	{
		return y2;
	}
	public int getY3()
	{
		return y3;
	}
	public int getY4()
	{
		return y4;
	}

}
