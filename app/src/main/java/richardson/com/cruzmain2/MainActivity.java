package richardson.com.cruzmain2;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity
    implements ShipListFragment.OnShipSelectedListener{
    ActionBarDrawerToggle mDrawerToggle;
    ListView mDrawerListView;
    String[] mDrawerItems;
    DrawerLayout mDrawerLayout;
    CharSequence mTitle = "Hello World";

    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setup toggle button.
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this,
                mDrawerLayout, R.string.drawer_open, R.string.drawer_close){

            //disable the arrow animation

            @Override
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                super.onDrawerSlide(drawerView, 0); // this disables the arrow @ completed state
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, 0); // this disables the animation
            }
        };


        mDrawerItems = getResources().getStringArray(R.array.drawer_items);


        mDrawerLayout.setDrawerListener(mDrawerToggle);

        //put list items into the drawer list
        mDrawerListView = (ListView)findViewById(R.id.drawer_list_view);
        mDrawerListView.setAdapter(new ArrayAdapter<>(
                this, R.layout.menu_drawer_item, mDrawerItems));
        mDrawerListView.setOnItemClickListener(new DrawerItemClickListener());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setHomeButtonEnabled(true);
    }

    @Override
    public void onShipSelected(Ship ship){
        setTitle("Carnival " + ship.getShipName());
        startShipDetailFragment(ship);

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState){
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        return (mDrawerToggle.onOptionsItemSelected(item)
                || super.onOptionsItemSelected(item));
     }

    private void selectItem(int position){
        mDrawerListView.setItemChecked(position, true);
        setTitle(mDrawerItems[position]);
        mDrawerLayout.closeDrawer(mDrawerListView);

        //start the new fragment
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        switch(position){
            case 0:
                ft.replace(R.id.container, new ShipListFragment());
                ft.commit();
                break;
            case 1:
                ft.replace(R.id.container, new DestinationsListFragment());
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.container, new NewsFragment());
                ft.commit();
                break;
            case 3:
                ft.replace(R.id.container, new PromotionsFragment());
                ft.commit();
                break;
            default:
                break;

        }
    }

    @Override
    public void setTitle(CharSequence title){
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            selectItem(position);

        }
    }

    public void startShipDetailFragment(Ship ship){
        ShipDetailFragment shipDetailFrag = new ShipDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable("ship", ship);
        shipDetailFrag.setArguments(args);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, shipDetailFrag);
        transaction.addToBackStack(null);
        transaction.commit();

    }

}