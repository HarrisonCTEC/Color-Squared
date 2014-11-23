package ctec.color_squared;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

/**
 * Game screen
 * 
 * 
 * @author Harrison H, Mark S
 * @version 1.0 11/20/14 ©2014 Orange Lightning Research
 * 
 * @author Mark Shamy
 * @version 1.0 11/20/14 ©2014 Orange Lightning Research
 * 
 * @author Nickolas Koamrnitsky
 * @version 1.0 11/20/14 ©2014 Orange Lightning Research
 */
public class GameScreen extends Activity {
	private Button tile1, tile2, tile3, tile4, tile5, tile6, tile7, tile8, tile9;
	private Button[] color = new Button[6];
	private ArrayList<Integer> playerColors;
	private int playerProgress;
	private Tiles gameTile;
	// private int pink, magenta, red, yellow, orange, green, grue, blue,
	// purple;
	private int reallyRed, reallyGreen; // For some reason these are ints?
	private int[] gridPattern = new int[8];
	private int playerScore;
	private TextView scoreDisplay;
	private TableLayout gamescreenlayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game_screen);

		tile1 = (Button) findViewById(R.id.tile1);
		tile2 = (Button) findViewById(R.id.tile2);
		tile3 = (Button) findViewById(R.id.tile3);
		tile4 = (Button) findViewById(R.id.tile4);
		tile5 = (Button) findViewById(R.id.tile5);
		tile6 = (Button) findViewById(R.id.tile6);
		tile7 = (Button) findViewById(R.id.tile7);
		tile8 = (Button) findViewById(R.id.tile8);
		tile9 = (Button) findViewById(R.id.tile9);
		color[0] = (Button) findViewById(R.id.Color1);
		color[1] = (Button) findViewById(R.id.Color2);
		color[2] = (Button) findViewById(R.id.Color3);
		color[3] = (Button) findViewById(R.id.Color4);
		color[4] = (Button) findViewById(R.id.Color5);
		color[5] = (Button) findViewById(R.id.Color6);
		scoreDisplay = (TextView) findViewById(R.id.scoreDisplay);
		gamescreenlayout = (TableLayout) findViewById(R.id.GameScreenLayout);
		// TODO Make and initalize other buttons menuButton

		/*tile1.setScaleX(gamescreenlayout.getWidth()/2);
		tile1.setScaleY(gamescreenlayout.getHeight()/2);
		tile2.setScaleX(gamescreenlayout.getWidth()/2);
		tile2.setScaleY(gamescreenlayout.getHeight()/2);
		tile3.setScaleX(gamescreenlayout.getWidth()/2);
		tile3.setScaleY(gamescreenlayout.getHeight()/2);
		tile4.setScaleX(gamescreenlayout.getWidth()/2);
		tile4.setScaleY(gamescreenlayout.getHeight()/2);
		tile5.setScaleX(gamescreenlayout.getWidth()/2);
		tile5.setScaleY(gamescreenlayout.getHeight()/2);
		tile6.setScaleX(gamescreenlayout.getWidth()/2);
		tile6.setScaleY(gamescreenlayout.getHeight()/2);
		tile7.setScaleX(gamescreenlayout.getWidth()/2);
		tile7.setScaleY(gamescreenlayout.getHeight()/2);
		tile8.setScaleX(gamescreenlayout.getWidth()/2);
		tile8.setScaleY(gamescreenlayout.getHeight()/2);
		tile9.setScaleX(gamescreenlayout.getWidth()/2);
		tile9.setScaleY(gamescreenlayout.getHeight()/2);*/

		/*
		 * playerColors = new ArrayList<Integer>(); playerScore = 0;
		 * levelGenerator(); playerProgress = 0; displayPlayerColors();
		 * updatePlayerProgress(); updateGrid(0); setupListners(); startTime =
		 * System.currentTimeMillis(); // By this point the player // should be
		 * seeing a grid and // the instructions on what to // type, so the
		 * timer // automatically beings
		 * 
		 * // pink = gameTile.getPink(); // magenta = gameTile.getMagenta(); //
		 * red = gameTile.getRed(); // yellow = gameTile.getYellow(); // orange
		 * = gameTile.getOrange(); // green = gameTile.getGreen(); // grue =
		 * gameTile.getGrue(); // blue = gameTile.getBlue(); // purple =
		 * gameTile.getPurple(); reallyGreen = Color.parseColor("#00FF00");
		 * reallyRed = Color.parseColor("#FF0000");
		 */
		//TODO Make and initialize other buttons menuButton

		playerColors = new ArrayList<Integer>();
		playerScore = 0;
		scoreDisplay.setText("Score: " + playerScore);
		levelGenerator();
		playerProgress = 0;
		displayPlayerColors();
		updatePlayerProgress();
		//updateGrid1(0);
		setupListners();

	}

	private void setupListners() {
		tile1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View currentView) {
				onTilePress(1);
			}
		});
		tile2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View currentView) {
				onTilePress(2);
			}
		});
		tile3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View currentView) {
				onTilePress(3);
			}
		});
		tile4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View currentView) {
				onTilePress(4);
			}
		});
		tile5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View currentView) {
				onTilePress(5);
			}
		});
		tile6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View currentView) {
				onTilePress(6);
			}
		});
		tile7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View currentView) {
				onTilePress(7);
			}
		});
		tile8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View currentView) {
				onTilePress(8);
			}
		});
		tile9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View currentView) {
				onTilePress(9);
			}
		});
	}
	

	/**
	 * Whenever a tile is pressed this checks to see if it is the hotButton or not as well as starting and stoping the clock, If the player clicks a tile and it is not the hotbutton or there are no more instructions left, the game is over
	 * 
	 * @param tileNumber
	 *            the tile that is being pressed
	 */
	private void onTilePress(int tileNumber) {
		if (gameTile.isHotButton(tileNumber) && (playerProgress <= 5)) // If the player taped the special button and they are not done with the instructions,
		{
			playerScore++;
			updatePlayerProgress();
			//updateGrid1(playerProgress);
		}
		else {
			endGame();
		}
	}

	/**
	 * Destroyes the Tiles object than recreates it, this insures a clean playing gird
	 */
	private void resetGrid(int tileNumber) {
		if (gameTile == null) // If tiles is a tiles shaped hole in the universe, or if it has not been created yet,make it
		{
			gameTile = new Tiles();
		}
		else if (gameTile.isHotButton(tileNumber) && (playerProgress == 6)) {
			playerScore++;
			updatePlayerProgress();
			updateGrid1(playerProgress);
			nextLevel();
		}
		else

		{
			endGame();
		}

	}

	/**
	 * Creates the players instructions on what to tap
	 */
	private void levelGenerator() {
		int counter = 0;
		int x = 0;
		while (counter != 6) {
			Tiles.randomColor();
			color[x].setBackgroundColor(gameTile.randomColor);
			x++;
			counter++;
		}

	}

	/**
	 * Randomly assings colors hotButton, hotColor, and all other tile colors than sets the tiles to those colors
	 * 
	 * @param whereIsPlay
	 *            the index in the Array List of playerProgress
	 */
	private void updateGrid1(int whereIsPlayer) // I'm eating cake right now at
												// 2:35 AM ... it tastes good!
	{
		int specialTile = (int) Math.ceil(Math.random() * 9); // Generate a random number between one and nine and name it specialTile
		int currentColor = playerColors.get(whereIsPlayer); // From the instructions, based on the index get from that list the stored Color and name it currentColor
		resetGrid(1); // Destroy the grid and make a new one
		gameTile.setHotButton(specialTile); // Tell the new one what tile is
											// special
		gridPattern = gameTile.fillGameGrid(currentColor); // Have the Tiles class generate an Array of Colors that will be the layout of tile colors
		tile1.setBackgroundColor(gridPattern[0]); // Set the colors of the tiles
	}

	/**
	 * Randomly assings colors hotButton, hotColor, and all other tile colors than sets the tiles to those colors
	 * 
	 * @param whereIsPlayer
	 *            the index in the Array List of playerProgress
	 */
	private void updateGrid(int whereIsPlayer) //I'm eating cake right now at 2:35 AM ... it tastes good!
	{
		int specialTile = (int) Math.ceil(Math.random() * 9); //Generate a random number between one and nine and name it specialTile
		int currentColor = playerColors.get(whereIsPlayer); //From the instructions, based on the index get from that list the stored Color and name it currentColor
		gameTile.resetGrid(); //Destroy the grid and make a new one
		gameTile.setHotButton(specialTile); //Tell the new one what tile is special
		gridPattern = gameTile.fillGameGrid(currentColor); //Have the Tiles class generate an Array of Colors that will be the layout of tile colors
		tile1.setBackgroundColor(gridPattern[0]); //Set the colors of the tiles

		tile2.setBackgroundColor(gridPattern[1]);
		tile3.setBackgroundColor(gridPattern[2]);
		tile4.setBackgroundColor(gridPattern[3]);
		tile5.setBackgroundColor(gridPattern[4]);
		tile6.setBackgroundColor(gridPattern[5]);
		tile7.setBackgroundColor(gridPattern[6]);
		tile8.setBackgroundColor(gridPattern[7]);
		tile9.setBackgroundColor(gridPattern[8]);
	}

	private void updateScore(long timeIn, long timeOut) {
		int returnValue = 0;
		// SOME MATH TO DETERMINE SCORE = returnValue TODO
		playerScore += returnValue; // MUST BE AN INTERGER!
		scoreDisplay.setText(playerScore);
	}

	/**
	 * Opens up the final activity and passes the players score there
	 */
	private void endGame() {
		// TODO
		System.exit(0);
	}

	/**
	 * Fills the instruction box with the playColors list
	 */
	private void displayPlayerColors() {
		// TODO
	}

	/**
	 * Changes the color of the outline of the boxes of the instructions from red to green when the player progreses
	 */
	private void updatePlayerProgress() {
		// TODO
	}

	private void nextLevel() {
		playerProgress = 0;
		levelGenerator();
		gameTile.resetGrid();
	}
}
