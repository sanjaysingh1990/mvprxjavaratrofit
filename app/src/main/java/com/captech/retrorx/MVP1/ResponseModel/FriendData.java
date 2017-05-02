package com.captech.retrorx.MVP1.ResponseModel;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FriendData implements Parcelable,Cloneable {

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    private boolean selected=false;

    public int getPlaying() {
        return playing;
    }

    public void setPlaying(int playing) {
        this.playing = playing;
    }

    private int playing=0;

    public Float getGiveRating() {
        return giveRating;
    }

    public void setGiveRating(Float giveRating) {
        this.giveRating = giveRating;
    }

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    private int itemType= 1;
    private Float giveRating=0.0f;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("avg_rating")
    @Expose
    private Float avgRating;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("player_of_day")
    @Expose
    private int playerOfDay;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("profile_pic")
    @Expose
    private String profilePic;
    @SerializedName("match_days")
    @Expose
    private int matchDays;
    @SerializedName("points")
    @Expose
    private int points;
    @SerializedName("bating_style")
    @Expose
    private String batingStyle;
    @SerializedName("bowling_style")
    @Expose
    private String bowlingStyle;

    @SerializedName("order_flag")
    @Expose
    private int orderFlag;
    @SerializedName("action_status")
    @Expose
    private int actionStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Float getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(Float avgRating) {
        this.avgRating = avgRating;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPlayerOfDay() {
        return playerOfDay;
    }

    public void setPlayerOfDay(int playerOfDay) {
        this.playerOfDay = playerOfDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public int getMatchDays() {
        return matchDays;
    }

    public void setMatchDays(int matchDays) {
        this.matchDays = matchDays;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getBatingStyle() {
        return batingStyle;
    }

    public void setBatingStyle(String batingStyle) {
        this.batingStyle = batingStyle;
    }

    public String getBowlingStyle() {
        return bowlingStyle;
    }

    public void setBowlingStyle(String bowlingStyle) {
        this.bowlingStyle = bowlingStyle;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }

    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }
    public int getOrderFlag() {
        return orderFlag;
    }

    public void setOrderFlag(int orderFlag) {
        this.orderFlag = orderFlag;
    }

    public int getActionStatus() {
        return actionStatus;
    }

    public void setActionStatus(int actionStatus) {
        this.actionStatus = actionStatus;
    }

}
