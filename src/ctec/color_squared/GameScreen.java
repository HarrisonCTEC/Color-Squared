package ctec.color_squared;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Color;
import android.os.Bundle;

public class GameScreen extends Activity
{
	private Button tile1, tile2, tile3, tile4, tile5, tile6, tile7, tile8, tile9;
	private List<Color> playerColors;
	private int playerProgress;
	private Tiles gameTile;
	private Color pink, magenta, red, yellow, orange, green, grue, purple;
	private Color[] gridPattern = new Color[8];
	private int playerScore;
	private long startTime;
	private long endTime;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game_screen);
		
		pink = Color.parseColor("#E0A0C0");
		magenta = Color.parseColor("#E04080");
		red = Color.parseColor("#E04040");
		yellow = Color.parseColor("#C08000");
		orange = Color.parseColor("#E06040");
		green = Color.parseColor("#C0E000");
		grue = Color.parseColor("#E6EA080");
		blue = Color.parseColor("#E00A0C0");
		purple = Color.parseColor("#6080C0");
		
		//INITALIZE BUTTONS
		
		playerColors = new ArrayList<Color>();
		playerScore = 0;
		levelGenerator();
		playerProgress = 0;
		displayPlayerColors();
		displayPlayerProgress();
		updateGrid();
		startTime = System.currentTimeMillis();
	}
    
	private void setupListners()
	{
		tile1.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View currentView)
			{
				if(gameTile.isHotbutton(1) && playerProgress !> 5)
				{
					playerCorrect();
					endTime = System.currentTimeMillis();
					calculateScore(startTime, endTime);
					updateGrid();
					updateScore();
					startTime = System.currentTimeMillis();
				}
				else
				{
					endGame();
				}
			}
		});
		tile2.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View currentView)
			{
				if(gameTile.isHotbutton(2) && playerProgress !> 5)
				{
					playerCorrect();
					endTime = System.currentTimeMillis();
					calculateScore(startTime, endTime);
					updateGrid();
					updateScore();
					startTime = System.currentTimeMillis();
				}
				else
				{
					endGame();
				}
			}
		});
		tile3.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View currentView)
			{
				if(gameTile.isHotbutton(3) && playerProgress !> 5)
				{
					playerCorrect();
					endTime = System.currentTimeMillis();
					calculateScore(startTime, endTime);
					updateGrid();
					updateScore();
					startTime = System.currentTimeMillis();
				}
				else
				{
					endGame();
				}
			}
		});
		tile4.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View currentView)
			{
				if(gameTile.isHotbutton(4) && playerProgress !> 5)
				{
					playerCorrect();
					endTime = System.currentTimeMillis();
					calculateScore(startTime, endTime);
					updateGrid();
					updateScore();
					startTime = System.currentTimeMillis();
				}
				else
				{
					endGame();
				}
			}
		});
		tile5.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View currentView)
			{
				if(gameTile.isHotbutton(5) && playerProgress !> 5)
				{
					playerCorrect();
					endTime = System.currentTimeMillis();
					calculateScore(startTime, endTime);
					updateGrid();
					updateScore();
					startTime = System.currentTimeMillis();
				}
				else
				{
					endGame();
				}
			}
		});
		tile6.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View currentView)
			{
				if(gameTile.isHotbutton(6) && playerProgress !> 5)
				{
					playerCorrect();
					endTime = System.currentTimeMillis();
					calculateScore(startTime, endTime);
					updateGrid();
					updateScore();
					startTime = System.currentTimeMillis();
				}
				else
				{
					endGame();
				}
			}
		});
		tile7.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View currentView)
			{
				if(gameTile.isHotbutton(7) && playerProgress !> 5)
				{
					playerCorrect();
					endTime = System.currentTimeMillis();
					calculateScore(startTime, endTime);
					updateGrid();
					updateScore();
					startTime = System.currentTimeMillis();
				}
				else
				{
					endGame();
				}
			}
		});
		tile8.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View currentView)
			{
				if(gameTile.isHotbutton(8) && playerProgress !> 5)
				{
					playerCorrect();
					endTime = System.currentTimeMillis();
					calculateScore(startTime, endTime);
					updateGrid();
					updateScore();
					startTime = System.currentTimeMillis();
				}
				else
				{
					endGame();
				}
			}
		});
		tile9.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View currentView)
			{
				if(gameTile.isHotbutton(9) && playerProgress !> 5)
				{
					playerCorrect();
					endTime = System.currentTimeMillis();
					calculateScore(startTime, endTime);
					updateGrid();
					updateScore();
					startTime = System.currentTimeMillis();
				}
				else
				{
					endGame();
				}
			}
		});
	}
	
	
	
	private void resetGrid()
	{
		if(gameTile == null)
		{
			gameTile = new Tiles();	
		}
		else
		{
			gameTile = null;
			gameTile = new Tiles();
		}
		
	}

	private void levelGenerator()
	{
		int randomNumber = (int)Math.ceil(Math.random()*9);
		int counter = 0;
		while(counter != 6)
		{
			playerColors.add(gameTile.randomColor());
			counter++());
		}
	}

	private updateGrid(Color currentColor, int playerProgress)
	{
		int specialTile = (int) Math.ceil(Math.random() * 9);
		Color currentColor = (Color) playerColors.get(playerProgress);
		resetGrid();
		gameTile.setHotButton(specialTile);
		gridPattern = gameTile.fillGameGrid(currentColor);
		tile1.setColor(gridPattern[0]);
		tile2.setColor(gridPattern[1]);
		tile3.setColor(gridPattern[2]);
		tile4.setColor(gridPattern[3]);
		tile5.setColor(gridPattern[4]);
		tile6.setColor(gridPattern[5]);
		tile7.setColor(gridPattern[6]);
		tile8.setColor(gridPattern[7]);
		tile9.setColor(gridPattern[8]);
	}

	private void calculateScore(/*Start time*/, /*End Time*/)
	{
		int returnValue = 0;
		//SOME MATH TO DETERMINE SCORE = returnValue
		playerSCore =+ returnValue;
	}
}
