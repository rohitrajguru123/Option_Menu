package com.example.option_menu;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private final int MENU_HISTORY = 1,MENU_SETTINGS =2,MENU_FILE_MANAGER=3,DISPLAY_SETTINGS=4,BLUTOOTH_SETTINGS=5,SCREEN_SETTING=6;

    int itemId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        Toast.makeText(this, "OnMenuOpened Colled", Toast.LENGTH_SHORT).show();
        return super.onMenuOpened(featureId, menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Toast.makeText(this,"OnCreateoptionMenu got Colled",Toast.LENGTH_LONG).show();
        MenuItem histroyMenuItem = menu.add(1,MENU_HISTORY,1,"Histroy");
        MenuItem fileManagerMenuItem = menu.add(3,MENU_FILE_MANAGER,2,"File_Manger");

        SubMenu settingsSubMenu = menu.addSubMenu(2,MENU_SETTINGS,1,"Settings");
        SubMenu displaySubMenu = settingsSubMenu.addSubMenu(2,DISPLAY_SETTINGS,2,"Display Settings");
        SubMenu blutoothSubMenu = settingsSubMenu.addSubMenu(2,BLUTOOTH_SETTINGS,2,"Blutooth Settings");
        SubMenu screenSettingSubMenu = settingsSubMenu.addSubMenu(2,SCREEN_SETTING,2,"Screen Setting");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        Toast.makeText(this, "OnPrepareOption Called", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "getitem"+ menu.getItem(2), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "HasVisiable item"+menu.hasVisibleItems(), Toast.LENGTH_SHORT).show();

        menu.setGroupEnabled(2,false);
        menu.setGroupVisible(2,false);

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Toast.makeText(this, "OnOptionItemSelected Called", Toast.LENGTH_SHORT).show();

        itemId = item.getItemId();
        switch (itemId){
            case 1 :
                Toast.makeText(this, "Histroy Menu Selected", Toast.LENGTH_SHORT).show();
                break;

            case 2 :
                Toast.makeText(this, "Setting Menu Selected", Toast.LENGTH_SHORT).show();
                break;

            case 3 :
                Toast.makeText(this, "File Manager Menu Selected", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onOptionsMenuClosed(Menu menu) {
        Toast.makeText(this, "OnOptionMenuClosed Called", Toast.LENGTH_SHORT).show();
        super.onOptionsMenuClosed(menu);
    }
}