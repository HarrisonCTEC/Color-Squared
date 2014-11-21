package ctec.color_squared;

import android.graphics.Color;

/**
 * Tiles object
 * @contains Game colors, Tile states and hotButton
 * @author Mark Shamy
 * ©2014 Orange Lightning Research
 */
public class Tiles
{
	private int[] gridPattern = new int[8];
	private boolean[] usedColors = new boolean[8];
	private int pink, magenta, red, yellow, orange, green, grue, blue, purple;
    private int hotButton;

	public Tiles()
	{
	        this.hotButton = 0;
	        this.pink = Color.parseColor("#E0A0C0"); //This converts from a hex string into a Color int
	        this.magenta = Color.parseColor("#E04080");
	        this.red = Color.parseColor("#E04040");
	        this.yellow = Color.parseColor("#C08000");
	        this.orange = Color.parseColor("#E06040");
	        this.green = Color.parseColor("#C0E000");
	        this.grue = Color.parseColor("#E6EA080");
	        this.blue = Color.parseColor("#E00A0C0");
	        this.purple = Color.parseColor("#6080C0");
	}
 
 /**
  * Returns one of the nine colors randomly when called
  * @return the randomly selected Color
  */
 	public int randomColor()
 	{
 		int randomNumber = (int)Math.ceil(Math.random()*9); //Generate a number between 1 and 9
 		int returnValue = 0; //Set a default return value
 		if(randomNumber == 1) //If that randomly generated number is 1
 		{
 			returnValue = pink; //Make the return value pink
 		}
 		else if(randomNumber == 2)
 		{
 			returnValue = magenta;
 		}
 		else if(randomNumber == 3)
 		{
 			returnValue = red;
 		}
 		else if(randomNumber == 4)
 		{
 			returnValue = yellow;
 		}
 		else if(randomNumber == 5)
 		{
 			returnValue = orange;
 		}
 		else if(randomNumber == 6)
 		{
 			returnValue = green;
 		}
 		else if(randomNumber == 7)
 		{
 			returnValue = grue;
 		}
 		else if(randomNumber == 8)
 		{
 			returnValue = blue;
 		}
 		else if(randomNumber == 9)
 		{
 			returnValue = purple;
 		}
 		
 		return returnValue; //What ever that returnValue was changed to in the above conditionals, return the returnValue
 	}
 
/**
* Checks to see if a color has been used or not. Returns true if the color is being used already
* @param someColor the Color that we are questioning if it has been used aldready or not.
* @return If the color has aldready been placed in the array, true
*/
 	private boolean isSetColor(int someColor)
 	{
 		boolean returnValue = false; //Make a default returnValue
 		
 		if(someColor == pink)
 		{
 			if(usedColors[0])
 			{
 				returnValue = true;
 			}
 		}
 		else if(someColor== magenta)
 		{
 			if(usedColors[1])
 			{
 				returnValue = true;
 			}
 		}
 		else if(someColor == red)
 		{
 			if(usedColors[2])
 			{
 				returnValue = true;
 			}	
 		}
 		else if(someColor == yellow)
 		{
 			if(usedColors[3])
 			{
 				returnValue = true;
 			}	
 		}
 		else if(someColor == orange)
 		{
 			if(usedColors[4])
 			{
 				returnValue = true;
 			}
 		}
 		else if(someColor == green)
 		{
 			if(usedColors[5])
 			{
 				returnValue = true;
 			}	
 		}
 		else if(someColor == grue)
 		{
 			if(usedColors[6])
 			{
 				returnValue = true;
 			}
 		}
 		else if(someColor == blue)
 		{
 			if(usedColors[7])
 			{
 				returnValue = true;
 			}	
 		}
 		else if(someColor == purple)
 		{
 			if(usedColors[8])
 			{
 				returnValue = true;
 			}	
 		}
 		
 		return returnValue;
 	}
 
