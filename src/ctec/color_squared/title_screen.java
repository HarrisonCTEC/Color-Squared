package ctec.color_squared;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

<<<<<<< HEAD
public class title_screen extends Activity {
=======
/**
 * Main Welcome Screen
 * @author Harrison H
 * @version 1.0
 * ©2014 Orange Lightning Research
 */
public class title_screen extends Activity
{
>>>>>>> origin/master
	private Button startButton;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		startButton = (Button) findViewById(R.id.startButton);

		setupListeners();
	}

	private void setupListeners() {
		startButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent transferIntent = new Intent(title_screen.this, GameScreen.class);
				startActivityForResult(transferIntent, 0);

			}
		});
	}
}
