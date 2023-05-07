package com.example.robinsprojekt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<String[]> mData;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textView1;
        public TextView textView2;

        public ViewHolder(View view) {
            super(view);
            textView1 = (TextView) view.findViewById(R.id.text_view1);
            textView2 = (TextView) view.findViewById(R.id.text_view2);
        }

        public void bindData(String data1, String data2) {
            textView1.setText(data1);
            textView2.setText(data2);
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param myDataset String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<String[]> myDataset) {
        mData = myDataset;
    }

    public void setData(List<String[]> data) {
        mData = data;
        notifyDataSetChanged();
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        String[] itemData = mData.get((position));
        holder.bindData(itemData[0], itemData[1]);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mData.size();
    }
}
