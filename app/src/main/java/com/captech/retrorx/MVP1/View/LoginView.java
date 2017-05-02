package com.captech.retrorx.MVP1.View;

import com.captech.retrorx.ImenufrInterface.Progress;
import com.captech.retrorx.MVP1.ResponseModel.FriendResponse;

/**
 * Created by android on 2/5/17.
 */

public interface LoginView extends Progress{
 public void onSuccess(FriendResponse friendResponse);


}
