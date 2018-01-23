package com.chimerapps.bitbucketcloud.api.model;

import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.NotNull;

/**
 * @author nicolaverbeeck
 */
public class BitbucketUser {

    @NotNull
    @SerializedName("username")
    private String mUsername = "";

    @NotNull
    @SerializedName("website")
    private String mWebsite = "";

    @NotNull
    @SerializedName("display_name")
    private String mDisplayName = "";

    @NotNull
    @SerializedName("account_id")
    private String mAccountId = "";

    @NotNull
    @SerializedName("uuid")
    private String mUuid = "";

    @NotNull
    public String getUsername() {
        return mUsername;
    }

    @NotNull
    public String getWebsite() {
        return mWebsite;
    }

    @NotNull
    public String getDisplayName() {
        return mDisplayName;
    }

    @NotNull
    public String getAccountId() {
        return mAccountId;
    }

    @NotNull
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
