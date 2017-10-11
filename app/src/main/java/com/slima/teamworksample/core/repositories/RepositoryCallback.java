package com.slima.teamworksample.core.repositories;

/**
 * Created by sergio.lima on 07/10/2017.
 */

public interface RepositoryCallback<T> {

    void onSuccess(T value);

    void onError(Throwable throwable);
}
