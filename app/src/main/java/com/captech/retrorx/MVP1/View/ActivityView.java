package com.captech.retrorx.MVP1.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.captech.retrorx.MVP1.Presenter.PresenterInteractor;
import com.captech.retrorx.MVP1.Presenter.PresenterLayer;
import com.captech.retrorx.MVP1.ResponseModel.FriendResponse;
import com.captech.retrorx.R;


public class ActivityView extends AppCompatActivity implements OnClickListener,LoginView {

    private static final String EXTRA_RX = "EXTRA_RX";
    private static final String TOKEN="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyIkX18iOnsic3RyaWN0TW9kZSI6dHJ1ZSwiaW5zZXJ0aW5nIjp0cnVlLCJnZXR0ZXJzIjp7fSwid2FzUG9wdWxhdGVkIjpmYWxzZSwiYWN0aXZlUGF0aHMiOnsicGF0aHMiOnsicGhvbmUiOiJyZXF1aXJlIn0sInN0YXRlcyI6eyJpZ25vcmUiOnt9LCJkZWZhdWx0Ijp7fSwiaW5pdCI6e30sIm1vZGlmeSI6e30sInJlcXVpcmUiOnsicGhvbmUiOnRydWV9fSwic3RhdGVOYW1lcyI6WyJyZXF1aXJlIiwibW9kaWZ5IiwiaW5pdCIsImRlZmF1bHQiLCJpZ25vcmUiXX0sImVtaXR0ZXIiOnsiZG9tYWluIjpudWxsLCJfZXZlbnRzIjp7fSwiX2V2ZW50c0NvdW50IjoyLCJfbWF4TGlzdGVuZXJzIjowfX0sImlzTmV3IjpmYWxzZSwiX2RvYyI6eyJuYW1lIjoiIiwidmVyaWZpY2F0aW9uX2NvZGUiOiIiLCJwcm9maWxlX2NyZWF0ZWQiOjAsInR5cGUiOjIsImlzX3ZlcmlmaWVkIjoxLCJwZW5kaW5nX21hdGNoX2NvdW50IjowLCJkZXZpY2VfdG9rZW4iOiI0YTJmYjA2ZjhhMjkyYWIzIiwibGF0ZXN0X3Rva2VuIjoiIiwicHJvZmlsZV9waWMiOiIiLCJiYXRpbmdfc3R5bGUiOiIiLCJib3dsaW5nX3N0eWxlIjoiIiwicHVzaF9ub3RpZmljYXRpb24iOjEsImF2Z19yYXRpbmciOjAsInBsYXllcl9vZl9kYXkiOjAsIm5ld19waG9uZSI6IiIsImlzX2RlbGV0ZWQiOjAsImZyaWVuZHMiOltdLCJpc190dXRvcmlhbF9zZWVuIjowLCJtYXRjaF9kYXlzIjowLCJwb2ludHMiOjAsInN0YXR1cyI6MSwiX2lkIjoiNTkwODU2Zjg1OTczYjI1ZmVhZTU5MzVmIiwicGhvbmUiOiIrOTE4Mjk1NjcwNjU5IiwiY3JlYXRlZF9hdCI6IjIwMTctMDUtMDJUMDk6NTI6NTYuMTI4WiIsInVwZGF0ZWRfYXQiOiIyMDE3LTA1LTAyVDA5OjUyOjU2LjEyOFoiLCJfX3YiOjB9LCJpYXQiOjE0OTM3MTg3NzZ9.WLdFj8kSuG18o595Q_0_gczj2eEB831zplmQVYmfnh4";
    private Button rxCall;
    private TextView rxResponse;
    private ProgressBar progressBar;

    private boolean rxCallInWorks = false;
    private PresenterInteractor presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rxCall = (Button)findViewById(R.id.rxCall);
        rxResponse = (TextView)findViewById(R.id.rxResponse);
         progressBar = (ProgressBar)findViewById(R.id.progressBar);
        rxCall.setOnClickListener(this);
        presenter = new PresenterLayer(this);
        if(savedInstanceState!=null){
            rxCallInWorks = savedInstanceState.getBoolean(EXTRA_RX);
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.retroCall:

                break;
            case R.id.rxCall:
                rxCallInWorks = true;
                presenter.loadRxData(TOKEN,1);
                break;
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(EXTRA_RX, rxCallInWorks);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }



    @Override
    public void onNoInternetConnection() {
        rxResponse.setText("Please check your internet connection");
        rxResponse.setVisibility(View.VISIBLE);

    }

    @Override
    public void onRequestTimeOut() {
        rxResponse.setText("Request time out");
        rxResponse.setVisibility(View.VISIBLE);

    }

    @Override
    public void onServerNotResponding() {
        rxResponse.setText("some went wrong from our side, please try again later");
        rxResponse.setVisibility(View.VISIBLE);

    }

    @Override
    public void onSomethingWentWrong() {
        rxResponse.setText("something went wrong");
        rxResponse.setVisibility(View.VISIBLE);

    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onSuccess(FriendResponse friendResponse) {
        rxResponse.setText(friendResponse.getMessage());
        rxResponse.setVisibility(View.VISIBLE);
        rxCall.setEnabled(true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
