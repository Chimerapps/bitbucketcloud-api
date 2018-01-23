package com.chimerapps.bitbucketcloud.api.model;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

/**
 * @author nicolaverbeeck
 */
public class PagedList<T> {

    private int pagelen = -1;

    private int page = -1;

    private int size = -1;

    @Nullable
    private String next = null;

    @Nullable
    private String previous = null;

    @NotNull
    private List<T> values = Collections.emptyList();

    public int getPagelen() {
        return pagelen;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    @Nullable
    public String getNext() {
        return next;
    }

    @Nullable
    public String getPrevious() {
        return previous;
    }

    @NotNull
    public List<T> getValues() {
        return values;
    }

    @Override
    public String toString() {
        return "PagedList{" +
                "pagelen=" + pagelen +
                ", page=" + page +
                ", size=" + size +
                ", next='" + next + '\'' +
                ", previous='" + previous + '\'' +
                ", values=" + values +
                '}';
    }
}
