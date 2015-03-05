package com.tredolf.demo.ieee754converter;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import IEEE754.*;


public class MainActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    private int mode;

    private EditText iNum;
    private TextView hHex, lSign,sSign, lExp, eExp, lNum, nNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set fields

        iNum = (EditText) findViewById(R.id.number);

        hHex = (TextView) findViewById(R.id.hexadecimal);

        lSign = (TextView) findViewById(R.id.id_sign);
        lExp = (TextView) findViewById(R.id.id_exponent);
        lNum = (TextView) findViewById(R.id.id_significant);

        sSign = (TextView) findViewById(R.id.sign);
        eExp = (TextView) findViewById(R.id.exponent);
        nNum = (TextView) findViewById(R.id.significant);

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                .commit();
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mode = 1;
                mTitle = getString(R.string.title_float);
                setBinaryView();
                break;
            case 2:
                mode = 2;
                mTitle = getString(R.string.title_double);
                setBinaryView();
                break;
            case 3:
                mode = 3;
                mTitle = getString(R.string.title_binary);
                setDecimalView();
                break;
        }
    }

    private void setDecimalView(){
        lSign.setVisibility(View.INVISIBLE);
        lExp.setVisibility(View.INVISIBLE);
        sSign.setVisibility(View.INVISIBLE);
        eExp.setVisibility(View.INVISIBLE);

        lNum.setText("Decimal");
        nNum.setText("Decimal");
    }

    private void setBinaryView(){
        lSign.setVisibility(View.VISIBLE);
        lExp.setVisibility(View.VISIBLE);
        sSign.setVisibility(View.VISIBLE);
        eExp.setVisibility(View.VISIBLE);

        lNum.setText("Significant");
        nNum.setText("Significant");
    }

    private void floatConversion(){
        IEEE754 entry= new Float32(Float.valueOf(iNum.getText().toString()));
        hHex.setText(entry.toHexadecimal());

        String binary = entry.toBinaryString();
        sSign.setText(binary.substring(0,1));
        eExp.setText(binary.substring(1,9));
        nNum.setText(binary.substring(9));
    }

    private void doubleConversion(){
        IEEE754 entry= new Double64(Double.valueOf(iNum.getText().toString()));
        hHex.setText(entry.toHexadecimal());

        String binary = entry.toBinaryString();
        sSign.setText(binary.substring(0,1));
        eExp.setText(binary.substring(1,12));
        nNum.setText(binary.substring(12));
    }

    private void binaryConversion(){
        if(!binaryValidate()){
            nNum.setText("Wrong Input Number");
        } else {
            IEEE754 entry;
            if(iNum.getText().toString().length()<=32){
                entry = new DWord(iNum.getText().toString());
                nNum.setText(entry.getDecimal32().toString());
            } else {
                entry = new QWord(iNum.getText().toString());
                nNum.setText(entry.getDecimal64().toString());
            }
            hHex.setText(entry.toHexadecimal());
        }
    }

    private void conversion(){
        try {
            switch (mode) {
                case 1:
                    floatConversion();
                    break;
                case 2:
                    doubleConversion();
                    break;
                case 3:
                    binaryConversion();
                    break;
                default:
                    break;
            }
        }catch(Exception e){

        }
    }

    private boolean binaryValidate(){
        String regex = "[01]*";
        String str = iNum.getText().toString();
        if(str.matches(regex) && str.length()<=64){
            return true;
        }
        return false;
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
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

        if (item.getItemId() == R.id.action_convert) {
            conversion();
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }

}
