package com.slima.teamworksample.core.viewmodels;

/**
 * Created by sergio.lima on 11/10/2017.
 */

public abstract class ItemViewModel<T> extends BaseViewModel {

    private T mItem;

    public void setItem(T item) {
        mItem = item;
    }

    public ItemViewModel(){

    }

    public ItemViewModel(T item) {
        mItem = item;
    }

    public T getItem() {
        return mItem;
    }

}
