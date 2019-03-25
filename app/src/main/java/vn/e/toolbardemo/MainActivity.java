package vn.e.toolbardemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;

    private Button btnOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnOpen = findViewById(R.id.btnOpen);
        toolbar = findViewById(R.id.toolbar);


        setSupportActionBar(toolbar);


        toolbar.setLogo(R.mipmap.ic_launcher);

        toolbar.setTitle("Hello Moto!!!");

        toolbar.setNavigationIcon(android.R.drawable.ic_menu_save);

        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // mo context Menu
                //openContextMenu(v);

                showPopUp(v);
            }
        });


        // dang ki su dung contextMenu
        registerForContextMenu(btnOpen);


    }


    public void showPopUp(View view) {

        PopupMenu popupMenu = new PopupMenu(MainActivity.this, view);
        MenuInflater menuInflater = getMenuInflater();

        menuInflater.inflate(R.menu.my_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.menuOpen:

                        showMessage("You clicked Open");
                        break;

                    case R.id.menuClose:
                        showMessage("You clicked Close");

                        break;
                    case R.id.menuExit:

                        showMessage("You clicked Exit");
                        break;
                    case R.id.menuLogOut:

                        showMessage("You clicked LogOut");
                        break;

                }
                return false;
            }
        });

        popupMenu.show();

    }


    // khoi tao option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menuOpen:

                showMessage("You clicked Open");
                break;

            case R.id.menuClose:
                showMessage("You clicked Close");

                break;
            case R.id.menuExit:

                showMessage("You clicked Exit");
                break;
            case R.id.menuLogOut:

                showMessage("You clicked LogOut");
                break;

        }

        return super.onContextItemSelected(item);
    }

    // bat su kien an vao menu do
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.menuOpen:

                showMessage("You clicked Open");
                break;

            case R.id.menuClose:
                showMessage("You clicked Close");

                break;
            case R.id.menuExit:

                showMessage("You clicked Exit");
                break;
            case R.id.menuLogOut:

                showMessage("You clicked LogOut");
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
