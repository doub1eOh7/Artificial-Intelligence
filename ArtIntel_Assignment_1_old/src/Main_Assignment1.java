import java.util.*;

public class Main_Assignment1 {

	public static void main(String[] args) {
		
		GameState game = new GameState();
		game.initGameFilledSpaces();
		game.initShapeList();
		//game.isValid();
		TreeSet<byte[]> ts = new TreeSet<byte[]>();
		
		//Try to find all possible states in next tree branch
		//Move one piece right or down
		/*for(int i = 0; i < 22; i++)
		{
			game.nextState(i, 1);
			//System.out.println(Arrays.toString(game.getState()));
			if(game.isValid())
			{
				//System.out.println("YAY!!");
				ts.add(game.getState());
			}
			game.nextState(i, -1);
		}
		
		//Move one piece left or up
		for(int i = 0; i < 22; i++)
		{
			game.nextState(i, -1);
			//System.out.println(Arrays.toString(game.getState()));
			if(game.isValid())
			{
				//System.out.println("YAY!!");
				ts.add(game.getState());
			}
			game.nextState(i, 1);
		}
		*/
		//Test moving shape 10, 1 move to the left
		game.nextState(20, -1);
		System.out.println(Arrays.toString(game.getState()));
		game.printFilledSpaces();
		if(game.isValid())
		{
			System.out.println("YAY!!");
			//ts.add(game.getState());
		}
		game.nextState(20, 1);
		
		
		System.out.print(ts);
		System.out.println("done");
		
		StateComparator comp = new StateComparator();
		TreeSet<GameState> set = new TreeSet<GameState>(comp);
		GameState a = new GameState();
		a.state[21] = 7;
		GameState b = new GameState();
		b.state[14] = 3;
		GameState c = new GameState();
		c.state[21] = 7;
		if(!set.contains(a))
			System.out.println("Passed 1");
		else
			System.out.println("oops 1");
		set.add(a);
		if(set.contains(a))
			System.out.println("Passed 2");
		else
			System.out.println("oops 2");
		if(!set.contains(b))
			System.out.println("Passed 3");
		else
			System.out.println("oops 3");
		if(set.contains(c))
			System.out.println("Passed 4");
		else
			System.out.println("oops 4");

	}

}