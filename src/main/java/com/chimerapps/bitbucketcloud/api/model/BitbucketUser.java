package com.chimerapps.bitbucketcloud.api.model;

import com.google.gson.annotations.SerializedName;

/**
 * @author nicolaverbeeck
 */
public class BitbucketUser {

    private String username = "";

    private String website = "";

    @SerializedName("display_name")
    private String displayName = "";

    @SerializedName("account_id")
    private String accountId = "";

    private String uuid = "";

    public String getUsername() {
        return username;
    }

    public String getWebsite() {
        return website;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getUuid() {
        return uuid;
    }

    @Override
    public String toString() {
        return "BitbucketUser{" +
                "username='" + username + '\'' +
                ", website='" + website + '\'' +
                ", displayName='" + displayName + '\'' +
                ", accountId='" + accountId + '\'' +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}
