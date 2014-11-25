package ctec.color_squared;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Game screen
 * @author Mark Shamy
 * @version 1.0 11/20/14
 * ©2014 Orange Lightning Research
 */
public class GameScreen extends Activity
{
	private Button tile1, tile2, tile3, tile4, tile5, tile6, tile7, tile8, tile9;
	private ArrayList<Integer> playerColors;
	private int playerProgress;
	private GameState state;
	//private int pink, magenta, red, yellow, orange, green, grue, blue, purple;
	private int reallyRed, reallyGreen; //For some reason these are ints?
	private int[] gridPattern = new int[8];
	private int playerScore;
	private TextView scoreDisplay;
	private int [] colorOrder;
	private int score;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game_screen);
		
		tile1 = (Button)findViewById(R.id.tile1);
		tile2 = (Button)findViewById(R.id.tile2);
		tile3 = (Button)findViewById(R.id.tile3);
		tile4 = (Button)findViewById(R.id.tile4);
		tile5 = (Button)findViewById(R.id.tile5);
		tile6 = (Button)findViewById(R.id.tile6);
		tile7 = (Button)findViewById(R.id.tile7);
		tile8 = (Button)findViewById(R.id.tile8);
		tile9 = (Button)findViewById(R.id.tile9);
		scoreDisplay = (TextView)findViewById(R.id.scoreDisplay);
		scoreDisplay.setText("");
		//TODO Make and initalize other buttons menuButton
		
		colorOrder = new int [6];
		colorOrder[0] = getResources().getColor(R.color.solRed);
		colorOrder[1] = getResources().getColor(R.color.solOrange);
		colorOrder[2] = getResources().getColor(R.color.solYellow);
		colorOrder[3] = getResources().getColor(R.color.solGreen);
		colorOrder[4] = getResources().getColor(R.color.solBlue);
		colorOrder[5] = getResources().getColor(R.color.solViolet);
		
		setupListners();
		
		playerColors = new ArrayList<Integer>();
		playerProgress = 0;
		state = new GameState();
		
		genTurn();
	}
	
	private void genTurn()
	{
		int hotButton = (int)(Math.random() * 8) + 1;
		state.setHotButton(hotButton);
		int ignoreColor = (int)(state.getScore() % 6);
		randomizeGrid(ignoreColor, hotButton);
	}
	
	private void randomizeGrid(int ignoreColor, int hotButton)
	{
		tile1.setBackgroundColor(genIgnoreColor(ignoreColor));
		tile2.setBackgroundColor(genIgnoreColor(ignoreColor));
		tile3.setBackgroundColor(genIgnoreColor(ignoreColor));
		tile4.setBackgroundColor(genIgnoreColor(ignoreColor));
		tile5.setBackgroundColor(genIgnoreColor(ignoreColor));
		tile6.setBackgroundColor(genIgnoreColor(ignoreColor));
		tile7.setBackgroundColor(genIgnoreColor(ignoreColor));
		tile8.setBackgroundColor(genIgnoreColor(ignoreColor));
		tile9.setBackgroundColor(genIgnoreColor(ignoreColor));
		switch (hotButton)
		{
		case 1:
			tile1.setBackgroundColor(colorOrder[ignoreColor]);
			break;
		case 2:
			tile2.setBackgroundColor(colorOrder[ignoreColor]);
			break;
		case 3:
			tile3.setBackgroundColor(colorOrder[ignoreColor]);
			break;
		case 4:
			tile4.setBackgroundColor(colorOrder[ignoreColor]);
			break;
		case 5:
			tile5.setBackgroundColor(colorOrder[ignoreColor]);
			break;
		case 6:
			tile6.setBackgroundColor(colorOrder[ignoreColor]);
			break;
		case 7:
			tile7.setBackgroundColor(colorOrder[ignoreColor]);
			break;
		case 8:
			tile8.setBackgroundColor(colorOrder[ignoreColor]);
			break;
		case 9:
			tile9.setBackgroundColor(colorOrder[ignoreColor]);
			break;
		}
	}
	
	private int genIgnoreColor(int ignore)
	{
		ArrayList<Integer> colors = new ArrayList<Integer>();
		for(int i = 0; i < colorOrder.length; i++)
			if (i != ignore)
			{
				colors.add(colorOrder[i]);
			}
		int rand = (int)(Math.random() * 5);
		return colors.get(rand);
		
	}
    
	private void setupListners()
	{
		OnClickListener tileListener = new View.OnClickListener()
		{
			@Override
			public void onClick(View currentView)
			{
				int tilePressed = 0;
				
				switch (currentView.getId())
				{
				case R.id.tile1:
					tilePressed = 1;
					break;
				case R.id.tile2:
					tilePressed = 2;
					break;
				case R.id.tile3:
					tilePressed = 3;
					break;
				case R.id.tile4:
					tilePressed = 4;
					break;
				case R.id.tile5:
					tilePressed = 5;
					break;
				case R.id.tile6:
					tilePressed = 6;
					break;
				case R.id.tile7:
					tilePressed = 7;
					break;
				case R.id.tile8:
					tilePressed = 8;
					break;
				case R.id.tile9:
					tilePressed = 9;
					break;
				}
				onTilePress(tilePressed);
			}
		};
		
		tile1.setOnClickListener(tileListener);
		tile2.setOnClickListener(tileListener);
		tile3.setOnClickListener(tileListener);
		tile4.setOnClickListener(tileListener);
		tile5.setOnClickListener(tileListener);
		tile6.setOnClickListener(tileListener);
		tile7.setOnClickListener(tileListener);
		tile8.setOnClickListener(tileListener);
		tile9.setOnClickListener(tileListener);
	}

/**
 * Whenever a tile is pressed this checks to see if it is the hotButton or not as well as starting and stoping the clock,
 * If the player clicks a tile and it is not the hotbutton or there are no more instructions left, the game is over
 * @param tileNumber the tile that is being pressed
 */
	private void onTilePress(int tileNumber)
	{
		if(state.getHotButton() == tileNumber)
		{
			inscreaseScore();
		}
		else
		{
				endGame();
		}
		genTurn();
	}
	
	/**
	 * Opens up the final activity and passes the players score there
	 */
	private void endGame()
	{
		Intent transferIntent = new Intent(getBaseContext(), GameOver.class);
		startActivityForResult(transferIntent, 0);
	}
	
	private void inscreaseScore()
	{
		state.increaseScore();
		scoreDisplay.setText("Score: " + new Integer(state.getScore()).toString());
	}
}
