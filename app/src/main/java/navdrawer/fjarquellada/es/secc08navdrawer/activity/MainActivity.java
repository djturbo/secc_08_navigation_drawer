package navdrawer.fjarquellada.es.secc08navdrawer.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import navdrawer.fjarquellada.es.secc08navdrawer.R;
import navdrawer.fjarquellada.es.secc08navdrawer.fragment.AlertFragment;
import navdrawer.fjarquellada.es.secc08navdrawer.fragment.EmailFragment;
import navdrawer.fjarquellada.es.secc08navdrawer.fragment.InfoFragment;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.drawerLayout = findViewById(R.id.drawer_layout);
        this.navigationView = findViewById(R.id.navigation_view);

        this.toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        this.navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                boolean fragmentTransaction = false;
                Fragment fragment = null;

                switch(item.getItemId()){
                    case R.id.item_mail:
                        fragment = new EmailFragment();
                        fragmentTransaction = true;
                        break;
                    case R.id.item_alert:
                        fragment = new AlertFragment();
                        fragmentTransaction = true;
                        break;
                    case R.id.item_info:
                        fragment = new InfoFragment();
                        fragmentTransaction = true;
                        break;
                    case R.id.item_opcion_01:
                        Toast.makeText(MainActivity.this, "Pulsada la opción 01", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.item_opcion_02:
                        Toast.makeText(MainActivity.this, "Pulsada la opción 02", Toast.LENGTH_LONG).show();
                        break;
                }

                if(fragmentTransaction){
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.content_frame, fragment)
                            .commit();
                    item.setChecked(true);
                    getSupportActionBar().setTitle(item.getTitle());
                    drawerLayout.closeDrawers();
                }

                return true;
            }
        });

        setFragmentByDefault();
    }

    private void setFragmentByDefault(){
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new EmailFragment()).commit();
        MenuItem item = this.navigationView.getMenu().getItem(0);
        item.setChecked(true);
        getSupportActionBar().setTitle(item.getTitle().toString());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        boolean res = true;

        switch(item.getItemId()){
            case android.R.id.home:
                this.drawerLayout.openDrawer(GravityCompat.START);
                break;
            default:
                res = super.onOptionsItemSelected(item);

        }
        return res;

    }
}
