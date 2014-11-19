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
		int returnTile = 0;
		if (specialTile == 1)
		{
			gameTile.setOneHotButton(true);
			gameTile.setOneColor(currentColor);
			returnTile = 1;
		}
		else if (specialTile == 2)
		{
			gameTile.setTwoHotButton(true);
			gameTile.setOneColor(currentColor);
			returnTile = 2;
		}
		else if (specialTile == 3)
		{
			gameTile.setThreeHotButton(true);
			gameTile.setOneColor(currentColor);
			returnTile = 3;
		}
		else if (specialTile == 4)
		{
			gameTile.setFourHotButton(true);
			gameTile.setOneColor(currentColor);
			returnTile = 4;
		}
		else if (specialTile == 5)
		{
			gameTile.setFiveHotButton(true);
			gameTile.setOneColor(currentColor);
			returnTile = 5;
		}
		else if (specialTile == 6)
		{
			gameTile.setSixHotButton(true);
			gameTile.setOneColor(currentColor);
			returnTile = 6;
		}
		else if (specialTile == 7)
		{
			gameTile.setSevenHotButton(true);
			gameTile.setOneColor(currentColor);
			returnTile = 7;
		}
		else if (specialTile == 8)
		{
			gameTile.setEightHotButton(true);
			gameTile.setOneColor(currentColor);
			returnTile = 8;
		}
		else if (specialTile == 9)
		{
			gameTile.setNineHotButton(true);
			gameTile.setOneColor(currentColor);
			returnTile = 9;
		}
		
		return returnTile;

	}
}
