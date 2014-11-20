# Color² Concept Notes

Application opens showing the welcome screen containing,
* A button to start the game, (Opens the game activity)
* A button that displays app info, (Opens an activity containing credits)
* A menu/setting button, (Opens an activity that can configure the difficulty and mode of the game. This information will be passed to the Game activity)
* A button that mutes the sound, (Uses a boolean value, if True when clicked sound will play else when clicked sound will not play)


# Game Activity

* Has an int variable that contains the progress of the player (0 - 5) called `playerProgress`
* Uses two arrays, `gameColors` and `playerColors`
* `gameColors` will contain the 9 static game colors,


1. Pink: `#E0A0C0`
2. Magenta: `#E04080`
3. Red: `#E04040`
4. Yellow: `#C08000`
5. Orange: `#E06040`
6. Green: `#C0E000`
7. Blue: `#00A0C0`
8. Grue: `#6EA080`
9. Purple: `#6080C0`

The other array that will store the randomly picked colors. This array will be filled by the method `randomPicker()`, depending on number, random choice = color corresponding to number, then put that color in the `playColors` array will do 6 times

There will be boxes above the player grid that will instruct the player on what colors they should press, the colors in these boxes will be determined by the content in the `playerColors` array that was filled before they display

The game grid will have 9 tiles so that every color in `gameColors` will be visible.

The game grid will be filled by the method `updateGrid()`. The method will first reset the status of all the tiles, then will look at `playerProgress`, will take that value and use it to grab the color from the `gameColor` array assign that color as a variable called `hotColor`, then generate a random number from 1-9. Then based off that number assign one of the tile objects `hotButton` status to True, then randomly fill the colors of the other tiles.

This method will be called when the game activity opens and every time the player taps a tile as long as that tile was correct and the amount of tiles taped is not greater than 6.

The scoring mechanism works by measuring the time between correct taps and adding it to the total score.

After the player has finished tapping the 6 colors, another activity will open that presents the player options to play again, quit or change settings while showing them there score (passes value from the game activity) as well as other high scores.
