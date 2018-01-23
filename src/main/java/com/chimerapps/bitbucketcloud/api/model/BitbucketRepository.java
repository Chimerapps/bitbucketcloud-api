package com.chimerapps.bitbucketcloud.api.model;

import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.NotNull;

/**
 * @author nicolaverbeeck
 */
public class BitbucketRepository {

    @NotNull
    private String scm = "";

    @NotNull
    private String website = "";

    @SerializedName("has_wiki")
    private boolean hasWiki = false;

    @NotNull
    private String name = "";

    @NotNull
    private String uuid = "";

    @NotNull
    private String language = "";

    @SerializedName("full_name")
    private String fullName = "";

    @NotNull
    private BranchInfo mainbranch = new BranchInfo();

    @NotNull
    private String slug = "";

    @NotNull
    private String description = "";

    @NotNull
    public String getScm() {
        return scm;
    }

    @NotNull
    public String getWebsite() {
        return website;
    }

    public boolean isHasWiki() {
        return hasWiki;
    }

    @NotNull
    public String getName() {
        return name;
    }

    @NotNull
    public String getUuid() {
        return uuid;
    }

    @NotNull
    public String getLanguage() {
        return language;
    }

    public String getFullName() {
        return fullName;
    }

    @NotNull
    public BranchInfo getMainbranch() {
        return mainbranch;
    }

    @NotNull
    public String getSlug() {
        return slug;
    }

    @NotNull
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "BitbucketRepository{" +
                "scm='" + scm + '\'' +
                ", website='" + website + '\'' +
                ", hasWiki=" + hasWiki +
                ", name='" + name + '\'' +
                ", uuid='" + uuid + '\'' +
                ", language='" + language + '\'' +
                ", fullName='" + fullName + '\'' +
                ", mainbranch=" + mainbranch +
                ", slug='" + slug + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public static class BranchInfo {
        @NotNull
        private String type = "";
        @NotNull
        private String gname = "";

        @NotNull
        public String getType() {
            return type;
        }

        @NotNull
        public String getGname() {
            return gname;
        }

        @Override
        public String toString() {
            return "BranchInfo{" +
                    "type='" + type + '\'' +
                    ", gname='" + gname + '\'' +
                    '}';
        }
    }
}
