package com.example.carlos.myapplication.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Deryan Cruz on 6/23/2018.
 */

public class ViewPagerSectionsAdapter extends FragmentStatePagerAdapter {
    private final List<Fragment> listaFragments=new ArrayList<>();
    private final List<String> listaTitulos=new ArrayList<>();

    public ViewPagerSectionsAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Fragment fragment,String titulo){
        listaFragments.add(fragment);
        listaTitulos.add(titulo);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return listaTitulos.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return listaFragments.get(position);
    }

    @Override
    public int getCount() {
        return listaFragments.size();
    }
}
