package com.rahulrvr.instagramapp.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Pagination {

    @SerializedName("next_max_tag_id")
    @Expose
    private String nextMaxTagId;
    @SerializedName("deprecation_warning")
    @Expose
    private String deprecationWarning;
    @SerializedName("next_max_id")
    @Expose
    private String nextMaxId;
    @SerializedName("next_min_id")
    @Expose
    private String nextMinId;
    @SerializedName("min_tag_id")
    @Expose
    private String minTagId;
    @SerializedName("next_url")
    @Expose
    private String nextUrl;

    public String getNextMaxTagId() {
        return nextMaxTagId;
    }

    public void setNextMaxTagId(String nextMaxTagId) {
        this.nextMaxTagId = nextMaxTagId;
    }

    public String getDeprecationWarning() {
        return deprecationWarning;
    }

    public void setDeprecationWarning(String deprecationWarning) {
        this.deprecationWarning = deprecationWarning;
    }

    public String getNextMaxId() {
        return nextMaxId;
    }

    public void setNextMaxId(String nextMaxId) {
        this.nextMaxId = nextMaxId;
    }

    public String getNextMinId() {
        return nextMinId;
    }

    public void setNextMinId(String nextMinId) {
        this.nextMinId = nextMinId;
    }

    public String getMinTagId() {
        return minTagId;
    }

    public void setMinTagId(String minTagId) {
        this.minTagId = minTagId;
    }

    public String getNextUrl() {
        return nextUrl;
    }

    public void setNextUrl(String nextUrl) {
        this.nextUrl = nextUrl;
    }

}