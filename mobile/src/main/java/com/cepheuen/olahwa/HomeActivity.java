package com.cepheuen.olahwa;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.cepheuen.olahwa.fragments.BookingFragment;
import com.cepheuen.olahwa.fragments.MusicFragment;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

public class HomeActivity extends AppCompatActivity {

    private IProfile profile = new ProfileDrawerItem().withName("Bruce Wayne").withEmail("bruce@wayne.com").withIcon(R.drawable.profile6).withIdentifier(105).withSelectedColorRes(R.color.dark_grey);
    private AccountHeader headerResult;
    private Drawer result = null;
    private FragmentTransaction ft;
    private int currentID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ft = getSupportFragmentManager().beginTransaction();

        headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header)
                .addProfiles(profile)
                .withSavedInstance(savedInstanceState)
                .build();

        result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withSliderBackgroundColorRes(R.color.primary_text)
                .withTranslucentStatusBar(true)
                .withActionBarDrawerToggle(true)
                .withAccountHeader(headerResult)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("Dashboard").withDescription("See how you fare").withIcon(GoogleMaterial.Icon.gmd_dashboard).withIconColorRes(R.color.half_white).withIdentifier(1).withSelectedColorRes(R.color.dark_grey).withTextColorRes(R.color.half_white),
                        new PrimaryDrawerItem().withName("Book").withDescription("Book a cab now").withIcon(GoogleMaterial.Icon.gmd_book).withIconColorRes(R.color.half_white).withIdentifier(2).withSelectedColorRes(R.color.dark_grey).withTextColorRes(R.color.half_white),
                        new PrimaryDrawerItem().withName("OlaCron").withDescription("Schedule daily cabs").withIcon(GoogleMaterial.Icon.gmd_access_alarm).withIconColorRes(R.color.half_white).withIdentifier(3).withSelectedColorRes(R.color.dark_grey).withTextColorRes(R.color.half_white),
                        new PrimaryDrawerItem().withName("OlaUnite").withDescription("Share a ride for good karma").withIcon(GoogleMaterial.Icon.gmd_directions_car).withIconColorRes(R.color.half_white).withIdentifier(4).withSelectedColorRes(R.color.dark_grey).withTextColorRes(R.color.half_white),
                        new PrimaryDrawerItem().withName("OlaJam").withDescription("Your jam, throughout the ride").withIcon(GoogleMaterial.Icon.gmd_library_music).withIconColorRes(R.color.half_white).withIdentifier(5).withSelectedColorRes(R.color.dark_grey).withTextColorRes(R.color.half_white)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        //check if the drawerItem is set.
                        //there are different reasons for the drawerItem to be null
                        //--> click on the header
                        //--> click on the footer
                        //those items don't contain a drawerItem

                        if (drawerItem != null) {
                            if (drawerItem.getIdentifier() != currentID) {
                                if (drawerItem.getIdentifier() == 5) {
                                    currentID = 5;
                                    getSupportActionBar().setTitle("OlaJam");
                                    ft.add(R.id.container, MusicFragment.newInstance()).commit();
                                } else if (drawerItem.getIdentifier() == 1) {
                                    currentID = 1;
                                    getSupportActionBar().setTitle("Dashboard");
                                    // ft.replace(R.id.container, MusicFragment.newInstance());
                                } else if (drawerItem.getIdentifier() == 2) {
                                    currentID = 2;
                                    getSupportActionBar().setTitle("Book");
                                    ft.add(R.id.container, BookingFragment.newInstance()).commit();
                                } else if (drawerItem.getIdentifier() == 3) {
                                    currentID = 3;
                                    getSupportActionBar().setTitle("OlaCron");
                                    //ft.replace(R.id.container, MusicFragment.newInstance());
                                } else if (drawerItem.getIdentifier() == 4) {
                                    currentID = 4;
                                    getSupportActionBar().setTitle("OlaUnite");
                                    //ft.replace(R.id.container, MusicFragment.newInstance());
                                }
                            }
                        }

                        return false;
                    }
                })
                .build();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //add the values which need to be saved from the drawer to the bundle
        outState = result.saveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
