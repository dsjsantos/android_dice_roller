package apps.dj.diceroller;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    TextView showRollResult;
    Toast toastInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        showRollResult = (TextView) findViewById(R.id.textView_Result);

        Button rollButton = (Button) findViewById(R.id.button_roll);
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollDice();
            }
        });

        // Simple warn log
        Log.w("MainActivity", "App onCreate Event - Get Ready!!!");
    }

    private void rollDice() {
        int min = 1;
        int max = 20;

        Random rand = new Random();
        Integer randomInt = min + Math.abs(rand.nextInt()) % max;
        //Integer randomInt = ThreadLocalRandom.current().nextInt(min, max + 1); // Requires min SDK 21

        showRollResult.setText(randomInt.toString());
        if(toastInfo!=null)
            toastInfo.cancel();
        toastInfo = Toast.makeText(this, "Dice rolled!", Toast.LENGTH_SHORT);
        toastInfo.show();
    }
}