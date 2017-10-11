package com.slima.teamworksample.modules.viewmodels;

import android.databinding.Bindable;
import android.util.Log;

import com.slima.teamworksample.BR;
import com.slima.teamworksample.core.models.Account;
import com.slima.teamworksample.core.repositories.RepositoryCallback;
import com.slima.teamworksample.core.services.NetworkService;
import com.slima.teamworksample.core.viewmodels.components.BaseComponentViewModel;
import com.slima.teamworksample.modules.components.AccountDetailsComponent;

/**
 * Created by sergio.lima on 07/10/2017.
 */

public class AccountDetailsViewModel extends BaseComponentViewModel<AccountDetailsComponent> {

    private final NetworkService mNetworkService;

    private Account mAccount;
    private boolean mIsLoading = false;

    public AccountDetailsViewModel(NetworkService networkService) {
        super();
        mNetworkService = networkService;
    }

    @Override
    public void setBaseComponent(AccountDetailsComponent baseComponent) {
        super.setBaseComponent(baseComponent);
        setLoading(true);
        mNetworkService.getAccountDetails(new RepositoryCallback<Account>() {
            @Override
            public void onSuccess(Account value) {
                setAccount(value);
                setLoading(false);
                Log.d(TAG, "onSuccess: " + mAccount.id);
            }

            @Override
            public void onError(Throwable throwable) {
                mAccount = null;
                setLoading(false);

            }
        });
    }

    public void setAccount(Account account) {
        mAccount = account;
        notifyPropertyChanged(BR.account);
    }

    @Bindable
    public Account getAccount() {
        return mAccount;
    }

}
