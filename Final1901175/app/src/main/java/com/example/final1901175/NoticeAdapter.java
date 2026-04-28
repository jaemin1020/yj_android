package com.example.final1901175;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NoticeAdapter extends RecyclerView.Adapter <NoticeAdapter.noticeViewHolder> {
    clickListener updateClickListener;
    clickListener deleteClickListener;
    public ArrayList<NoticeVO> items = new ArrayList<NoticeVO>();
    @NonNull
    @Override
    public NoticeAdapter.noticeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.activity_notice,parent,false);
        return new noticeViewHolder(itemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull NoticeAdapter.noticeViewHolder holder, int position) {
        NoticeVO item = items.get(position);
        holder.setItemValues(item);
    }
    public void setDeleteClickListener(clickListener clickListener){
        deleteClickListener = clickListener;
    }
    private void deleteNotice(int position) {
        deleteClickListener.onItemclick(items.get(position));
    }
    public void setUpdateClickListener(clickListener clickListener){
        updateClickListener = clickListener;
    }
    private void updateNotice(int position) {
        updateClickListener.onItemclick(items.get(position));
    }
    @Override
    public int getItemCount() {
        return items.size();
    }
    class noticeViewHolder extends RecyclerView.ViewHolder{
        TextView nameTv;
        TextView numTv;
        Button updateBtn;
        Button deleteBtn;
        public noticeViewHolder(@NonNull View view,NoticeAdapter adapter) {
            super(view);
            nameTv = view.findViewById(R.id.nameTv);
            numTv = view.findViewById(R.id.numTv);
            updateBtn = view.findViewById(R.id.updateBtn);
            updateBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    adapter.updateNotice(position);
                }
            });
            deleteBtn = view.findViewById(R.id.delBtn);
            deleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    adapter.deleteNotice(position);
                }
            });
        }
        public void setItemValues(NoticeVO item) {
            nameTv.setText(item.getName());
            numTv.setText(item.getNumber());
        }
    }
}
