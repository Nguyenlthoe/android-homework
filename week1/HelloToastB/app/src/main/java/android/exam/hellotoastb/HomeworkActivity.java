package android.exam.hellotoastb;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import hellotoastb.R;

public class HomeworkActivity extends AppCompatActivity {

    private static int mCount = 0;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);
        ((TextView) findViewById(R.id.show_count)).setText(Integer.toString(mCount));
        if(mCount != 0){
            findViewById(R.id.zero_button).setBackgroundColor(Color.rgb(255,0,255));
        } else {
            findViewById(R.id.zero_button).setBackgroundColor(Color.rgb(136,136,136));
        }
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message,
                Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view) {
        mCount++;
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
        }
        if(mCount == 1){
            findViewById(R.id.zero_button).setBackgroundColor(Color.rgb(255,0,255));
        }
    }

    public void setzero(View view) {
        mCount = 0;
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
        }
        findViewById(R.id.zero_button).setBackgroundColor(Color.rgb(136,136,136));
    }
}