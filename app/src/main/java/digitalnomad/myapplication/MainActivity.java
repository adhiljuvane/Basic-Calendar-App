package digitalnomad.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import net.idik.lib.slimadapter.SlimAdapter;
import net.idik.lib.slimadapter.SlimInjector;
import net.idik.lib.slimadapter.viewinjector.IViewInjector;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView year_text,month_text;
    int[] arr = new int[10];
    int day_month;
    int year_int;
    int month_int;
    int day_week;
    int day;
    int date;
    int maximum;
    String month,next_month,prev_month;
    RecyclerView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = findViewById(R.id.main_recycler);

        view.setLayoutManager(new GridLayoutManager(this,7));

        year_text = (TextView) findViewById(R.id.year_text);
        month_text = (TextView) findViewById(R.id.month_text);

        Calendar calendar = Calendar.getInstance();
        day_month = calendar.get(Calendar.DAY_OF_MONTH);
        day_week = calendar.get(Calendar.DAY_OF_WEEK);
        month_int = calendar.get(Calendar.MONTH);
        year_int = calendar.get(Calendar.YEAR);

        if(month_int == 0) {
            month = "January";
            next_month = "February";
            prev_month = "December";
        }
        else if (month_int == 1) {
            month = "February";
            next_month = "March";
            prev_month = "January";
        }
        else if (month_int == 2) {
            month = "March";
            next_month = "April";
            prev_month = "February";
        }
        else if (month_int == 3) {
            month = "April";
            next_month = "May";
            prev_month = "March";
        }
        else if (month_int == 4){
            month = "May";
            next_month = "June";
            prev_month = "April";
        }
        else if (month_int == 5) {
            month = "June";
            next_month = "July";
            prev_month = "May";
        }
        else if (month_int == 6) {
            month = "July";
            next_month = "August";
            prev_month = "June";
        }
        else if (month_int == 7) {
            month = "August";
            next_month = "September";
            prev_month = "July";
        }
        else if (month_int == 8) {
            month = "September";
            next_month = "October";
            prev_month = "August";
        }
        else if (month_int == 9) {
            month = "October";
            next_month = "November";
            prev_month = "September";
        }
        else if (month_int == 10) {
            month = "November";
            next_month = "December";
            prev_month = "October";
        }
        else if (month_int == 11) {
            month = "December";
            next_month = "January";
            prev_month = "November";
        }
        else
            month = "Oops!";


        month_text.setText(month);
        year_text.setText(""+year_int);

        // to check the year is leap year or not.

        int flag = 0;
        int max_day;
        if(year_int % 400 == 0)
            flag = 1 ;
        else if(year_int % 100 == 0)
            flag = 0 ;
        else if(year_int % 4 == 0)
            flag = 1 ;

        // if leap year;

        if(flag == 1)
        {
            if(month_int == 1)

                max_day = 29;

            else if (month_int == 0 || month_int == 2 || month_int == 4 || month_int == 6 || month_int == 7 || month_int == 9 || month_int == 11)

                max_day = 31;

            else

                max_day = 30;
        }
        else
        {
            if(month_int == 1)

                max_day = 28;

            else if (month_int == 0 || month_int == 2 || month_int == 4 || month_int == 6 || month_int == 7 || month_int == 9 || month_int == 11)

                max_day = 31;

            else

                max_day = 30;
        }


        int date_counter,day_counter;

        date_counter = day_month % 7;
        day_counter = day_week ;

        while (date_counter != 0)
        {
            date_counter -- ;
            if(day_counter == 1)
                day_counter = 7 ;
            else
                day_counter -- ;

        }

        date_counter++;




        ArrayList<String> textDays = new ArrayList<>();

    int f = day_counter;

        for(int j=0; j<f; j++){

            textDays.add("");
        }

        for (int i=1; i<=max_day; i ++){

            textDays.add(""+i);

        }


        day = day_counter;
        date = date_counter;
        maximum = max_day;

//        int i=0;
//        int fin = day;
//        while(date<=maximum) {
//
//
//            for (; fin%6< 0; fin++, date++) {
//                if(fin>7)
//                    fin=1;
//
//            }
//            for(;fin%6>=0;fin++,date++) {
//                if(fin>7)
//                    fin=1;
//                arr[i] = date;
//                i++;
//
//            }
//
//
//        }


        SlimAdapter slimAdapter = SlimAdapter.create()
                .register(R.layout.item, new SlimInjector<String>() {
            @Override
            public void onInject(String data, IViewInjector injector) {
                if(data.equals(String.valueOf(day_month))){

                    Log.e("wsdasd", String.valueOf(day_month));

                    injector.textColor(R.id.item_text, Color.parseColor("#00B8D4"));
                    injector.textSize(R.id.item_text,24);
                   // injector.background(R.id.item_text,Color.YELLOW);

                }
//                for(int i=0 ; i<5 ; i++) {
//                    if (data.equals(String.valueOf(arr[i])))
//                    {
//                        injector.textColor(R.id.item_text, Color.parseColor("#64DD17"));
//                        injector.textSize(R.id.item_text,24);
//                    }
//                }
            //    if(checkHoliday(data))
           //     {
             //       injector.textColor(R.id.item_text,Color.parseColor(("#F44336")));
               // }
                injector.text(R.id.item_text,data);

            }
        }).attachTo(view);

        slimAdapter.updateData(textDays);




    }

    // when clicked on year.

    public void yearClick(View view) {

        Intent intent = new Intent(MainActivity.this,YearActivity.class);
        startActivity(intent);


    }

    //when clicked on previous arrow

    public void previousMonth(View view) {

        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        intent.putExtra("month",prev_month);
        startActivity(intent);

    }


    // when clicked on next month.

    public void NextMonth(View view) {

        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        intent.putExtra("month",next_month);
        startActivity(intent);



    }

    public void monthClick(View view) {

        Intent intent = new Intent(MainActivity.this,MonthActivity.class);
        startActivity(intent);
    }

    //function to check whether sunday or saturday

}
