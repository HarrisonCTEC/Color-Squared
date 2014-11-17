package ctec.color_squared;

import android.app.Activity;
import android.os.Bundle;

public class title_screen extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        getActionBar().setTitle("Color²");
    }
}
