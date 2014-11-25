package ctec.color_squared;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Main mode Color Squared
 * @author Mark Shamy
 * @debugger Nickolas Komarnitsky
 * @version 1.02 11/25/14 (c) Orange Lightning Research 2014
 */
public class GameScreen extends Activity
{
	public int pink, magenta, red, yellow, orange, green, grue, blue, purple, reallyRed, reallyGreen, black;
	private Button tile1, tile2, tile3, tile4, tile5, tile6, tile7, tile8, tile9;	
	private Button color1, color2, color3, color4, color5, color6;
	private int[] gameColors = {pink, magenta, red, yellow, orange, green, grue, blue, purple};
	private int hotButton, hotColor;
	private ArrayList<Integer> playerColors, gameGrid, notUsedColors;
	private int playerScore, level, playerProgress;
	private TextView scoreDisplay;
	private TextView levelDisplay;
//	private int timeBasedScore;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game_screen);
		
		level = 1; playerScore = 0; playerProgress = 0;
		hotButton = 0; hotColor = 0;
		
		notUsedColors = new ArrayList<Integer>();
		playerColors = new ArrayList<Integer>();
		gameGrid = new ArrayList<Integer>();
		
		pink = 14721216; magenta = 14696576; red = 14696512;
        yellow = 12615680; orange = 14704704; green = 12640256;
        grue = 242131072; blue = 234922176; purple = 6324416;
        reallyGreen = 65280; reallyRed = 16711680; black = 728102;
        
        
		color1 = (Button) findViewById(R.id.Color1); color2 = (Button) findViewById(R.id.Color2);
		color3 = (Button) findViewById(R.id.Color3); color4 = (Button) findViewById(R.id.Color4);
		color5 = (Button) findViewById(R.id.Color5); color6 = (Button) findViewById(R.id.Color6);
		
		tile1 = (Button)findViewById(R.id.tile1); tile2 = (Button)findViewById(R.id.tile2);
		tile3 = (Button)findViewById(R.id.tile3); tile4 = (Button)findViewById(R.id.tile4);
		tile5 = (Button)findViewById(R.id.tile5); tile6 = (Button)findViewById(R.id.tile6);
		tile7 = (Button)findViewById(R.id.tile7); tile8 = (Button)findViewById(R.id.tile8);
		tile9 = (Button)findViewById(R.id.tile9);
		
		notUsedColors.add(pink); notUsedColors.add(magenta); notUsedColors.add(red);
		notUsedColors.add(yellow); notUsedColors.add(orange);notUsedColors.add(green);
		notUsedColors.add(grue); notUsedColors.add(blue); notUsedColors.add(purple);
		
		scoreDisplay = (TextView)findViewById(R.id.scoreDisplay);
		levelDisplay = (TextView)findViewById(R.id.levelDisplay); //REMEMBER TO PUT THIS IN THE LAYOUT STUPID!!!!!
		setupListners();
		levelGenerator();
		updateGameGrid();
		
		
	}
	
	private void setupListners()
	{
		tile1.setOnClickListener(new View.OnClickListener(){public void onClick(View currentView){onTilePress(1);}});
		tile2.setOnClickListener(new View.OnClickListener(){public void onClick(View currentView){onTilePress(2);}});
		tile3.setOnClickListener(new View.OnClickListener(){public void onClick(View currentView){onTilePress(3);}});
		tile4.setOnClickListener(new View.OnClickListener(){public void onClick(View currentView){onTilePress(4);}});
		tile5.setOnClickListener(new View.OnClickListener(){public void onClick(View currentView){onTilePress(5);}});
		tile6.setOnClickListener(new View.OnClickListener(){public void onClick(View currentView){onTilePress(6);}});
		tile7.setOnClickListener(new View.OnClickListener(){public void onClick(View currentView){onTilePress(7);}});
		tile8.setOnClickListener(new View.OnClickListener(){public void onClick(View currentView){onTilePress(8);}});
		tile9.setOnClickListener(new View.OnClickListener(){public void onClick(View currentView){onTilePress(9);}});
	}
	
	private void levelGenerator()
	{
		while(playerColors.size() != 6)
		{
			playerColors.add(pickRandomItem());
		}
		
		color1.setBackgroundColor(playerColors.get(0)); color2.setBackgroundColor(playerColors.get(1));
		color3.setBackgroundColor(playerColors.get(2)); color4.setBackgroundColor(playerColors.get(3));
		color5.setBackgroundColor(playerColors.get(4)); color6.setBackgroundColor(playerColors.get(5));
	}
	
	private int pickRandomItem()
	{
		int special = (int)Math.ceil(Math.random() * notUsedColors.size());
		return gameColors[special];
	}

	private void updateGameGrid()
	{
		int special = (int)Math.ceil(Math.random() * 9);
		int currentColor = playerColors.get(playerProgress);
		
		hotButton = special; hotColor = currentColor;
		
		notUsedColors.remove(hotColor);
		fillGameGridList();
		
		tile1.setBackgroundColor(gameGrid.get(0)); tile1.setBackgroundColor(gameGrid.get(1)); tile1.setBackgroundColor(gameGrid.get(2));
		tile1.setBackgroundColor(gameGrid.get(3)); tile1.setBackgroundColor(gameGrid.get(4)); tile1.setBackgroundColor(gameGrid.get(5));
		tile1.setBackgroundColor(gameGrid.get(6)); tile1.setBackgroundColor(gameGrid.get(7)); tile1.setBackgroundColor(gameGrid.get(8));
	}
	
	private void fillGameGridList()
	{
		for(Integer color:gameColors)
		{
			if(color != hotColor)
			{
				gameGrid.add(color);
				notUsedColors.remove(color);
			}
			else if(color == hotColor)
			{
				gameGrid.add(color);
			}
		}
	}

	private void resetGrid()
	{
		fillNotUsedColors();
		gameGrid.clear();
		hotColor = 0;
	}
	
	private void onTilePress(int tileNumber)
	{
		//Stop clocks
		if((tileNumber == hotButton) && (playerProgress != 6))
		{
			updateBoxes(playerProgress);
			playerProgress += 1;
			updateAndDisplayScore();
			updateGameGrid();
			//Play click sound
		}
		else if((tileNumber == hotButton) && (playerProgress == 6))
		{
			nextLevel();
		}
	}
	
	private void updateBoxes(int playerProg)
	{
		if(playerProg == 1){color1.setBackgroundColor(black);}
		else if(playerProg == 2){color2.setBackgroundColor(black);}
		else if(playerProg == 3){color3.setBackgroundColor(black);}
		else if(playerProg == 4){color4.setBackgroundColor(black);}
		else if(playerProg == 5){color5.setBackgroundColor(black);}
	}
	
	private void updateAndDisplayScore(){scoreDisplay.setText("Score: " + playerScore);}
	
	private void nextLevel()
	{
		playerProgress += 1;
		playerColors.clear();
		levelGenerator();
		updateGameGrid();
		level += 1;
		levelDisplay.setText("Level: " + level);
		updateAndDisplayScore();
		// TODO PUT SOUND HERE
	}
	
	private void endGame()
	{
		//Play Bad sound
		//Vibrate 500 mili
		Intent passScore = new Intent(GameScreen.this, GameOver.class);
		startActivityForResult(passScore, playerScore);
	}
	
	private void fillNotUsedColors()
	{
		notUsedColors.add(pink); notUsedColors.add(magenta); notUsedColors.add(red);
		notUsedColors.add(yellow); notUsedColors.add(orange);notUsedColors.add(green);
		notUsedColors.add(grue); notUsedColors.add(blue); notUsedColors.add(purple);		
	}
}

