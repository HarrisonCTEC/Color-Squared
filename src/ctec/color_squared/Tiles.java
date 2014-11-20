package ctec.color_squared;

import android.graphics.Color;

public class Tiles
{
	private Color[] gridPattern = new Color[8];
	private boolean[] usedColors = new boolean[8];
	private Color pink, magenta, red, yellow, orange, green, grue, blue, purple;

	pink = Color.parseColor("#E0A0C0");
        magenta = Color.parseColor("#E04080");
        red = Color.parseColor("#E04040");
        yellow = Color.parseColor("#C08000");
        orange = Color.parseColor("#E06040");
        green = Color.parseColor("#C0E000");
        grue = Color.parseColor("#E6EA080");
        blue = Color.parseColor("#E00A0C0");
        purple = Color.parseColor("#6080C0");
	

    	/**
     	* 1-9 represents tiles, 0 represents unset
     	*/
    	private int hotButton;

	public void tiles()
	{
	        this.hotButton = 0;
	}
 
 	public Color randomColor()
 	{
 		int randomNumber = (int)Math.ceil(Math.random()*9);
 		Color returnValue = null;
 		if(randomNumber == 1)
 		{
 			returnValue = pink;
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
 		return returnValue;
 	}
 
 	/**
 	 * Checks to see if a color has been used or not. Returns true if the color is being used already
 	 */
 	private boolean isSetColor(Color someColor)
 	{
 		boolean returnValue = false;
 		
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
 	 */
 	private void setUsedColors(Color currentColor)
 	{
 		if(cuurentColor == pink)
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
 	
 	private void setHotButtonColorAndNumber(int hotButton, Color currentColor)
 	{
 		gridPattern[hotButton] = currentColor;
		setUsedColors(currentColor);
 	}
 
	public Color[] fillGameGrid(Color currentColor)
	{
		int counter = 0;
		Color random = null;
		setHotButtonColorAndNumber(this.hotButton, currentColor);
		while(counter != 8)
		{
			random = randomColor();
			if(!isSetColor(random) && !usedColors[counter])
			{
				gridPattern[counter] = random;
				setUsedColors(random);
			}
			counter++;
		}
		return gridPattern;
	}

	public void setHotButton(int hotButton)
	{
	    this.hotButton = hotButton;
	}

	public boolean isHotButton(int tileNumber)
	{
        	boolean returnValue = false;
        	if(tileNumber == this.hotButton)
        	{
        		returnValue = true;
        	}
        	return returnValue;
    	}
}
