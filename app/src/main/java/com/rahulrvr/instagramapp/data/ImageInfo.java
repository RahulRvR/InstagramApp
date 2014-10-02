package com.rahulrvr.instagramapp.data;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;


public class ImageInfo {

    @Expose
    private Pagination pagination;
    @Expose
    private List<Datum> data = new ArrayList<Datum>();

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }



    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

}

