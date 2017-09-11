package bodor.com.yourowndb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Account> lstUser = new ArrayList<Account>();
    DbHelper dbHelper;
    Button btnGetData;
    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGetData = (Button) findViewById(R.id.btn_getdata);
        container = (LinearLayout) findViewById(R.id.container);

        dbHelper = new DbHelper(getApplicationContext());
        dbHelper.creatDatabase();

        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lstUser = dbHelper.getAllUsers();
                for (Account account:lstUser){
                    LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);

                    View addview =layoutInflater.inflate(R.layout.row,null);
                    TextView username = addview.findViewById(R.id.username);
                    TextView email = addview.findViewById(R.id.email);

                    username.setText(account.getUserName());
                    email.setText(account.getEmail());

                    container.addView(addview);
                }
            }
        });


    }
}
