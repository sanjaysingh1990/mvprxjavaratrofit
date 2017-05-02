package com.captech.retrorx.MVP1.Model;

import android.util.Log;

import com.captech.retrorx.MVP1.Presenter.PresenterLayer;
import com.captech.retrorx.MVP1.ResponseModel.FriendResponse;
import com.captech.retrorx.Services.NetworkService;

import java.io.IOException;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;

/**
 * Created by android on 2/5/17.
 */

public class Model {

    private PresenterLayer presenterLayer;

    public Model(PresenterLayer presenterLayer) {
        this.presenterLayer = presenterLayer;
    }

    public void loadData(String token, int page_no) {
        NetworkService.getInstance().getmCompositeDisposable().clear();
        NetworkService.getInstance().getmCompositeDisposable().add(com.captech.retrorx.Services.NetworkService.getInstance().getAPI().getFriendsObservable(token, page_no)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError));
    }

    public void handleResponse(FriendResponse friendrespone) {
        presenterLayer.onSuccess(friendrespone);
    }

    public void handleError(Throwable error) {

        if (error instanceof HttpException) {
            // We had non-2XX http error
            Log.e("httperror", ((HttpException) error).code() + "");
            presenterLayer.onServerNotResponding();
        } else if (error instanceof IOException) {
            // A network or conversion error happened
            Log.e("ioerror", ((IOException) error).getLocalizedMessage() + "");
            presenterLayer.onNoInternetConnection();
        } else {
            presenterLayer.onNoInternetConnection();
        }

    }


}
