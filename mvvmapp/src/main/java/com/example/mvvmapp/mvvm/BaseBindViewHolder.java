package com.example.mvvmapp.mvvm;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Author: Zeus
 * Date: 2020/7/13 16:47
 * Description:
 * History:
 */
class BaseBindViewHolder extends RecyclerView.ViewHolder {
    ViewDataBinding mDataBinding;

    public BaseBindViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.mDataBinding = binding;
    }
}
