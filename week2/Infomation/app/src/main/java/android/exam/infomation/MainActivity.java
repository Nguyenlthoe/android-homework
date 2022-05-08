package android.exam.infomation;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    public static TextView birthday;
    public static EditText[] input_text = new EditText[10];
    public static TextView[] text_warn = new TextView[10];
    public static CalendarView calendarView;
    public static CheckBox yessSubmit;
    public static ScrollView scrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Các trường bắt buộc
        input_text[0] = findViewById(R.id.Input_MSSV);
        text_warn[0] = findViewById(R.id.MSSV_warn);
        input_text[1] = findViewById(R.id.Input_name);
        text_warn[1] = findViewById(R.id.HVT_warn);
        input_text[2] = findViewById(R.id.Input_CCCD);
        text_warn[2] = findViewById(R.id.CCCD_warn);
        input_text[3] = findViewById(R.id.Input_SDT);
        text_warn[3] = findViewById(R.id.SDT_warn);
        input_text[4] = findViewById(R.id.Input_Email);
        text_warn[4] = findViewById(R.id.Email_warn);
        yessSubmit = findViewById(R.id.yesSubmit);
        text_warn[5] = findViewById(R.id.Yes_warn);
        setHiddenWarn();

//        Ngày sinh
        birthday = findViewById(R.id.birthday);
        calendarView = findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                birthday.setText("Ngày sinh: " + i2 + "/" + i1 + "/" + i);
            }
        });
        scrollView = findViewById(R.id.scrollview);
    }

    private void setHiddenWarn() {
        for(int i = 0; i < 5; i++){
            int finalI = i;
            input_text[i].addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int j, int i1, int i2) {
                    text_warn[finalI].setVisibility(View.GONE);
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }
    }

    public void submit(View view){
        int check = 0;
        for(int i = 0; i < 5; i++){
            if(input_text[i].getText().toString().trim().equals("")){
                text_warn[i].setVisibility(View.VISIBLE);
                if(check == 0){
                    scrollView.scrollTo(input_text[i].getScrollX(), input_text[i].getScrollY());
                    check = 1;
                }
            }
        }
        if(!yessSubmit.isChecked()){
            text_warn[5].setVisibility(View.VISIBLE);
            check = 1;
        }
        if(check == 0){
            Toast toast =  Toast.makeText(MainActivity.this, "Bạn lưu thông tin thành công", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 20, 30);
            toast.show();
        }
    }
    public void hinddenWarn(View view){
        text_warn[5].setVisibility(View.GONE);
    }
}
