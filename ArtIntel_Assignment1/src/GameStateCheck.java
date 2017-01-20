import java.util.*;

public class GameStateCheck
{
	//Variable for checking valid state boolean[x][y], origin top left
	private boolean[][] filledSpaces = new boolean[10][10];
	private boolean[][] initFilledSpaces = new boolean[10][10];
	private Shape[] shapeList;
	
	public GameStateCheck()
	{
		initGameFilledSpaces();
		initShapeList();
	}
	
	// Initialize Black Game Squares of Array
	public void initGameFilledSpaces()
	{
		for(int x = 0; x < 10; x++)
		{
			for(int y = 0; y < 10; y++)
			{
				initFilledSpaces[x][y] = false;
			}
		}

		//Initialize Outline Black Squares
		for(int i = 0; i < 10; i++)
		{
			initFilledSpaces[0][i] = true;
			initFilledSpaces[9][i] = true;
			initFilledSpaces[i][0] = true;
			initFilledSpaces[i][9] = true;
		}
		initFilledSpaces[1][1] = true;
		initFilledSpaces[2][1] = true;
		initFilledSpaces[1][2] = true;
		initFilledSpaces[7][1] = true;
		initFilledSpaces[8][1] = true;
		initFilledSpaces[8][2] = true;
		initFilledSpaces[8][7] = true;
		initFilledSpaces[8][8] = true;
		initFilledSpaces[7][8] = true;
		initFilledSpaces[1][7] = true;
		initFilledSpaces[1][8] = true;
		initFilledSpaces[2][8] = true;
		
		//Initialize center black squares
		initFilledSpaces[3][4] = true;
		initFilledSpaces[4][3] = true;
		initFilledSpaces[4][4] = true;
	}
	
	public void initShapeList()
	{
		shapeList = new Shape[11];
		shapeList[0] = new Shape(0, 4, 1, 3, 2, 3, 1, 4, 2, 4);
		shapeList[1] = new Shape(1, 3, 1, 5, 1, 6, 2, 6);
		shapeList[2] = new Shape(2, 3, 2, 5, 3, 5, 3, 6);
		shapeList[3] = new Shape(3, 3, 3, 7, 3, 8, 4, 8);
		shapeList[4] = new Shape(4, 3, 4, 7, 5, 7, 5, 8);
		shapeList[5] = new Shape(5, 3, 6, 7, 7, 7, 6, 8);
		shapeList[6] = new Shape(6, 4, 5, 4, 4, 5, 5, 5, 5, 6);
		shapeList[7] = new Shape(7, 4, 6, 4, 6, 5, 6, 6, 7, 5);
		shapeList[8] = new Shape(8, 3, 8, 5, 8, 6, 7, 6);
		shapeList[9] = new Shape(9, 3, 6, 2, 6, 3, 5, 3);
		shapeList[10] = new Shape(10, 3, 5, 1, 6, 1, 5, 2);
		
	}
	
	//Check if move is valid for Game, returns true if valid
	public boolean isValid(GameState state)
	{
		/*
		System.out.println("Before Initialization");
		printFilledSpaces();
		//Print InitFilledSpaces
		System.out.println("InitFilledSpaces");
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				System.out.print(initFilledSpaces[j][i] + ",\t");
			}
			
			System.out.println("");
		}
		System.out.println("");
		*/
		for(int i = 0; i < 10; i++)
		{
			filledSpaces[i] = initFilledSpaces[i].clone();
		}
		/*
		if(filledSpaces == initFilledSpaces)
		{
			System.out.println("Houston we have a problem");
		}
		if(Arrays.deepEquals(filledSpaces, initFilledSpaces))
		{
			System.out.println("This is good");
		}
		System.out.println("After Initialization");
		printFilledSpaces();
		*/
		for(Shape shape : shapeList)
		{
			if(fillSpace(shape, state))
			{
				//System.out.println("BAD");
				return false;
			}
		}
		
		return true;
	}
	
	//Returns True if the space is already filled, and fills the space if not
	public boolean fillSpace(Shape shape, GameState gs)
	{
		int id = 0;
		int size = 0;
		int x1, x2, x3, x4;
		int y1, y2, y3, y4;
		
		id = shape.getId();
		size = shape.getSize();
		x1 = shape.getX1();
		x2 = shape.getX2();
		x3 = shape.getX3();
		x4 = shape.getX4();
		y1 = shape.getY1();
		y2 = shape.getY2();
		y3 = shape.getY3();
		y4 = shape.getY4();
		
		if(size == 3)
		{
			if(filledSpaces[x1 + gs.state[2*id]][y1 + gs.state[2*id + 1]])
			{
				//System.out.println(id + ": " + (x1 + gs.state[2*id]) + ", " + (y1 + gs.state[2*id + 1]));
				return true;
			}
			else
				filledSpaces[x1 + gs.state[2*id]][y1 + gs.state[2*id + 1]] = true;
			if(filledSpaces[x2 + gs.state[2*id]][y2 + gs.state[2*id + 1]])
			{
				//System.out.println(id + ": " + (x2 + gs.state[2*id]) + ", " + (y2 + gs.state[2*id + 1]));
				return true;
			}
			else
				filledSpaces[x2 + gs.state[2*id]][y2 + gs.state[2*id + 1]] = true;
			if(filledSpaces[x3 + gs.state[2*id]][y3 + gs.state[2*id + 1]])
			{
				//System.out.println(id + ": " + (x3 + gs.state[2*id]) + ", " + (y3 + gs.state[2*id + 1]));
				return true;
			}
			else
				filledSpaces[x3 + gs.state[2*id]][y3 + gs.state[2*id + 1]] = true;
		}
		else if(size == 4)
		{
			if(filledSpaces[x1 + gs.state[2*id]][y1 + gs.state[2*id + 1]])
			{
				//System.out.println(id + ": " + (x1 + gs.state[2*id]) + ", " + (y1 + gs.state[2*id + 1]));
				return true;
			}
			else
				filledSpaces[x1 + gs.state[2*id]][y1 + gs.state[2*id + 1]] = true;
			if(filledSpaces[x2 + gs.state[2*id]][y2 + gs.state[2*id + 1]])
			{
				//System.out.println(id + ": " + (x2 + gs.state[2*id]) + ", " + (y2 + gs.state[2*id + 1]));
				return true;
			}
			else
				filledSpaces[x2 + gs.state[2*id]][y2 + gs.state[2*id + 1]] = true;
			if(filledSpaces[x3 + gs.state[2*id]][y3 + gs.state[2*id + 1]])
			{
				//System.out.println(id + ": " + (x3 + gs.state[2*id]) + ", " + (y3 + gs.state[2*id + 1]));
				return true;
			}
			else
				filledSpaces[x3 + gs.state[2*id]][y3 + gs.state[2*id + 1]] = true;
			if(filledSpaces[x4 + gs.state[2*id]][y4 + gs.state[2*id + 1]])
			{
				//System.out.println(id + ": " + (x4 + gs.state[2*id]) + ", " + (y4 + gs.state[2*id + 1]));
				return true;
			}
			else
				filledSpaces[x4 + gs.state[2*id]][y4 + gs.state[2*id + 1]] = true;
		}
		
		return false;
	}
	
	public void printFilledSpaces()
	{
		//Work on printing out filled spaces to make sure initialization was done correctly
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				System.out.print(filledSpaces[j][i] + ",\t");
			}
			
			System.out.println("");
		}
		System.out.println("");
	}
	
}
