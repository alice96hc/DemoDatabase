package sg.edu.rp.c347.demodatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static sg.edu.rp.c347.demodatabase.R.id.lv;

public class MainActivity extends AppCompatActivity {
    Button btnInsert,btnGetTasks;
    TextView tvResults;
    ListView lv;
    ArrayList<Task>task;
    ArrayAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView)this.findViewById(R.id.lv);

        task = new ArrayList<Task>();
//        food.add(new Food("Ah Lat Coffee", false));
//        food.add(new Food("Rocky Choc", true));
//        food.add(new Food("Kid Cat Choc", true));

        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnGetTasks = (Button) findViewById(R.id.btnGetTasks);
        tvResults = (TextView) findViewById(R.id.tvResults);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                db.insertTask("Submit RJ", "25 Apr 2016");
                db.close();
            }
        });
        btnGetTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);
                // Insert a task
                ArrayList<String> data = db.getTaskContent();
                db.close();

                String txt = "";
                for (int i = 0; i < data.size(); i++) {
                    Log.d("Database Content", i + ". " + data.get(i));
                    txt += i + ". " + data.get(i) + "\n";
                }
                tvResults.setText(txt);

                DBHelper db2 = new DBHelper(MainActivity.this);
                ArrayList<Task> al = db2.getTasks();
                db2.close();

                TaskAdapter aa = new TaskAdapter(MainActivity.this,R.layout.row,al);
                lv.setAdapter(aa);
            }
        });
    }
    }
