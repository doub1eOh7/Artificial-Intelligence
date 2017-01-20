import java.util.Iterator;
import java.util.TreeSet;

public class StateExplorer {
	
	//Explores all possible moves and adds them to childTree if the state is not already in fullTree, then runs again with childTree as new parentTree
	public GameState exploreChildren(TreeSet<GameState> fullTree, TreeSet<GameState> parentTree)
	{
		StateComparator comp = new StateComparator();
		TreeSet<GameState> childTree = new TreeSet<GameState>(comp);
		GameStateCheck gsc = new GameStateCheck();
		GameState winningState = new GameState(null);
		boolean cont = true;
		
		Iterator<GameState> iter = parentTree.iterator();
		while(iter.hasNext())
		{
			GameState parent = iter.next();
			byte[] possibleChildState = parent.getState().clone();
			
			//SHIFT ONE DOWN OR RIGHT
			for(int i = 0; i < 22; i++)
			{
				possibleChildState[i] = (byte)(possibleChildState[i] + 1);
				GameState newState = new GameState(parent, possibleChildState);
				if(gsc.isValid(newState))
				{
					if(newState.getState()[1] == -2)
					{
						cont = false;
						winningState = newState;
					}
					if(fullTree.add(newState))
					{
						//System.out.println("Added State: " + fullTree.size());
						childTree.add(newState);
					}
				}
				possibleChildState[i] = (byte)(possibleChildState[i] - 1);
			}
			//SHIFT ONE LEFT OR UP
			for(int i = 0; i < 22; i++)
			{
				possibleChildState[i] = (byte)(possibleChildState[i] - 1);
				GameState newState = new GameState(parent, possibleChildState);
				if(gsc.isValid(newState))
				{
					if(newState.getState()[1] == -2)
					{
						cont = false;
						winningState = newState;
					}
					if(fullTree.add(newState))
					{
						//System.out.println("Added State: " + fullTree.size());
						childTree.add(newState);
					}
					
				}
				possibleChildState[i] = (byte)(possibleChildState[i] + 1);
			}
		}
		
		if(!childTree.isEmpty() && cont)
		{
			//System.out.println("Number of Child moves to explore: " + childTree.size());
			winningState = exploreChildren(fullTree, childTree);
		}
		else
		{
			//System.out.println("Exiting State Explorer");
		}
		
		return winningState;
	}
}
