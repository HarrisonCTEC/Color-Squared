package ctec.color_squared;

import android.graphics.Color;

public class Tiles
{
	private Color oneColor;
	private Color twoColor;
	private Color threeColor;
	private Color fourColor;
	private Color fiveColor;
	private Color sixColor;
	private Color sevenColor;
	private Color eightColor;
	private Color nineColor;
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
		this.oneColor = null;
		this.twoColor = null;
		this.threeColor = null;
		this.fourColor = null;
		this.fiveColor = null;
		this.sixColor = null;
		this.sevenColor = null;
		this.eightColor = null;
		this.nineColor = null;

        this.hotButton = 0;
	}
 
 	public Color randomColor()
 	{
 		int randomNumber = (int)Math.ceil(Math.random()*9);
 		Color returnValue = null;
 		if(randomNumber ==)
 		{
 			
 		}
 		else if(randomNumber==)
 		{
 			
 		}
 		else if(randomNumber==)
 		{
 			
 		}
 		else if(randomNumber==)
 		{
 			
 		}
 		else if(randomNumber==)
 		{
 			
 		}
 		else if(randomNumber==)
 		{
 			
 		}
 		else if(randomNumber==)
 		{
 			
 		}
 	}
 
 	private void setUsedColors(Color currentColor)
 		if(cuurentColor == pink)
 		{
 			usedColors[0] = True
 		}
 		else if(currentColor == magenta)
 		{
 			usedColors[1] = True	
 		}
 		else if(currentColor == red)
 		{
 			usedColors[2] = True	
 		}
 		else if(currentColor == yellow)
 		{
 			usedColors[3] = True	
 		}
 		else if(currentColor == orange)
 		{
 			usedColors[4] = True
 		}
 		else if(currentColor == green)
 		{
 			usedColors[5] = True	
 		}
 		else if(currentColor == grue)
 		{
 			usedColors[6] = True	
 		}
 		else if(currentColor == blue)
 		{
 			usedColors[7] = True	
 		}
 		else if(currentColor == purple)
 		{
 			usedColors[8] = True	
 		}
 	private void setHotButtonColorAndNumber(int hotButton, Color currentColor)
 	{
 		if(hotButton == 1)
		{
			gridPattern[hotButton] = currentColor;
			usedColors[]
		}
		else if(hotButton == 2)
		{
			gridPattern[hotButton] = currentColor;
		}
		else if(hotButton == 3)
		{
			gridPattern[hotButton] = currentColor;
		}
		else if(hotButton == 4)
		{
			gridPattern[hotButton] = currentColor;
		}
		else if(hotButton == 5)
		{
			gridPattern[hotButton] = currentColor;
		}
		else if(hotButton == 6)
		{
			gridPattern[hotButton] = currentColor;
		}
		else if(hotButton == 7)
		{
			gridPattern[hotButton] = currentColor;
		}
		else if(hotButton == 8)
		{
			gridPattern[hotButton] = currentColor;
		}
		else if(hotButton == 9)
		{
			gridPattern[hotButton] = currentColor;
		}
 	}
 
	public fillGameGrid(Color currentColor)
	{
		setHotButtonColorAndNumber(hotButton, currentColor);
		if(usedColors[1])
	}

	public void setHotButton(int hotButton)
	{
	    this.hotButton = hotButton;
	}

	public int getHotButton()
	{
        	return this.hotButton;
    	}

	public void setOneColor(Color oneColor)
	{
		this.oneColor = oneColor;
	}

	public void setTwoColor(Color twoColor)
	{
		this.twoColor = twoColor;
	}

	public void setThreeColor(Color threeColor)
	{
		this.threeColor = threeColor;
	}

	public void setFourColor(Color fourColor)
	{
		this.fourColor = fourColor;
	}

	public void setFiveColor(Color fiveColor)
	{
		this.fiveColor = fiveColor;
	}

	public void setSixColor(Color sixColor)
	{
		this.sixColor = sixColor;
	}

	public void setSevenColor(Color sevenColor)
	{
		this.sevenColor = sevenColor;
	}

	public void setEightColor(Color eightColor)
	{
		this.eightColor = eightColor;
	}

	public void setNineColor(Color nineColor)
	{
		this.nineColor = nineColor;
	}

	public Color getOneColor()
	{
		return oneColor;
	}

	public Color getTwoColor()
	{
		return twoColor;
	}

	public Color getThreeColor()
	{
		return threeColor;
	}

	public Color getFourColor()
	{
		return fourColor;
	}

	public Color getFiveColor()
	{
		return fiveColor;
	}

	public Color getSixColor()
	{
		return sixColor;
	}

	public Color getSevenColor()
	{
		return sevenColor;
	}

	public Color getEightColor()
	{
		return eightColor;
	}

	public Color getNineColor()
	{
		return nineColor;
	}
}
