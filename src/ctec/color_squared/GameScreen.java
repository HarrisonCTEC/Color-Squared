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

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        playerColors = new ArrayList<Color>();
        playerProgress = 0;
        resetGrid();

    }
	
	private void resetGrid()
	{
		gameTile = new Tiles();
	}

	private void randomPicker()
	{
		int randomNumber = (int)Math.ceil(Math.random()*9);
		int counter = 0;
		while(counter != 6)
		{
//			if(randomNumber == 1)
//			{
//				playerColors.add(PINK);
//			}
//			else if(randomNumber == 2)
//			{
//				playerColors.add(MAGENTA);
//			}
//			else if(randomNumber == 3)
//			{
//				playerColors.add();
//			}
//			else if(randomNumber == 4)
//			{
//				playerColors.add(YELLOW);
//			}
//			else if(randomNumber == 5)
//			{
//				playerColors.add(ORANGE);
//			}
//			else if(randomNumber == 6)
//			{
//				playerColors.add(GREEN);
//			}
//			else if(randomNumber == 7)
//			{
//				playerColors.add(BLUE);
//			}
//			else if(randomNumber == 8)
//			{
//				playerColors.add(GRUE);
//			}
//			else if(randomNumber == 9)
//			{
//				playerColors.add(PURPLE;
//			}
			counter++;
		}
	}

	private int updateGrid()
	{
		int specialTile = (int) Math.ceil(Math.random() * 9);
		Color currentColor = (Color) playerColors.get(playerProgress);
		resetGrid();
        gameTile.setHotButton(specialTile);
        return specialTile;
	}
}
