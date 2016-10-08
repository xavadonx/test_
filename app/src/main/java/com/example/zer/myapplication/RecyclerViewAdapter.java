package com.example.zer.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<String> strings;

    public RecyclerViewAdapter(Context context, List<String> records) {
        this.strings = records;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = layoutInflater.inflate(R.layout.list_item, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.name.setText(strings.get(i));
    }

    @Override
    public int getItemCount() {
        return strings.size();
    }

    interface IOnItemClickListener {
        void onItemClickListener(int position);
    }

    private IOnItemClickListener listener;

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;

        public ViewHolder(View item) {
            super(item);
            listener = (IOnItemClickListener) context;
            name = (TextView) item.findViewById(R.id.textView);
            name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClickListener(getAdapterPosition());
                }
            });
        }
    }
}
