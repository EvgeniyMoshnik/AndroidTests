package com.test.evgeniy.androidtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button mButton1;
    TextView mText1;
    Button mButton2;
    CheckBox mChecbox1;
    CheckBox mChecbox2;
    Menu mMenu;
    TextView mTextSize;
    TextView mTextColor;


    final int MENU_COLOR_RED = 1;
    final int MENU_COLOR_GREEN = 2;
    final int MENU_COLOR_YELLOW = 3;

    final int MENU_SIZE_20 = 4;
    final int MENU_SIZE_25 = 5;
    final int MENU_SIZE_30 = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton1 = (Button) findViewById(R.id.button);
        mText1 = (TextView) findViewById(R.id.textView);
        mButton2 = (Button) findViewById(R.id.button2);
        mChecbox1 = (CheckBox) findViewById(R.id.checkBox);
        mChecbox2 = (CheckBox) findViewById(R.id.checkBox2);
        mTextSize = (TextView) findViewById(R.id.textView_Size);
        mTextColor = (TextView) findViewById(R.id.textView_Color);

        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mText1.setText("BOBER!");
                mText1.setTextColor(getResources().getColor(R.color.blue));
                Toast toast = Toast.makeText(MainActivity.this, "Enter buttom", Toast.LENGTH_LONG);
                toast.show();
            }
        });

        mButton2.setOnClickListener(this);


      //  mTextColor.setOnCreateContextMenuListener(this);
        registerForContextMenu(mTextSize);
        registerForContextMenu(mTextColor);

    }


    public void textChange(View view) {
        mText1.setText("(.)(.)");
        mText1.setTextColor(getResources().getColor(R.color.colorAccent));
    }

    @Override
    public void onClick(View v) {
        Toast toast = Toast.makeText(this, "Attaking the Others!!", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        mMenu = menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id) {
            case R.id.action_settings:
                Toast.makeText(MainActivity.this, getString(R.string.settings), Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_item1:
                Toast.makeText(MainActivity.this, getString(R.string.menu_1), Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_item2:
                Toast.makeText(MainActivity.this, getString(R.string.menu_2), Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_item3:
                Toast.makeText(MainActivity.this, getString(R.string.menu_3), Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        menu.setGroupVisible(R.id.group1,mChecbox2.isChecked());




        return super.onPrepareOptionsMenu(menu);
    }

    public void setSetting(View view){
        MenuItem menuItem = mMenu.findItem(R.id.action_settings);

        if(mChecbox1.isChecked()) {

            menuItem.setVisible(true);
        } else {
            menuItem.setVisible(false);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        switch (v.getId()){
            case R.id.textView_Color:
                menu.add(0, MENU_COLOR_GREEN, 0, "Green");
                menu.add(0, MENU_COLOR_RED, 0, "Red" );
                menu.add(0, MENU_COLOR_YELLOW, 0, "Yellow" );
                break;
            case R.id.textView_Size:
                menu.add(0, MENU_SIZE_20, 0, "20");
                menu.add(0, MENU_SIZE_25, 0, "25");
                menu.add(0, MENU_SIZE_30, 0, "30");
                break;

        }
      //  super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case MENU_COLOR_GREEN:
                mTextColor.setTextColor(getResources().getColor(R.color.green));
                mTextColor.setText("Color Green");
                break;
            case MENU_COLOR_RED:
                mTextColor.setTextColor(getResources().getColor(R.color.red));
                mTextColor.setText("Color Red");
                break;
            case MENU_COLOR_YELLOW:
                mTextColor.setTextColor(getResources().getColor(R.color.yellow));
                mTextColor.setText("Color Yellow");
                break;
            case MENU_SIZE_20:
                mTextSize.setTextSize(20);
                mTextSize.setText("Size 20");
                break;
            case MENU_SIZE_25:
                mTextSize.setTextSize(25);
                mTextSize.setText("Size 25");
                break;
            case MENU_SIZE_30:
                mTextSize.setTextSize(30);
                mTextSize.setText("Size 30");
                break;
        }
        return super.onContextItemSelected(item);
    }
}
