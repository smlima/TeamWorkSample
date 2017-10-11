package com.slima.teamworksample.core.services;

import android.content.Context;

import com.slima.teamworksample.dagger.AppContext;

import javax.inject.Inject;

import dagger.Provides;
import dagger.Reusable;

/**
 * Created by sergio.lima on 07/10/2017.
 */
public class ResourcesService {

    private final Context mContext;

    public ResourcesService(Context context) {
        mContext = context;
    }

    public String getString(int resourceId){
        return mContext.getResources().getString(resourceId);
    }

    public String getString(int resourceId, Object ...args){
        return mContext.getResources().getString(resourceId, args);
    }

    public int getColor(int id){
        return mContext.getResources().getColor(id);
    }
}
