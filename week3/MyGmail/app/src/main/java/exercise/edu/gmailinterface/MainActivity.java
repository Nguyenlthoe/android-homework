package exercise.edu.gmailinterface;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RVEmailAdapter.ItemClickInterface{

    List<Email> emails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emails = new ArrayList<>();

        emails.add(new Email(getResources().getIdentifier("ic_circle_green_24dp", "drawable",getPackageName()), "Educative io",
                "Buy course", "Thanks! TryHard go go", "12:00am", true));
        emails.add(new Email(getResources().getIdentifier("ic_circle_blue_24dp", "drawable",getPackageName()), "Google",
                "Cảnh báo bảo mật cho", "Đây là cảnh báo bảo mật cho bản sao. Hôm nay", "11:00am", false));
        emails.add(new Email(getResources().getIdentifier("ic_circle_red_24dp", "drawable",getPackageName()), "GeeksforGeeks",
                "[Import We are hiring for me start]", "Thanks! TryHard go go", "12:00am", true));
        emails.add(new Email(getResources().getIdentifier("ic_circle_red_24dp", "drawable",getPackageName()), "Trường đại học Công Nghệ Thông tin và Truyền thông",
                "Thông báo học phí", "Chào em Lê Trường Nguyên, học phí của em là 12.000.000 VND", "70:00am", false));
        emails.add(new Email(getResources().getIdentifier("ic_circle_yellow_24dp", "drawable",getPackageName()), "Nguyên Lê",
                "Submit My Exercise", "This is my exercise", "10:48pm", false));
        emails.add(new Email(getResources().getIdentifier("ic_circle_blue_24dp", "drawable",getPackageName()), "Educative io",
                "Buy course", "Thanks! TryHard go go", "12:00am", true));
        emails.add(new Email(getResources().getIdentifier("ic_circle_red_24dp", "drawable",getPackageName()), "Educative io",
                "Buy course", "Thanks! TryHard go go", "12:00am", true));
        emails.add(new Email(getResources().getIdentifier("ic_circle_green_24dp", "drawable",getPackageName()), "Educative io",
                "Buy course", "Thanks! TryHard go go", "12:00am", false));
        emails.add(new Email(getResources().getIdentifier("ic_circle_blue_24dp", "drawable",getPackageName()), "Educative io",
                "Buy course", "Thanks! TryHard go go", "12:00am", false));
        emails.add(new Email(getResources().getIdentifier("ic_circle_yellow_24dp", "drawable",getPackageName()), "Educative io",
                "Buy course", "Thanks! TryHard go go", "12:00am", false));
        emails.add(new Email(getResources().getIdentifier("ic_circle_green_24dp", "drawable",getPackageName()), "Educative io",
                "Buy course", "Thanks! TryHard go go", "12:00am", true));
        emails.add(new Email(getResources().getIdentifier("ic_circle_red_24dp", "drawable",getPackageName()), "Educative io",
                "Buy course", "Thanks! TryHard go go", "12:00am", false));
        emails.add(new Email(getResources().getIdentifier("ic_circle_red_24dp", "drawable",getPackageName()), "Educative io",
                "Buy course", "Thanks! TryHard go go", "12:00am", true));
        emails.add(new Email(getResources().getIdentifier("ic_circle_yellow_24dp", "drawable",getPackageName()), "Educative io",
                "Buy course", "Thanks! TryHard go go", "12:00am", false));
        emails.add(new Email(getResources().getIdentifier("ic_circle_blue_24dp", "drawable",getPackageName()), "Educative io",
                "Buy course", "Thanks! TryHard go go", "12:00am", true));

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        RVEmailAdapter adapter = new RVEmailAdapter(emails, this);
        recyclerView.setAdapter(adapter);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.main_menu,menu);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setLogo(R.drawable.ic_baseline_menu_32);    //Icon muốn hiện thị
        actionBar.setDisplayUseLogoEnabled(true);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public void OnItemClick(int position) {
        Log.v("TAG", "Item " + position + " is clicked.");
    }
}