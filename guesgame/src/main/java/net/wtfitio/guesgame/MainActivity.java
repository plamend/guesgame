package net.wtfitio.guesgame;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends ActionBarActivity {
Button but;
    TextView text;
    EditText edit;
    int togues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }*/
        but = (Button) findViewById(R.id.button);
        text = (TextView)findViewById(R.id.textvew);
        edit = (EditText)findViewById(R.id.edit_text);

         togues =  generate();
        Log.d("New_gen",String.valueOf(togues));
           but.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   String get_text = edit.getText().toString();
                   if (!get_text.equals("")) {

                       int guesss = Integer.parseInt(get_text);

                       if (guesss<togues) {
                           text.setText("Less then the target");
                       }
                       else if (guesss>togues){
                           text.setText("Bigger the the target");
                       }
                       else{

                           text.setText("Congrats! Find the new one now:)");
                           togues =  generate();
                       }

                   }
                   else{

                       text.setText("Enter number!!");
                   }
               }
           });


    }

    private int generate() {
        int ran=0;
        ran = new Random().nextInt(99)+1;
        return ran;

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

}
