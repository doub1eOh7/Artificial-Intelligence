import java.util.Comparator;

class StateComparator implements Comparator<GameState>
{
	public int compare(GameState a, GameState b)
	{
		byte[] statea = a.getState();
		byte[] stateb = b.getState();
		for(int i = 0; i < 22; i++)
		{
			if(statea[i] < stateb[i])
				return -1;
			else if(statea[i] > stateb[i])
				return 1;
		}
		return 0;
	}
}  