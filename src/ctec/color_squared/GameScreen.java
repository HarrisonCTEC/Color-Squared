package ctec.color_squared;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Main mode Color Squared
 * 
 * @author Mark Shamy
 * @author Nickolas Komarnitsky
 * @version 1.03 11/25/14 (c) Orange Lightning Research 2014
 */
public class GameScreen extends Activity {
	public int pink, magenta, red, yellow, orange, green, grue, blue, purple, reallyRed, reallyGreen, black;
	private Button[] tile = new Button[9];
	private Button color1, color2, color3, color4, color5, color6;
	private int[] gameColors = new int[9];
	private int hotButton, hotColor;
	private ArrayList<Integer> playerColors, gameGrid, notUsedColors;
	private int playerScore, level, playerProgress;
	private TextView scoreDisplay;
	private TextView levelDisplay;
	private MediaPlayer fail;
	private MediaPlayer levelUp;
	private MediaPlayer buttonClick;
	private Vibrator bad;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game_screen);

		level = 1;
		playerScore = 0;
		playerProgress = 0;
		hotButton = 0;
		hotColor = 0;

		notUsedColors = new ArrayList<Integer>();
		playerColors = new ArrayList<Integer>();
		gameGrid = new ArrayList<Integer>();

		red = Color.rgb(255, 0, 0);
		pink = Color.rgb(255, 105, 180);
		magenta = Color.rgb(255, 0, 255);
		yellow = Color.rgb(255, 255, 0);
		orange = Color.rgb(255, 165, 0);
		green = Color.rgb(0, 128, 0);
		grue = Color.rgb(0, 96, 76);
		blue = Color.rgb(0, 0, 255);
		purple = Color.rgb(128, 0, 128);

		gameColors[0] = pink;
		gameColors[1] = magenta;
		gameColors[2] = red;
		gameColors[3] = yellow;
		gameColors[4] = orange;
		gameColors[5] = green;
		gameColors[6] = grue;
		gameColors[7] = blue;
		gameColors[8] = purple;

		color1 = (Button) findViewById(R.id.Color1);
		color2 = (Button) findViewById(R.id.Color2);
		color3 = (Button) findViewById(R.id.Color3);
		color4 = (Button) findViewById(R.id.Color4);
		color5 = (Button) findViewById(R.id.Color5);
		color6 = (Button) findViewById(R.id.Color6);

		tile[0] = (Button) findViewById(R.id.tile1);
		tile[1] = (Button) findViewById(R.id.tile2);
		tile[2] = (Button) findViewById(R.id.tile3);
		tile[3] = (Button) findViewById(R.id.tile4);
		tile[4] = (Button) findViewById(R.id.tile5);
		tile[5] = (Button) findViewById(R.id.tile6);
		tile[6] = (Button) findViewById(R.id.tile7);
		tile[7] = (Button) findViewById(R.id.tile8);
		tile[8] = (Button) findViewById(R.id.tile9);

		notUsedColors.add(pink);
		notUsedColors.add(magenta);
		notUsedColors.add(red);
		notUsedColors.add(yellow);
		notUsedColors.add(orange);
		notUsedColors.add(green);
		notUsedColors.add(grue);
		notUsedColors.add(blue);
		notUsedColors.add(purple);
		
		fail =  MediaPlayer.create(this, R.raw.fail);
		levelUp = MediaPlayer.create(this, R.raw.levelup);
		buttonClick = MediaPlayer.create(this, R.raw.click);
		
		Vibrator bad = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		
		scoreDisplay = (TextView) findViewById(R.id.scoreDisplay);
		levelDisplay = (TextView) findViewById(R.id.levelDisplay);
		
		setupListners();
		levelGenerator();
		//updateGameGrid();
	}

	private void setupListners() 
	{
			tile[0].setOnClickListener(new View.OnClickListener() {public void onClick(View currentView) {onTilePress(1);}});
			tile[1].setOnClickListener(new View.OnClickListener() {public void onClick(View currentView) {onTilePress(2);}});
			tile[2].setOnClickListener(new View.OnClickListener() {public void onClick(View currentView) {onTilePress(3);}});
			tile[3].setOnClickListener(new View.OnClickListener() {public void onClick(View currentView) {onTilePress(4);}});
			tile[4].setOnClickListener(new View.OnClickListener() {public void onClick(View currentView) {onTilePress(5);}});
			tile[5].setOnClickListener(new View.OnClickListener() {public void onClick(View currentView) {onTilePress(6);}});
			tile[6].setOnClickListener(new View.OnClickListener() {public void onClick(View currentView) {onTilePress(7);}});
			tile[7].setOnClickListener(new View.OnClickListener() {public void onClick(View currentView) {onTilePress(8);}});
			tile[8].setOnClickListener(new View.OnClickListener() {public void onClick(View currentView) {onTilePress(9);}});
	}

	private void levelGenerator() 
	{
		int randomIndex = (int) Math.ceil(Math.random() * 9);
		
		while (playerColors.size() != 6) 
		{
			playerColors.add(gameColors[randomIndex]);
		}
		
		color1.setBackgroundColor(playerColors.get(0));
		color2.setBackgroundColor(playerColors.get(1));
		color3.setBackgroundColor(playerColors.get(2));
		color4.setBackgroundColor(playerColors.get(3));
		color5.setBackgroundColor(playerColors.get(4));
		color6.setBackgroundColor(playerColors.get(5));
	}

	private void updateGameGrid() 
	{
		int randomTile = (int) Math.ceil(Math.random() * 9);
		int currentColor = playerColors.get(playerProgress);
		
		//Sets hot button and color
		hotButton = randomTile;
		hotColor = currentColor;
		
		fillGameGridList();

		tile[0].setBackgroundColor(gameGrid.get(0));
		tile[1].setBackgroundColor(gameGrid.get(1));
		tile[2].setBackgroundColor(gameGrid.get(2));
		tile[3].setBackgroundColor(gameGrid.get(3));
		tile[4].setBackgroundColor(gameGrid.get(4));
		tile[5].setBackgroundColor(gameGrid.get(5));
		tile[6].setBackgroundColor(gameGrid.get(6));
		tile[7].setBackgroundColor(gameGrid.get(7));
		tile[8].setBackgroundColor(gameGrid.get(8));
	}

	private void fillGameGridList() 
	{
		int counter = 0;
		while (counter != 8)
		{
			if (gameColors[counter] != hotColor) 
			{
				gameGrid.add(gameColors[counter]);
				notUsedColors.remove(gameColors[counter]);
			}
			else if (gameColors[0] == hotColor) 
			{
				gameGrid.add(gameColors[counter]);
			}
		}
		
		//Down below, this is supposed to take the hotColor out of the list and put it back in at the
		//correct index, according to the hotButton number.
		int color = hotColor;
		int index = gameGrid.indexOf(hotColor);
		int newIndex = hotButton;
		
		gameGrid.remove(index);
		gameGrid.add(newIndex, color);
	}

	private void resetGrid() 
	{
		notUsedColors.clear(); //Fail safe
		fillNotUsedColors();
		gameGrid.clear();
		hotColor = 0;
		hotButton = 0;
	}

	private void onTilePress(int tileNumber) 
	{
		//Stop clocks
		if ((tileNumber == hotButton) && (playerProgress != 5)) 
		{
			updateBoxes(playerProgress);
			playerProgress += 1;
			updateAndDisplayScore();
			updateGameGrid();
			buttonClick.start();
		}
		else if ((tileNumber == hotButton) && (playerProgress == 5))
		{
			
			//Makes new level
			playerProgress += 1;
			playerColors.clear();
			levelGenerator();
			updateGameGrid();
			levelDisplay.setText("Level: " + level);
			updateAndDisplayScore();
			levelUp.start(); //Sound
		}
		else
		{
			fail.start(); //Sound
			bad.vibrate(500);
			endGame();
		}
	}

	private void updateBoxes(int playerProg) 
	{
		if      (playerProg == 1) {color1.setBackgroundColor(black);}
		else if (playerProg == 2) {color2.setBackgroundColor(black);}
		else if (playerProg == 3) {color3.setBackgroundColor(black);}
		else if (playerProg == 4) {color4.setBackgroundColor(black);}
		else if (playerProg == 5) {color5.setBackgroundColor(black);}
	}

	private void updateAndDisplayScore() 
	{
		scoreDisplay.setText("Score: " + playerScore);
	}

	private void endGame() 
	{
		//Vibrate 500 milliseconds
		Intent passScore = new Intent(GameScreen.this, GameOver.class);
		startActivityForResult(passScore, playerScore);
	}

	private void fillNotUsedColors() 
	{
		notUsedColors.add(pink);
		notUsedColors.add(magenta);
		notUsedColors.add(red);
		notUsedColors.add(yellow);
		notUsedColors.add(orange);
		notUsedColors.add(green);
		notUsedColors.add(grue);
		notUsedColors.add(blue);
		notUsedColors.add(purple);
	}
}
