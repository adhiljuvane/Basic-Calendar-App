package digitalnomad.myapplication;

import android.content.Intent;
import android.graphics.Color;
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

import java.util.Calendar;
import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {


    String month,next_month,prev_month;
    TextView Month,Year;
    int max_days;
    int year_int;
    int monthint;
    int weekday;
    int flag_for_same_month = 0 ;
    int flag;
    int getmonth;
    int day;
    String month_string;
    RecyclerView recyclerView;
    int c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);



        month = getIntent().getStringExtra("month");
        Log.d("activity",month);
        Calendar calendar = Calendar.getInstance();
        year_int = calendar.get(Calendar.YEAR);
        Month = (TextView) findViewById(R.id.month_text);
        Year = (TextView) findViewById(R.id.year_text);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        recyclerView = findViewById(R.id.second_recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(this,7));
        getmonth = calendar.get(Calendar.MONTH);

        // function to calculate weather leap year or not.

        if(getmonth == 0)
            month_string = "January";
        else if (getmonth == 1)
            month_string = "February";
        else if (getmonth == 2)
            month_string = "March";
        else if (getmonth == 3)
            month_string = "April";
        else if (getmonth == 4)
            month_string = "May";
        else if (getmonth == 5)
            month_string = "June";
        else if (getmonth == 6)
            month_string = "July";
        else if (getmonth == 7)
            month_string = "August";
        else if (getmonth == 8)
            month_string = "September";
        else if (getmonth == 9)
            month_string = "October";
        else if (getmonth == 10)
            month_string = "November";
        else if (getmonth == 11)
            month_string = "December";
        else
            month_string = "Oops!";

        if(month.equals(month_string)) {
            Log.d("fuck",month);
            Log.d("fuck",month_string);
            flag_for_same_month = 1;
            Log.d("fuck",String.valueOf(flag_for_same_month));


        }
        if(year_int % 400 == 0)
            flag = 1;    // leap year;
        else if(year_int % 100 == 0)
            flag = 0;
        else if(year_int % 4 == 0)
            flag = 1;


        switch (month) {
            case "January":
                max_days = 31;
                next_month = "February";
                prev_month = "December";
                monthint = 1;
                if (flag == 1) {
                    monthint = monthint - 1;
                }


                break;
            case "February":
                monthint = 4;
                next_month = "March";
                prev_month = "January";
                if (flag == 1) {
                    max_days = 29;
                    monthint = monthint - 1;
                }
                else
                    max_days = 28;


                break;
            case "March":
                max_days = 31;
                next_month = "April";
                prev_month = "February";
                monthint = 4;


                break;
            case "April":
                max_days = 30;
                next_month = "May";
                prev_month = "March";
                monthint = 0;



                break;
            case "May":
                max_days = 31;
                next_month = "June";
                prev_month = "April";
                monthint = 2;



                break;
            case "June":
                max_days = 30;
                next_month = "July";
                prev_month = "May";
                monthint = 5;



                break;
            case "July":
                max_days = 31;
                next_month = "August";
                prev_month = "June";
                monthint = 0;



                break;
            case "August":
                max_days = 31;
                next_month = "September";
                prev_month = "July";
                monthint = 3;



                break;
            case "September":
                max_days = 30;
                next_month = "October";
                prev_month = "August";
                monthint = 6;



                break;
            case "October":
                max_days = 31;
                next_month = "November";
                prev_month = "September";
                monthint = 1;



                break;
            case "November":
                max_days = 30;
                next_month = "December";
                prev_month = "October";
                monthint = 4;



                break;
            case "December":
                max_days = 31;
                next_month = "January";
                prev_month = "November";
                monthint = 6;

                break;
        }

        Month.setText(String.valueOf(month));
        Year.setText(String.valueOf(year_int));

        c = (year_int % 100)/4;
        c+=1;  // for day
        c+=monthint;
      //  Log.d("fuck",""+c);

        c+=6; // for year 2000 as in 2018
      //  Log.d("fuck",""+c);

        c+=(year_int % 100);
      //  Log.d("fuck",""+c);

        c = c % 7 ;

      //  Log.d("fuck",""+c);


        switch (c)
        {
            case 1:
                weekday = 0;
                break;
            case 2:
                weekday = 1;
                break;
            case 3:
                weekday = 2;
                break;
            case 4:
                weekday = 3;
                break;
            case 5:
                weekday = 4;
                break;
            case 6:
                weekday = 5;
                break;
            case 0:
                weekday = 6;
                break;

        }




        ArrayList<String> texDays = new ArrayList<>();

        for(int j=0; j<weekday; j++){

            texDays.add("");
        }

        for (int i=1; i<=max_days; i ++){

            texDays.add(""+i);

        }



        SlimAdapter slimAdapter = SlimAdapter.create().register(R.layout.item, new SlimInjector<String>() {
            @Override
            public void onInject(String data, IViewInjector injector) {
                injector.text(R.id.item_text,data);
                if(flag_for_same_month == 1)
                {
                    if(data.equals(String.valueOf(day))){

                        Log.e("wsdasd", String.valueOf(day));

                        injector.textColor(R.id.item_text, Color.parseColor("#00B8D4"));
                        injector.textSize(R.id.item_text,24);
                        // injector.background(R.id.item_text,Color.YELLOW);

                    }

                }

            }
        }).attachTo(recyclerView);

        slimAdapter.updateData(texDays);





    }

    public void previousMonth(View view) {

        Intent intent = new Intent(SecondActivity.this,SecondActivity.class);
        intent.putExtra("month",prev_month);
        startActivity(intent);

    }

    public void NextMonth(View view) {

        Intent intent = new Intent(SecondActivity.this,SecondActivity.class);
        intent.putExtra("month",next_month);
        startActivity(intent);
    }

    public void monthClick(View view) {

        Intent intent = new Intent(SecondActivity.this,MonthActivity.class);
        startActivity(intent);

    }

    public void yearClick(View view) {

        Intent intent = new Intent(SecondActivity.this,YearActivity.class);
        startActivity(intent);
    }
}
