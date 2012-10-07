package com.tapink.doctornfc.adapters;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tapink.doctornfc.R;
import com.tapink.doctornfc.patients.Prescription;

public class PrescriptionAdapter extends BaseAdapter {

  private Context mContext;
  private List<Prescription> mItems = new ArrayList<Prescription>();
  private LayoutInflater mLayoutInflater;


  public PrescriptionAdapter(Context context) {
    mContext = context;
    mLayoutInflater = LayoutInflater.from(mContext);
  }

  @Override
  public int getCount() {
    return mItems.size();
  }


  @Override
  public Object getItem(int position) {
    return mItems.get(position);
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    if (convertView == null) {
      convertView = mLayoutInflater.inflate(R.layout.row_prescription, parent, false);
    }

    TextView name = (TextView) convertView.findViewById(R.id.name);
    TextView tablets = (TextView) convertView.findViewById(R.id.tablets);

    name.setText(mItems.get(position).medication_name);
    tablets.setText(String.valueOf(mItems.get(position).tablets));

    return convertView;
  }

  /**
   * Sets the list of items for this adapter to use.
   */
  public void setListItems(List<Prescription> it) {
    mItems = it;
  }

}
