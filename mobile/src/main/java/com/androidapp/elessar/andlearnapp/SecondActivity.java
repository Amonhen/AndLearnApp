package com.androidapp.elessar.andlearnapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    public static final int MENU_ITEM_NEW_ID = 10;

    public static final int SUB_MENU_NEW_TEXT_FILE = 11;
    public static final int SUB_MENU_NEW_IMAGE_FILE = 12;

    public static final int MENU_ITEM_OPEN_ID = 20;
    public static final int MENU_ITEM_EDIT_ID = 30;
    public static final int MENU_ITEM_CLOSE_ID = 40;
    public static final int MENU_ITEM_TEST_ID = 50;
    public static final int MENU_ITEM_TEST1_ID = 60;
    public static final int MENU_ITEM_TEST2_ID = 70;
    public static final int MENU_ITEM_TEST3_ID = 80;
    public static final int MENU_ITEM_TEST4_ID = 90;
    public static final int MENU_ITEM_TEST5_ID = 100;
    public static final int MENU_ITEM_TEST6_ID = 110;
    public static final int MENU_ITEM_TEST7_ID = 120;
    public static final int MENU_ITEM_TEST8_ID = 130;
    public static final int MENU_ITEM_EXIT_ID = 140;

    public static final int CONTEXT_MENU_EDIT_ID = 201;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.second_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

//        final LinearLayout context_menu = (LinearLayout) findViewById(R.id.context_menu);
//        registerForContextMenu(context_menu);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main,menu);

        SubMenu subMenuOfNew = menu.addSubMenu("New");
        subMenuOfNew.add(Menu.NONE,SUB_MENU_NEW_TEXT_FILE,Menu.NONE,"Text file");
        subMenuOfNew.add(Menu.NONE,SUB_MENU_NEW_IMAGE_FILE,Menu.NONE,"Text image");

        menu.add(Menu.NONE,MENU_ITEM_NEW_ID,Menu.NONE,"New").setIcon(android.R.drawable.ic_menu_share);
        menu.add(Menu.NONE,MENU_ITEM_OPEN_ID,Menu.NONE,"Open");
        menu.add(Menu.NONE,MENU_ITEM_EDIT_ID,Menu.NONE,"Edit");
        menu.add(Menu.NONE,MENU_ITEM_CLOSE_ID,Menu.NONE,"Close");
        menu.add(Menu.NONE,MENU_ITEM_TEST_ID,Menu.NONE,"Test");
        menu.add(Menu.NONE,MENU_ITEM_TEST1_ID,Menu.NONE,"Test1");
        menu.add(Menu.NONE,MENU_ITEM_TEST2_ID,Menu.NONE,"Test2");
        menu.add(Menu.NONE,MENU_ITEM_TEST3_ID,Menu.NONE,"Test3");
        menu.add(Menu.NONE,MENU_ITEM_TEST4_ID,Menu.NONE,"Test4");
        menu.add(Menu.NONE,MENU_ITEM_TEST5_ID,Menu.NONE,"Test5");
        menu.add(Menu.NONE,MENU_ITEM_TEST6_ID,Menu.NONE,"Test6");
        menu.add(Menu.NONE,MENU_ITEM_TEST7_ID,Menu.NONE,"Test7");
        menu.add(Menu.NONE,MENU_ITEM_TEST8_ID,Menu.NONE,"Test8");
        menu.add(Menu.NONE,MENU_ITEM_EXIT_ID,Menu.NONE,"Exit");
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        CharSequence message;
        switch (item.getItemId()) {
            case MENU_ITEM_NEW_ID : message = "New Selected"; break;
            case MENU_ITEM_OPEN_ID: message = "Open Selected"; break;
            case MENU_ITEM_EDIT_ID: message = "Edit Selected"; break;
            case MENU_ITEM_CLOSE_ID: message = "Close Selected"; break;
            case MENU_ITEM_EXIT_ID: message = "Exit Selected"; break;
            default: message= item.getTitle();
        }
        Toast toast_id = Toast.makeText(this,message,Toast.LENGTH_LONG);
        toast_id.setGravity(Gravity.CENTER,0,0);
        toast_id.show();
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(Menu.NONE,CONTEXT_MENU_EDIT_ID,Menu.NONE,"Edit");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Toast toast_item_id = Toast.makeText(this,item.getTitle(),Toast.LENGTH_LONG);
        toast_item_id.setGravity(Gravity.CENTER,0,0);
        toast_item_id.show();
        return true;

    }
}