 /**
 * When a color is being used, this method updates the boolean array
 * Every color that the game uses has a number assoisated to it, but is not ever formely used in code
 */
 	private void setUsedColors(int currentColor)
 	{
 		if(currentColor == pink)
 		{
 			usedColors[0] = true;
 		}
 		else if(currentColor == magenta)
 		{
 			usedColors[1] = true;	
 		}
 		else if(currentColor == red)
 		{
 			usedColors[2] = true;	
 		}
 		else if(currentColor == yellow)
 		{
 			usedColors[3] = true;	
 		}
 		else if(currentColor == orange)
 		{
 			usedColors[4] = true;
 		}
 		else if(currentColor == green)
 		{
 			usedColors[5] = true;	
 		}
 		else if(currentColor == grue)
 		{
 			usedColors[6] = true;	
 		}
 		else if(currentColor == blue)
 		{
 			usedColors[7] = true;	
 		}
 		else if(currentColor == purple)
 		{
 			usedColors[8] = true;	
 		}
 	}
 	
 /**
  * This allows the computer to know what tile is special as well the color of that tile. This prevents duplicate
  * tile colors
  * @param hotButton the int that was randomly created at the game screen activity
  * @param currentColor the color of the hotButton
  */
 	private void setHotButtonColorAndNumber(int hotButton, int currentColor)
 	{
 		gridPattern[hotButton] = currentColor; //Take the current color that the player should find at this poijnt and shove it inside the gridPattern Array at the index coresponding with the tile's number
		setUsedColors(currentColor); //Change the boolean Array so we don't randomly generate this nnumber again.
 	}
 	
 /**
  * Fills a Color Array of the all the game tiles
  * @param currentColor the color we are currently at so we know not to generate it, it is also the color of the hotButton
  * @return take the gridPattern Array that was just filled and returns it
  */
	public int[] fillGameGrid(int currentColor)
	{
		int counter = 0; //So we know where we are in our loop, provides escape route.
		int random = 0; //Initialization
		setHotButtonColorAndNumber(this.hotButton, currentColor); //We have to put the hotButton and hotButton color in first, it is the most important.
		while(counter != 8) //As long as the variable counter is not 8
		{
			random = randomColor(); //Generates a random Color and names it random
			if(!isSetColor(random) && !usedColors[counter]) //If the color hasn't been put in the grid already and we have not yet made that color. Everything exepct for the hotButton should be false at this point in this array
			{
				gridPattern[counter] = random; //At whatever index we are currently at, shove the random Color there
				setUsedColors(random); //This changes the boolean array so the computer does not make this color again
			}
			counter++; //Take whatever number counter is currently, then add one to that number
		}
		return gridPattern; //When the computer is done with the loop, the Array gridPattern \should contain no nulls, then this returns the Color Array
	}

	public void setHotButton(int hotButton)
	{
	    this.hotButton = hotButton;
	}

/**
 * This method can tell other methods if a tile is special or not
 * @param The tile in question number
 * @return wether or not this tile is the right tile that the player is supposed to press
 */
	public boolean isHotButton(int tileNumber)
	{
        	boolean returnValue = false; //Make a default returnValue
        	if(tileNumber == this.hotButton) //If the tile's number is the same as the intvairble hotButton that was set when the hotButton was randomly selected.
        	{
        		returnValue = true; //Than the tile in question is indeed the special tile
        	}
        	return returnValue;
    	}
	
	public void resetGrid()
	{
		gridPattern[0] = 0;
		gridPattern[1] = 0;
		gridPattern[2] = 0;
		gridPattern[3] = 0;
		gridPattern[4] = 0;
		gridPattern[5] = 0;
		gridPattern[6] = 0;
		gridPattern[7] = 0;
		gridPattern[8] = 0;
		usedColors[0] = false;
		usedColors[1] = false;
		usedColors[2] = false;
		usedColors[3] = false;
		usedColors[4] = false;
		usedColors[5] = false;
		usedColors[6] = false;
		usedColors[7] = false;
		usedColors[8] = false;
		hotButton = 0;
	}
}
