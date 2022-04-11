package myexam.helloworld;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView content = findViewById(R.id.content);
        content.setText("Happy birthday my friend");
        int a = 0;
        int b = 0;
        try{
            a = a / b;
        } catch (Exception e){
            Log.i("MainActivity", e.getMessage());
        }
        Log.d("MainActivity", "Hello World");
    }
}