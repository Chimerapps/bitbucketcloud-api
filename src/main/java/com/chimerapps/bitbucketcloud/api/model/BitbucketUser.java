package com.chimerapps.bitbucketcloud.api.model;

import com.google.gson.annotations.SerializedName;

/**
 * @author nicolaverbeeck
 */
public class BitbucketUser {

    @SerializedName("username")
    private String mUsername = "";

    @SerializedName("website")
    private String mWebsite = "";

    @SerializedName("display_name")
    private String mDisplayName = "";

    @SerializedName("account_id")
    private String mAccountId = "";

    @SerializedName("uuid")
    private String mUuid = "";

    public String getUsername() {
        return mUsername;
    }

    public String getWebsite() {
        return mWebsite;
    }

    public String getDisplayName() {
        return mDisplayName;
    }

    public String getAccountId() {
        return mAccountId;
    }

    public String getUuid() {
        return mUuid;
    }

    @Override
    public String toString() {
        return "BitbucketUser{" +
                "username='" + mUsername + '\'' +
                ", website='" + mWebsite + '\'' +
                ", displayName='" + mDisplayName + '\'' +
                ", accountId='" + mAccountId + '\'' +
                ", uuid='" + mUuid + '\'' +
                '}';
    }
}
