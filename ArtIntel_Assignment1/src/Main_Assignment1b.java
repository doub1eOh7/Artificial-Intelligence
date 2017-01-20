import java.util.*;
import java.io.*;

public class Main_Assignment1b {

	public static void main(String[] args) {
		
		GameState gameRoot = new GameState(null);
		GameState winningState = new GameState(null);
		//game.isValid();
		
		StateComparator comp = new StateComparator();
		TreeSet<GameState> fullTree = new TreeSet<GameState>(comp);
		TreeSet<GameState> parentTree = new TreeSet<GameState>(comp);
		fullTree.add(gameRoot);
		parentTree.add(gameRoot);
		
		StateExplorer explorer = new StateExplorer();
		winningState = explorer.exploreChildren(fullTree, parentTree);
				
		//System.out.print("Tree set size: ");
		//System.out.println(fullTree.size());
		//System.out.println(Arrays.toString(winningState.getState()));
		GameState gsTracker = winningState;
		List<GameState> winningMoveSet = new ArrayList<GameState>();
		winningMoveSet.add(winningState);
		while(gsTracker != gameRoot)
		{
			gsTracker = gsTracker.getPrev();
			winningMoveSet.add(gsTracker);
		}
		
		Collections.reverse(winningMoveSet);
		try(Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("results.txt") , "utf-8"))){
			for(GameState move : winningMoveSet)
			{
				writer.write(move.getStateString());
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		//System.out.println(Arrays.toString(winningMoveSet.toArray()));
		System.out.println("Done - Total Number of Moves to Solution: " + winningMoveSet.size());
		
		/*
		Iterator<GameState> iter2 = ts.iterator();
		while(iter2.hasNext())
		{
			byte [] temp = iter2.next().state.clone();
			//System.out.println(temp);
			System.out.println(Arrays.toString(temp) + " ");
		}
		*/
		System.out.println();
		
	}

}