package com.kky.example.mui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kky.example.R;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

/**
 * @author Zeus QQ:1946690608
 * @name DemosSet
 * @time 2018/5/25 15:39
 * @change time
 * @class describe
 */
public class MyAdapter extends RecyclerView.Adapter {
    private List<String> mData;
    protected onItemClickListener mOnItemClickLitsener;

    public void setOnItemClickLitsener(onItemClickListener itemClickLitsener) {
        this.mOnItemClickLitsener = itemClickLitsener;
    }

    public void setData(List<String> data) {
        mData = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.mTextView.setText(mData.get(position));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickLitsener != null) {
                    mOnItemClickLitsener.onItemClick(v, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.text_content);
        }
    }

    public interface onItemClickListener {
        public void onItemClick(View view, int position);
    }

}
