package com.chimerapps.bitbucketcloud.api.model;

import com.google.gson.annotations.SerializedName;

/**
 * @author Koen Van Looveren
 */
public class DefaultReviewer {
    @SerializedName("username")
    private final String mUsername;
    @SerializedName("display_name")
    private final String mDisplayName;
    @SerializedName("type")
    private final String mType;
    @SerializedName("uuid")
    private final String mUuid;

    public DefaultReviewer(String username, String displayName, String type, String uuid) {
        this.mUsername = username;
        this.mDisplayName = displayName;
        this.mType = type;
        this.mUuid = uuid;
    }

    public String getUsername() {
        return mUsername;
    }

    public String getDisplayName() {
        return mDisplayName;
    }

    public String getType() {
        return mType;
    }

    public String getUuid() {
        return mUuid;
    }

    @Override
    public String toString() {
        return "DefaultReviewer{" +
                "username='" + mUsername + '\'' +
                ", displayName='" + mDisplayName + '\'' +
                ", type='" + mType + '\'' +
                ", uuid='" + mUuid + '\'' +
                '}';
    }
}
