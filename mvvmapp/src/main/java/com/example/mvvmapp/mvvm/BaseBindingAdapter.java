package com.example.mvvmapp.mvvm;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Author: Zeus
 * Date: 2020/7/13 15:48
 * Description:
 * History:
 */
abstract class BaseBindingAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    public List<T> mDataList;
    public Context mContext;

    public BaseBindingAdapter(List<T> mDataList, Context mContext) {
        this.mDataList = mDataList;
        this.mContext = mContext;
    }


    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return onCreateVH(parent, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }


    public void onRefreshData(List<T> list) {
        if (mDataList != null) {
            mDataList.clear();
            mDataList.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void onLoadMoreData(List<T> list) {
        if (mDataList != null && list != null) {
            mDataList.addAll(list);
            notifyDataSetChanged();
        }
    }

    public abstract VH onCreateVH(ViewGroup parent, int viewType);

    public abstract void onBindVH(VH holder, int position);
}
