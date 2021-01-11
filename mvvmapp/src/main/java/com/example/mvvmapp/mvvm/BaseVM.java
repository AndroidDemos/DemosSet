package com.example.mvvmapp.mvvm;

import org.jetbrains.annotations.NotNull;

import java.lang.ref.WeakReference;

/**
 * Author: Zeus
 * Date: 2020/7/13 15:44
 * Description:
 * History:
 */
public class BaseVM<V extends IBaseView> implements IBaseVM {

    private WeakReference<IBaseView> mVWeakReference;

    @Override
    public void attachView(@NotNull IBaseView view) {
        mVWeakReference = new WeakReference<>(view);
    }

    @Override
    public void detachView() {
        if (mVWeakReference != null) {
            mVWeakReference.clear();
            mVWeakReference = null;
        }
    }

    @NotNull
    @Override
    public IBaseView getIView() {
        if (mVWeakReference != null) {
            return mVWeakReference.get();
        }
        return null;
    }
}
