package android.exam.mycaculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static TextView expression, enterNumber;
    public Button[] btn = new Button[10];
    public static int check = 0;
    public static int caculate = 0;
    public static long enter = 0, Num = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expression = findViewById(R.id.expression_text);
        enterNumber = findViewById(R.id.enter_num);
        btn[0] = findViewById(R.id.zero);
        btn[1] = findViewById(R.id.one);
        btn[2] = findViewById(R.id.two);
        btn[3] = findViewById(R.id.three);
        btn[4] = findViewById(R.id.four);
        btn[5] = findViewById(R.id.five);
        btn[6] = findViewById(R.id.six);
        btn[7] = findViewById(R.id.seven);
        btn[8] = findViewById(R.id.eight);
        btn[9] = findViewById(R.id.nine);

    }

    public void clearAll(View view) {
        expression.setText("");
        enterNumber.setText("0");
        Num = 0;
        enter = 0;
        caculate = 0;
    }
    public void clearNum(View view){
        enter = 0;
        enterNumber.setText("");
    }
    public void clearOne(View view){
        enter /= 10;
        enterNumber.setText(enter + "");
    }
    public void enterNumber(View view){
        if(check == 1){
            check = 2;
        }
        for(int i = 0; i <= 10; i++){
            if(btn[i] == findViewById(view.getId())){
                enter = enter*10 + i;
                if(caculate == 0){
                    Num = enter;
                }
                enterNumber.setText(enter + "");
                break;
            }
        }
    }
    public void changeNega(View view){
        enter = -enter;
        enterNumber.setText(enter + "");
    }
    public void caculator(View view){
        String a = ((TextView)findViewById(view.getId())).getText() + "";
        if(a.equals("/")){
            if(check == 2){
                Num = cacuNum();
            }
            expression.setText(Num + " /");
            caculate = 1;
            check = 1;
        } else if (a.equals("x")){
            if(check == 2){
                Num = cacuNum();
            }
            expression.setText(Num + " x");
            check = 1;
            caculate = 2;
        } else if (a.equals("+")){
            if(check == 2){
                Num = cacuNum();
            }
            expression.setText(Num + " +");
            check = 1;
            caculate = 3;
        } else if (a.equals("-")){
            if(check == 2){
                Num = cacuNum();
            }
            expression.setText(Num + " -");
            check = 1;
            caculate = 4;
        } else {
            if(caculate != 0){
                expression.setText(expression.getText() + " " + enter + " = ");
                Num = cacuNum();
                enterNumber.setText(Num + "");
                check = 0;
                caculate = 0;
            } else {
                expression.setText(expression.getText() + " = ");
                Num = enter;
                check = 0;
                caculate = 0;
            }
        }
        enter = 0;
    }
    public long cacuNum(){
        if(caculate == 1){
            return Num / enter;
        } else if (caculate == 2){
            return Num * enter;
        }else if (caculate == 3){
            return Num + enter;
        }else {
            return Num - enter;
        }
    }
}