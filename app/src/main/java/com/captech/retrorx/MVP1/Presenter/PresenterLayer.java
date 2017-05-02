package com.captech.retrorx.MVP1.Presenter;

import com.captech.retrorx.ImenufrInterface.Error;
import com.captech.retrorx.MVP1.Model.Model;
import com.captech.retrorx.MVP1.ResponseModel.FriendResponse;
import com.captech.retrorx.MVP1.View.ActivityView;

import io.reactivex.disposables.CompositeDisposable;


/**
 * Created by cteegarden on 1/28/16.
 */
@SuppressWarnings("unchecked")
public class PresenterLayer implements PresenterInteractor, Error {

    private ActivityView view;
    private CompositeDisposable mCompositeDisposable;


    public PresenterLayer(ActivityView view) {
        this.view = view;

        mCompositeDisposable = new CompositeDisposable();

    }

    public void loadRxData(String token, int page_no) {
        view.showProgress();
        Model model = new Model(this);
        model.loadData(token, page_no);

    }

    @Override
    public void onDestroy() {
        mCompositeDisposable.clear();
        view=null;
    }

    @Override
    public void onSuccess(FriendResponse friendResponse) {
        if (view != null) {
            view.hideProgress();
            view.onSuccess(friendResponse);
        }
    }



    @Override
    public void onNoInternetConnection() {
        if (view != null) {
            view.hideProgress();
            view.onNoInternetConnection();

        }
    }

    @Override
    public void onRequestTimeOut() {
        if (view != null) {
            view.onRequestTimeOut();

        }
    }

    @Override
    public void onServerNotResponding() {
        if (view != null) {
            view.hideProgress();
            view.onServerNotResponding();

        }
    }

    @Override
    public void onSomethingWentWrong() {
        if (view != null) {
            view.hideProgress();
            view.onSomethingWentWrong();

        }
    }
}
