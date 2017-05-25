package com.example.india.myapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class mcqRadioGroupAdapter extends ArrayAdapter<mcqoption> {

    Context context;
    int layoutResourceId;
    mcqoption data[] = null;

    public mcqRadioGroupAdapter(Context context, int layoutResourceId,
                                mcqoption[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        MatrixHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new MatrixHolder();
            holder.txtTitle = (TextView) row.findViewById(R.id.heading);
            holder.group = (RadioGroup) row.findViewById(R.id.radio_group1);
            final RadioButton[] rb = new RadioButton[4];
            for(int i=0; i<4; i++){
                rb[i]  = new RadioButton(context);
                //rb[i].setButtonDrawable(R.drawable.single_radio_chice);
                rb[i].setId(i);
                RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(
                        0, LayoutParams.WRAP_CONTENT);
                params.weight=1.0f;
                params.setMargins(15, 0, 5, 10);
                holder.group.addView(rb[i],params); //the RadioButtons are added to the radioGroup instead of the layout
            }
            row.setTag(holder);
        } else {
            holder = (MatrixHolder) row.getTag();
        }

        mcqoption option = data[position];
        holder.txtTitle.setText(option.title);
        return row;
    }

    static class MatrixHolder {
        TextView txtTitle;
        RadioGroup group;
        int position;
    }
}
