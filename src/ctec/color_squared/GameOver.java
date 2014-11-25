package ctec.color_squared;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class GameOver extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game_over);
	}
	
	@Override
	public void onBackPressed()
	{
		Intent transferIntent = new Intent(getBaseContext(), title_screen.class);
		startActivityForResult(transferIntent, 0);
	}
}
