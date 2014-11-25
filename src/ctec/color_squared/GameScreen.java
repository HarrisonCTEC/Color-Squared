package ctec.color_squared;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class GameScreen extends Activity
{
	private Button tile1, tile2, tile3, tile4, tile5, tile6, tile7, tile8, tile9;
	private GameState state;
	private TextView scoreDisplay;
	private int [] colorOrder;
	private TextView timerDisplay;

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
		timerDisplay = (TextView)findViewById(R.id.timerDisplay);
		
		colorOrder = new int [6];
		colorOrder[0] = getResources().getColor(R.color.solRed);
		colorOrder[1] = getResources().getColor(R.color.solOrange);
		colorOrder[2] = getResources().getColor(R.color.solYellow);
		colorOrder[3] = getResources().getColor(R.color.solGreen);
		colorOrder[4] = getResources().getColor(R.color.solBlue);
		colorOrder[5] = getResources().getColor(R.color.solViolet);
		
		setupListners();
		
		state = new GameState();

		
		Thread timer = new Thread()
		{
			@Override
			public void run() {
				double time = 5;
				while (time != 0)
				{
					if (Double.toString(time).substring(0, 3).equals("0.1"))
					{
						time = 0;
					}
					else
					{
						time = time - 0.1;
					}
					final String stringTime;
					if (time == 0)
					{
						stringTime = "0";
					}
					else
					{
						stringTime = Double.toString(time).substring(0, 3);
					}
					System.out.println(stringTime);
					runOnUiThread(updateTimer(stringTime));
					
					SystemClock.sleep(100);
				}
				
			};
		};
		timer.start();
		
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
	 * Checks if tile pressed was correct
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
	
	/**
	 * Increases score by one
	 */
	private void inscreaseScore()
	{
		state.increaseScore();
		scoreDisplay.setText("Score: " + new Integer(state.getScore()).toString());
	}
	
	/**
	 * Updates the timer display
	 * @param stringTime The string to display
	 * @return
	 */
	private Runnable updateTimer(final String stringTime)
	{
		Runnable updateTimer = new Runnable()
			{
				@Override
				public void run()
				{
					timerDisplay.setText(stringTime);
				}
			};
		return updateTimer;
					
	}
	
}
