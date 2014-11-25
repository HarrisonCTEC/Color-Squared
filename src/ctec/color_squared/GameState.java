package ctec.color_squared;

public class GameState
{
	private int hotButton;
	private int score;
	

	public void GameState()
	{
		this.hotButton = 0;
		this.score = 0;
	}
	
	public void increaseScore()
	{
		this.score++;
	}
	
	public int getScore()
	{
		return score;
	}

	public void setScore(int score)
	{
		this.score = score;
	}

	public int getHotButton()
	{
		return hotButton;
	}

	public void setHotButton(int hotButton)
	{
		this.hotButton = hotButton;
	}
}
