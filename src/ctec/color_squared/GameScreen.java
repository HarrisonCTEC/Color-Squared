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
	private List<Color> playerColors;
	private int playerProgress;
	private Tiles gameTile;
	private Color pink, magenta, red, yellow, orange, green, grue, purple;
	private Color[] gridPattern = new Color[8];

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
     

        playerColors = new ArrayList<Color>();
        levelGenerator();
        playerProgress = 0;
        displayPlayerColors();
        resetGrid();
        displayGrid();

    }
	
	private void resetGrid()
	{
		gameTile = new Tiles();
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
	}

	private int calculateScore()
}
