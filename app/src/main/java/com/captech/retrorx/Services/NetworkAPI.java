package com.captech.retrorx.Services;

import com.captech.retrorx.MVP1.ResponseModel.FriendResponse;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by android on 2/5/17.
 */

public interface NetworkAPI {


    @POST("get_friends/{page_no}")//real endpoint
    Call<FriendResponse> getFriends();


    @POST("get_friends/{page_no}") //real endpoint
    Observable<FriendResponse> getFriendsObservable(@Header("token") String token, @Path("page_no") Integer page_no);

}
