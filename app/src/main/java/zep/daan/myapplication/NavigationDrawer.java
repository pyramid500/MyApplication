package zep.daan.myapplication;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import static zep.daan.myapplication.R.id.search;

public class NavigationDrawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        final NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        if (savedInstanceState == null) {
            navigationView.getMenu().performIdentifierAction(R.id.nav_voorpagina, 0);
            navigationView.getMenu().getItem(0).setChecked(true);

        }




        ViewPager pager = (ViewPager) findViewById(R.id.content_frame);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        pager.setOffscreenPageLimit(3);

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                         toolbar.setTitle("Headlines");
                         navigationView.getMenu().getItem(0).setChecked(true);
                        return;
                    case 1:
                        toolbar.setTitle("Binnenland");
                        navigationView.getMenu().getItem(1).setChecked(true);
                        return;
                    case 2:
                        toolbar.setTitle("Buitenland");
                        navigationView.getMenu().getItem(2).setChecked(true);
                        return;
                    case 3:
                        toolbar.setTitle("Politiek");
                        navigationView.getMenu().getItem(3).setChecked(true);
                        return;
                    case 4:
                        toolbar.setTitle("Economie");
                        navigationView.getMenu().getItem(4).setChecked(true);
                        return;
                    case 5:
                        toolbar.setTitle("Technologie");
                        navigationView.getMenu().getItem(5).setChecked(true);
                        return;
                    case 6:
                        toolbar.setTitle("Entertainment");
                        navigationView.getMenu().getItem(6).setChecked(true);
                        return;
                    case 7:
                        toolbar.setTitle("Sport");
                        navigationView.getMenu().getItem(7).setChecked(true);
                        return;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));
        searchView.setQueryHint("Zoek een artikel");
        searchView.setSubmitButtonEnabled(false);
        searchView.setIconifiedByDefault(true);// Do not iconify the widget; expand it by default

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        ViewPager pager = (ViewPager) findViewById(R.id.content_frame);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_voorpagina) {
            // Handle the camera action
            pager.setCurrentItem(0);
        } else if (id == R.id.nav_binnenland) {
            pager.setCurrentItem(1);
        } else if (id == R.id.nav_buitenland) {
            pager.setCurrentItem(2);
        } else if (id == R.id.nav_politiek) {
            pager.setCurrentItem(3);
        } else if (id == R.id.nav_economie) {
            pager.setCurrentItem(4);
        } else if (id == R.id.nav_technologie) {
            pager.setCurrentItem(5);
        } else if (id == R.id.nav_entertainment) {
            pager.setCurrentItem(6);
        }else if (id == R.id.nav_sport) {
            pager.setCurrentItem(7);
        } else if (id == R.id.instellingen) {
            Intent instellingenIntent = new Intent(this, SettingsActivity.class);
            startActivity(instellingenIntent);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int pos) {

            switch (pos) {
                case 0:
                    return new FrontpageFragment();
                case 1:
                    return new BinnenlandFragment();
                case 2:
                    return new BuitenlandFragment();
                case 3:
                    return new PolitiekFragment();
                case 4:
                    return new EconomieFragment();
                case 5:
                    return new TechnologieFragment();
                case 6:
                    return new EntertainmentFragment();
                case 7:
                    return new SportFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 8;
        }

    }



}
