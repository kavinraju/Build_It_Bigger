package com.udacity.gradle.builditbigger.paid.WheelUtils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.udacity.gradle.builditbigger.R;

import java.util.List;

import github.hellocsl.cursorwheel.CursorWheelLayout;

public class WheelAdapter extends CursorWheelLayout.CycleWheelAdapter {

    private List<WheelMenuItem> wheelMenuItemList;
    private LayoutInflater layoutInflater;
    private Context context;
    public static final int INDEX_SPEC = 9;
    private int gravity;

    public WheelAdapter(List<WheelMenuItem> wheelMenuItemList, Context context, int gravity) {
        this.wheelMenuItemList = wheelMenuItemList;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.gravity = gravity;
    }

    @Override
    public int getCount() {
        if (wheelMenuItemList != null){
            return wheelMenuItemList.size();
        }else {
            return 0;
        }
    }

    @Override
    public View getView(View parent, int position) {

        WheelMenuItem wheelMenuItem = getItem(position);
        View rootView = layoutInflater.inflate(R.layout.wheel_menu_item, null, false);
        TextView tv_number = rootView.findViewById(R.id.tv_wheel_menu_item);
        tv_number.setVisibility(View.VISIBLE);
        tv_number.setText(wheelMenuItem.title);
        return rootView;
    }

    @Override
    public WheelMenuItem getItem(int position) {
        return  wheelMenuItemList.get(position);
    }
}
