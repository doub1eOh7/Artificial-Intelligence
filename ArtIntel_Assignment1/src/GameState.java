class GameState
{
	private GameState prev;
	public byte[] state;

	GameState(GameState _prev)
	{
		prev = _prev;
		state = new byte[22];
	}
	
	GameState(GameState _prev, byte[] newState)
	{
		prev = _prev;
		state = newState.clone();
	}
	
	public GameState getPrev()
	{
		return prev;
	}
	
	public byte[] getState()
	{
		return state;
	}
	
	public String getStateString()
	{
		String tempString = new String();
		for(int i = 0; i < 22; i = i + 2)
		{
			tempString += "(";
			tempString += state[i];
			tempString += ",";
			tempString += state[i+1];
			tempString += ") ";
		}
		tempString += "\n";
		return tempString;
	}
	
	
}