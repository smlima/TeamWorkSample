package com.slima.teamworksample.dagger;

import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by sergio.lima on 07/10/2017.
 */

@Qualifier
@Retention(RUNTIME)
public @interface AppContext {
}