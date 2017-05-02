package com.captech.retrorx.MVP1.Presenter;

import com.captech.retrorx.MVP1.ResponseModel.FriendResponse;

/**
 * Created by cteegarden on 2/1/16.
 */
public interface PresenterInteractor {
    void loadRxData(String token,int page_no);
    void onDestroy();
    void onSuccess(FriendResponse friendResponse);
}
