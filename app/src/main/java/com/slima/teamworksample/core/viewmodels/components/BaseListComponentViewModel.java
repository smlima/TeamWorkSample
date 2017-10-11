package com.slima.teamworksample.core.viewmodels.components;

import android.databinding.Bindable;

import com.slima.teamworksample.BR;
import com.slima.teamworksample.core.components.ui.UIBaseComponent;
import com.slima.teamworksample.core.viewmodels.ItemViewModel;
import com.slima.teamworksample.core.views.adapters.ListWrapper;

import java.util.List;

import me.tatarka.bindingcollectionadapter2.OnItemBind;

/**
 * Created by sergio.lima on 11/10/2017.
 */

public abstract class BaseListComponentViewModel<T extends UIBaseComponent, K extends ItemViewModel> extends BaseComponentViewModel<T> {

    private ListWrapper mListItems;


    @Bindable
    public List getListItems() {
        if (mListItems == null){
            return null;
        }
        return (List<K>) mListItems.getWrapperList();
    }

    public void setListItems(ListWrapper projectList) {
        mListItems = projectList;
        notifyPropertyChanged(BR.listItems);
    }

    public OnItemBind<K> getItemBinding() {
        return null;
    }


//    public OnItemBind<K> getItemBinding() {
//        // TODO: simplify....
//        return new OnItemBind<K>() {
//            @Override
//            public void onItemBind(ItemBinding itemBinding, int position, K item) {
//               onItemBindCustom(itemBinding, position, item);
//            }
//        };
//    }

//    public abstract void onItemBindCustom(ItemBinding itemBinding, int position, ItemViewModel item);
}
