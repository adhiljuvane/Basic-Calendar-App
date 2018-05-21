package digitalnomad.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import net.idik.lib.slimadapter.SlimAdapter;
import net.idik.lib.slimadapter.SlimInjector;
import net.idik.lib.slimadapter.viewinjector.IViewInjector;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Arrays;

public class MonthActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month);



        textView = (TextView) findViewById(R.id.months);
       // textView.setOnClickListener(myMonthListener);

        recyclerView = findViewById(R.id.month_recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));


        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("January" , "February" , "March" , "April" , "May" , "June" , "July" , "August" , "September" , "October" , "November" , "December"));


        Log.d("asass", String.valueOf(arrayList));



        SlimAdapter slimAdapter = SlimAdapter.create().register(R.layout.months_list, new SlimInjector<String>() {
            @Override
            public void onInject(String data, IViewInjector injector) {
                injector.text(R.id.months,data);
                final String s = data;
                injector.clicked(R.id.months, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MonthActivity.this,SecondActivity.class);
                        intent.putExtra("month",s);
                        startActivity(intent);

                    }
                });

                if(data=="January") {
                    injector.background(R.id.months, R.drawable.picsumphotos1);
                }
                if(data=="February")
                    injector.background(R.id.months,R.drawable.picsumphotos2);
                if(data=="March")
                    injector.background(R.id.months,R.drawable.picsumphotos3);
                if(data=="April")
                    injector.background(R.id.months,R.drawable.picsumphotos4);
                if(data=="May")
                    injector.background(R.id.months,R.drawable.picsumphotos5);
                if(data=="June")
                    injector.background(R.id.months,R.drawable.picsumphotos6);
                if(data=="July")
                    injector.background(R.id.months,R.drawable.picsumphotos7);
                if(data=="August")
                    injector.background(R.id.months,R.drawable.picsumphotos8);
                if(data=="September")
                    injector.background(R.id.months,R.drawable.picsumphotos9);
                if(data=="October")
                    injector.background(R.id.months,R.drawable.picsumphotos10);
                if(data=="November")
                    injector.background(R.id.months,R.drawable.picsumphotos11);
                if(data=="December")
                    injector.background(R.id.months,R.drawable.picsumphotos12);




            }
        }).attachTo(recyclerView);




        slimAdapter.updateData(arrayList);


    }

//      private View.OnClickListener myMonthListener = new View.OnClickListener() {
//          @Override
//          public void onClick(View view) {
//              switch (view.getId()){
//                  case R.id.months:
//                      m = textView.getText().toString();
//                      Intent intent = new Intent(MonthActivity.this,SecondActivity.class);
//                      intent.putExtra("month",m);
//                      startActivity(intent);
//
//
//              }
//          }
//      };

   /* @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.months:
                m = textView.getText().toString();
                Intent intent = new Intent(MonthActivity.this,SecondActivity.class);
                intent.putExtra("month",m);
                //Log.d("monthm",m);
                startActivity(intent);


        }
*/

//    public void monthSelect(View view) {
//        m = textView.getText().toString();
//        Log.e("final",m);
//        Intent intent = new Intent(MonthActivity.this,SecondActivity.class);
//        intent.putExtra("month",m);
//        startActivity(intent);
//    }
}
