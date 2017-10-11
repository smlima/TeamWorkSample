package com.slima.teamworksample.core.views.adapters;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.slima.teamworksample.application.TeamWorkSampleApplication;
import com.squareup.picasso.LruCache;
import com.squareup.picasso.Picasso;

import java.util.concurrent.Executors;

/**
 * Created by sergio.lima on 07/10/2017.
 */

public class BindingAdapters {

    static public Picasso mPicassoInstance;

    // static init of the picasso instance...
    // could be provided through the ioc but this adapter is just for static methods
    static {
        mPicassoInstance = new Picasso.Builder(TeamWorkSampleApplication.getInstance())
                .executor(Executors.newCachedThreadPool())
                .memoryCache(new LruCache(10))
                .build();
    }

    @BindingAdapter("thumbnailUrl")
    public static void setImageUrl(ImageView imageView, String url){

        if (imageView != null ) {
            mPicassoInstance
                    .load(url)
                    .fit()
                    .error(android.R.drawable.ic_dialog_alert)
                    .placeholder(android.R.drawable.ic_menu_camera)
                    .into(imageView);
        }
    }

//    @BindingAdapter(value = {"itemView", "items"}, requireAll = false)
//    public static <T> void setAdapter(
//            RecyclerView recyclerView,
//            ItemViewArg<T> arg,
//            List<T> items) {
//
//        if (arg == null) {
//            throw new IllegalArgumentException("itemView must not be null");
//        }
//
//        ListRecylerViewAdapter<T> adapter = (ListRecylerViewAdapter<T>) recyclerView.getAdapter();
//        if (adapter == null) {
//            adapter = new ListRecylerViewAdapter<>(arg);
//            recyclerView.setAdapter(adapter);
//        }
//
//        adapter.setItems(items);
//
//        adapter.notifyDataSetChanged();
//        adapter.notifyItemRangeChanged(0, 8);
//    }
}
