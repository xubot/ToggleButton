package uu.bawei.com.togglebutton;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private ToggleButton tb;
    private DrawerLayout dl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tb = (ToggleButton) findViewById(R.id.tb);
        dl = (DrawerLayout) findViewById(R.id.dl);
        //开关按钮的点击监听
        tb.setOnCheckedChangeListener(this);
        //侧滑页的控件
        TextView textView= (TextView) findViewById(R.id.title);
        //侧滑页的点击事件
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "已点击", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        //打开的时候关闭
        if (isChecked) {
            dl.closeDrawer(Gravity.LEFT);
        } else {
            //关闭的时候打开
            dl.openDrawer(Gravity.LEFT);
        }
    }
}
