package exercise.edu.currency;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    double numberFrom = 0, weightFrom = 23205, weightTo = 1;
    boolean checkdouble = false;
    public static TextView numberFromTv, numberToTv, exchangeRateTv;
    Spinner moneyFrom, moneyTo;
//    public Button[] btn = new Button[10];
    double exchangeRate;
    String unitFrom;
    String unitTo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numberFrom = 0;
        exchangeRate = 23205;
        unitFrom = "$";
        unitTo = "D";
        numberFromTv = findViewById(R.id.number_from);
        numberToTv = findViewById(R.id.number_to);
        exchangeRateTv = findViewById(R.id.exchangeRate);
        exchangeRateTv.setText("1 USD = 23205 VND");
        moneyFrom = findViewById(R.id.unit_from);
        moneyTo = findViewById(R.id.unit_to);

        List<Currency> items = new ArrayList<>();
        items.add(new Currency(1,"Viet Nam Dong", "D"));
        items.add(new Currency(23205,"Dollar USD", "$"));
        items.add(new Currency(24302,"Euro", "ER"));
        items.add(new Currency(407,"Russia Currency", "Rp"));
        items.add(new Currency(206,"Japan Currency", "Y"));

        List<Currency> itemFrom = new ArrayList<>();
        itemFrom.add(new Currency(23205,"Dollar USD", "$"));
        itemFrom.add(new Currency(1,"Viet Nam Dong", "D"));
        itemFrom.add(new Currency(24302,"Euro", "ER"));
        itemFrom.add(new Currency(407,"Russia Currency", "Rp"));
        itemFrom.add(new Currency(206,"Japan Currency", "J"));

        ArrayAdapter<Currency> adapter = new ArrayAdapter<Currency>(this,
                android.R.layout.simple_spinner_item,
                items);
        ArrayAdapter<Currency> adapterFrom = new ArrayAdapter<Currency>(this,
                android.R.layout.simple_spinner_item,
                itemFrom);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterFrom.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        moneyTo.setAdapter(adapter);
        moneyFrom.setAdapter(adapterFrom);

        moneyTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Adapter adapter = adapterView.getAdapter();
                Currency currency = (Currency) adapter.getItem(i);
                weightTo = currency.getWeight();
                unitTo = currency.getSymbolCurrency();
                changeRate();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        moneyFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Adapter adapter = adapterView.getAdapter();
                Currency currency = (Currency) adapter.getItem(i);
                weightFrom = currency.getWeight();
                unitFrom = currency.getSymbolCurrency();
                changeRate();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
//        moneyFrom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Adapter adapter = adapterView.getAdapter();
//                Currency currency = (Currency) adapter.getItem(i);
//                weightFrom = currency.getWeight();
//                unitFrom = currency.getSymbolCurrency();
//                changeRate();
//            }
//        });
    }
    private void changeRate(){
        exchangeRate = weightFrom / weightTo;
        exchangeRateTv.setText("1" + unitFrom + " = " + Math.floor(exchangeRate * 100000) / 100000 +"" +unitTo);
        numberFromTv.setText(unitFrom + " " + numberFrom);
        double numTmp = Math.floor(numberFrom * exchangeRate * 100) / 100;
        numberToTv.setText(unitTo + " " + numTmp);
    }
    public void enterNumber(View view) {
        Button a = (Button)findViewById(view.getId());
        String num = (String)a.getText();
        int numInt = Integer.parseInt(num);
        if(checkdouble == false){
            numberFrom = numberFrom * 10 + numInt;
            numberFromTv.setText(unitFrom + " " + numberFrom);
            double numTmp = Math.floor(numberFrom * exchangeRate * 100) / 100;
            numberToTv.setText(unitTo + " " + numTmp);
        } else {

        }
    }
    public void clearOne(View view){
        if(checkdouble == false){
            numberFrom = numberFrom/10;
            numberFrom = Math.floor(numberFrom);
            numberFromTv.setText(unitFrom + " " + numberFrom);
            double numTmp = Math.floor(numberFrom * exchangeRate) / 100;
            numberToTv.setText(unitTo + " " + numTmp);
        }

    }
    public void clear(View view){
        numberFrom = 0;
        numberFromTv.setText("0");
        numberToTv.setText("0");
    }
}