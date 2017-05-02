package com.captech.retrorx.ImenufrInterface;

/**
 * Created by android on 2/5/17.
 */

public interface Error {
    void onNoInternetConnection();

    void onRequestTimeOut();

    void onServerNotResponding();

    void onSomethingWentWrong();
}
