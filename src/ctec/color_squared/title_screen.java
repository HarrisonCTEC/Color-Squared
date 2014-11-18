package ctec.color_squared;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class title_screen extends Activity
{
	private Button startButton;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        startButton = (Button) findViewById(R.id.startButton);
        
        getActionBar().setTitle(R.string.app_name_fancy);
        
    }
    
    private void setupListeners()
    {
    	startButton.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				Intent transferIntent = new Intent(v.getContext(), GameScreen.class);
				startActivityForResult(transferIntent, 0);
				
			}
		});
    }
}
