package com.slima.teamworksample.core.repositories;

import android.os.AsyncTask;
import android.util.Log;

import java.util.concurrent.Executors;

/**
 * Created by sergio.lima on 07/10/2017.
 */

public abstract class RepositoryCallbackAsyncTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {

    private static final String TAG = "RepositoryCallbackAsyncTask";

    private final RepositoryCallback<Result> mCallback;

    public RepositoryCallbackAsyncTask(RepositoryCallback<Result> callback) {
        mCallback = callback;
    }

    @Override
    protected Result doInBackground(Params... params) {

        try{
            return doStuff(params);
        } catch (Exception e){
            Log.e(TAG, "Error on doStuff() ", e);
            if (mCallback != null){
                mCallback.onError(e);
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(Result result) {
        if (mCallback != null) {
            mCallback.onSuccess(result);
        } else {
            Log.e(TAG, "The callback is Null");
        }
    }

    protected abstract Result doStuff(Params... params) throws Exception;

    public void executeOnThreadPool() {
        super.executeOnExecutor(Executors.newCachedThreadPool());
    }
}