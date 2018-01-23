package com.chimerapps.bitbucketcloud.api.model;

import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.NotNull;

/**
 * @author nicolaverbeeck
 */
public class BitbucketRepository {

    @NotNull
    @SerializedName("scm")
    private String mScm = "";

    @NotNull
    @SerializedName("website")
    private String mWebsite = "";

    @SerializedName("has_wiki")
    private boolean mHasWiki = false;

    @NotNull
    @SerializedName("name")
    private String mName = "";

    @NotNull
    @SerializedName("uuid")
    private String mUuid = "";

    @NotNull
    @SerializedName("language")
    private String mLanguage = "";

    @SerializedName("full_name")
    private String mFullName = "";

    @NotNull
    @SerializedName("mainbranch")
    private BranchInfo mMainbranch = new BranchInfo();

    @NotNull
    @SerializedName("slug")
    private String mSlug = "";

    @NotNull
    @SerializedName("description")
    private String mDescription = "";

    @NotNull
    public String getScm() {
        return mScm;
    }

    @NotNull
    public String getWebsite() {
        return mWebsite;
    }

    public boolean isHasWiki() {
        return mHasWiki;
    }

    @NotNull
    public String getName() {
        return mName;
    }

    @NotNull
    public String getUuid() {
        return mUuid;
    }

    @NotNull
    public String getLanguage() {
        return mLanguage;
    }

    public String getFullName() {
        return mFullName;
    }

    @NotNull
    public BranchInfo getMainbranch() {
        return mMainbranch;
    }

    @NotNull
    public String getSlug() {
        return mSlug;
    }

    @NotNull
    public String getDescription() {
        return mDescription;
    }

    @Override
    public String toString() {
        return "BitbucketRepository{" +
                "scm='" + mScm + '\'' +
                ", website='" + mWebsite + '\'' +
                ", hasWiki=" + mHasWiki +
                ", name='" + mName + '\'' +
                ", uuid='" + mUuid + '\'' +
                ", language='" + mLanguage + '\'' +
                ", fullName='" + mFullName + '\'' +
                ", mainbranch=" + mMainbranch +
                ", slug='" + mSlug + '\'' +
                ", description='" + mDescription + '\'' +
                '}';
    }

    public static class BranchInfo {
        @NotNull
        @SerializedName("type")
        private String mType = "";
        @NotNull
        @SerializedName("gname")
        private String mGname = "";

        @NotNull
        public String getType() {
            return mType;
        }

        @NotNull
        public String getGname() {
            return mGname;
        }

        @Override
        public String toString() {
            return "BranchInfo{" +
                    "type='" + mType + '\'' +
                    ", gname='" + mGname + '\'' +
                    '}';
        }
    }
}
