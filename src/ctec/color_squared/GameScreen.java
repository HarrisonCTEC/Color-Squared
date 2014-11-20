package ctec.color_squared;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameScreen extends Activity
{
	private Button tile1, tile2, tile3, tile4, tile5, tile6, tile7, tile8, tile9;
	private ArrayList<Integer> playerColors;
	private int playerProgress;
	private Tiles gameTile;
	private int pink, magenta, red, yellow, orange, green, grue, blue, purple, reallyRed, reallyGreen; //For some reason these are ints?
	private int[] gridPattern = new int[8];
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
		reallyGreen = Color.parseColor("#00FF00");
		reallyRed = Color.parseColor("#FF0000");
		
		//TODO: INITALIZE BUTTONS
		
		playerColors = new ArrayList<Integer>();
		playerScore = 0;
		levelGenerator();
		playerProgress = 0;
		//displayPlayerColors();
		//displayPlayerProgress();
		updateGrid(0);
		setupListners();
		startTime = System.currentTimeMillis(); //By this point the player should be seeing a grid and the instructions on what to type, so the timer automatically beings
	}
    
	private void setupListners()
	{
		tile1.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View currentView)
			{
				onTilePress(1);
			}
		});
		tile2.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View currentView)
			{
				onTilePress(2);
			}
		});
		tile3.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View currentView)
			{
				onTilePress(3);	
			}
		});
		tile4.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View currentView)
			{
				onTilePress(4);
			}
		});
		tile5.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View currentView)
			{
				onTilePress(5);
			}
		});
		tile6.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View currentView)
			{
				onTilePress(6);
			}
		});
		tile7.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View currentView)
			{
				onTilePress(7);
			}
		});
		tile8.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View currentView)
			{
				onTilePress(8);
			}
		});
		tile9.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View currentView)
			{
				onTilePress(9);
			}
		});
	}

/**
 * Whenever a tile is pressed this checks to see if it is the hotButton or not as well as starting and stoping the clock,
 * If the player clicks a tile and it is not the hotbutton or there are no more instructions left, the game is over
 * @param tileNumber the tile that is being pressed
 */
	private void onTilePress(int tileNumber)
	{
		if(gameTile.isHotButton(tileNumber) && (playerProgress <= 5)) //If the player taped the special button and they are not done with the instructions,
		{
			endTime = System.currentTimeMillis();
			calculateScore(startTime, endTime);
			playerProgress++;
			updateGrid(playerProgress);
			//updateScore();
			startTime = System.currentTimeMillis();
		}
		else
		{
				endGame();
		}
	}
	
/**
 * Destroyes the Tiles object than recreates it, this insures a clean playing gird
 */
	private void resetGrid()
	{
		if(gameTile == null) //If tiles is a tiles shaped hole in the universe, or if it has not been created yet, make it
		{
			gameTile = new Tiles();	
		}
		else //But if it aldready exits, destroy it and make a new one
		{
			gameTile = null;
			gameTile = new Tiles();
		}
		
	}

/**
 * Creates the players instructions on what to tap
 */
	private void levelGenerator()
	{
		int counter = 0; //This is the escape route out of the while loop
		while(counter != 6) // Do six times
		{
			playerColors.add(gameTile.randomColor()); //Add the the Array List playColors 6 random Colors
			counter++; //Take counter and add 1
		}
	}

/**
 * Randomly assings colors hotButton, hotColor, and all other tile colors than sets the tiles to those colors
 * @param whereIsPlay the index in the Array List of playerProgress
 */
	private void updateGrid(int whereIsPlayer) //I'm eating cake right now at 2:35 AM ... it tastes good!
	{
		int specialTile = (int) Math.ceil(Math.random() * 9); //Generate a random number between one and nine and name it specialTile
		int currentColor = playerColors.get(whereIsPlayer); //From the instructions, based on the index gett from that list the stored Color and name it currentColor
		resetGrid(); //Destroy the grid and make a new one
		gameTile.setHotButton(specialTile); //Tell the new one what tile is special
		gridPattern = gameTile.fillGameGrid(currentColor); //Have the Tiles class generate an Array of Colors that will be the layout of tile colors
//		tile1.setColor(gridPattern[0]); //Set the colors of the tiles
//		tile2.setColor(gridPattern[1]);
//		tile3.setColor(gridPattern[2]);
//		tile4.setColor(gridPattern[3]);
//		tile5.setColor(gridPattern[4]);
//		tile6.setColor(gridPattern[5]);
//		tile7.setColor(gridPattern[6]);
//		tile8.setColor(gridPattern[7]);
//		tile9.setColor(gridPattern[8]);
	}

	private void calculateScore(long timeIn, long timeOut)
	{
		int returnValue = 0;
		long timeInterval = (endTime - startTime);
		//SOME MATH TO DETERMINE SCORE = returnValue
		playerScore += returnValue; //MUST BE AN INTERGER!
	}
	
	/**
	 * Opens up the final activity and passes the players score there
	 */
	private void endGame()
	{
		//TODO
	}
}
