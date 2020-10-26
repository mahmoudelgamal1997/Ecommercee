package com.example.elgaml.ecommerce.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.elgaml.ecommerce.R;
import com.example.elgaml.ecommerce.model.MyAccountModel.MyAccountItem;

import java.util.List;

public class MyAccountAdapter  extends BaseAdapter {

    private List<MyAccountItem> list;
    private Context context;
    public MyAccountAdapter(){

    }

    public MyAccountAdapter(List<MyAccountItem> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=inflater.inflate(R.layout.accountlist_first,null,true);

        TextView iconAccount = (TextView)view.findViewById(R.id.icon_account);
        TextView titleAccount = view.findViewById(R.id.title_account);
        TextView nextIcon = (TextView)view.findViewById(R.id.title_account);


        return row;

    }
}
