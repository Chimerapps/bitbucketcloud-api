package com.chimerapps.bitbucketcloud.api.model;

import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

/**
 * @author nicolaverbeeck
 */
public class PagedList<T> {

    @SerializedName("pagelen")
    private int mPagelen = -1;

    @SerializedName("page")
    private int mPage = -1;

    @SerializedName("size")
    private int mSize = -1;

    @Nullable
    @SerializedName("next")
    private String mNext = null;

    @Nullable
    @SerializedName("previous")
    private String mPrevious = null;

    @NotNull
    @SerializedName("values")
    private List<T> mValues = Collections.emptyList();

    public int getPagelen() {
        return mPagelen;
    }

    public int getPage() {
        return mPage;
    }

    public int getSize() {
        return mSize;
    }

    @Nullable
    public String getNext() {
        return mNext;
    }

    @Nullable
    public String getPrevious() {
        return mPrevious;
    }

    @NotNull
    public List<T> getValues() {
        return mValues;
    }

    @Override
    public String toString() {
        return "PagedList{" +
                "pagelen=" + mPagelen +
                ", page=" + mPage +
                ", size=" + mSize +
                ", next='" + mNext + '\'' +
                ", previous='" + mPrevious + '\'' +
                ", values=" + mValues +
                '}';
    }
}
