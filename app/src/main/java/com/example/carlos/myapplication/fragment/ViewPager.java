package com.example.carlos.myapplication.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carlos.myapplication.R;
import com.example.carlos.myapplication.adapter.ViewPagerSectionsAdapter;
import com.example.carlos.myapplication.util.Util;

/**
 * Created by Deryan Cruz on 6/22/2018.
 */

public class ViewPager extends Fragment {


    View vista;
    private AppBarLayout appBar;
    private TabLayout pestanas;
    private android.support.v4.view.ViewPager viewPager;
    private static String dato;

    public ViewPager() {
        // Required empty public constructor
    }

    public static ViewPager newInstance(String param) {
        ViewPager fragment = new ViewPager();
        dato = param;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista=inflater.inflate(R.layout.fragment_view_pager, container, false);

        if(Util.rotacion==0){
            View parent= (View) container.getParent();

            if(appBar==null){
                appBar=  parent.findViewById(R.id.appBar);
                pestanas=new TabLayout(getActivity());
                pestanas.setTabTextColors(Color.parseColor("#FFFFFF"),Color.parseColor("#FFFFFF"));
                appBar.addView(pestanas);


                viewPager=  vista.findViewById(R.id.idViewPagerInformacion);
                llenarViewPager(viewPager);
                viewPager.addOnPageChangeListener(new android.support.v4.view.ViewPager.SimpleOnPageChangeListener(){
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                        super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                    }
                });
                pestanas.setupWithViewPager(viewPager);
            }
            pestanas.setTabGravity(TabLayout.GRAVITY_FILL);
        }else{
            Util.rotacion=1;
        }

        return vista;

    }

    private void llenarViewPager(android.support.v4.view.ViewPager viewPager) {
        ViewPagerSectionsAdapter adapter = new ViewPagerSectionsAdapter(getFragmentManager());
        adapter.addFragment(new InicioFragment(),"Inicio");
        adapter.addFragment(new PerfilFragment(),"Perfil");
        adapter.addFragment(new NotificationFragment(),"Notificaciones");
        adapter.addFragment(new BuscarFragment(),"Burcar");
        viewPager.setAdapter(adapter);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(Util.rotacion==0){
            appBar.removeView(pestanas);
        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

}
