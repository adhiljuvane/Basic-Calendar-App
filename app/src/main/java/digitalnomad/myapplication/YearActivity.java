package digitalnomad.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import net.idik.lib.slimadapter.SlimAdapter;
import net.idik.lib.slimadapter.SlimInjector;
import net.idik.lib.slimadapter.viewinjector.IViewInjector;

import java.util.ArrayList;

public class YearActivity extends AppCompatActivity {

    RecyclerView recyclerView1;
    ArrayList<String> annalist = new ArrayList<>();
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_year);

        recyclerView1 = findViewById(R.id.year_recycler);
        recyclerView1.setLayoutManager(new GridLayoutManager(this, 1));


        for (i = 1990; i <= 2150; i++) {
            annalist.add("" + i);
        }


        SlimAdapter slimAdapter1 = SlimAdapter.create().register(R.layout.years, new SlimInjector<String>() {
            @Override
            public void onInject(String data, IViewInjector injector) {
                injector.text(R.id.years_text, data);


            }
        }).attachTo(recyclerView1);
        slimAdapter1.updateData(annalist);

    }

}



