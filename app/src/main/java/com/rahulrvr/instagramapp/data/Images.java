package com.rahulrvr.instagramapp.data;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Images {
        @SerializedName("low_resolution")
        @Expose
        private LowResolution lowResolution;
        @Expose
        private Thumbnail thumbnail;
        @SerializedName("standard_resolution")
        @Expose
        private StandardResolution standardResolution;

        public LowResolution getLowResolution() {
            return lowResolution;
        }

        public void setLowResolution(LowResolution lowResolution) {
            this.lowResolution = lowResolution;
        }

        public Thumbnail getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(Thumbnail thumbnail) {
            this.thumbnail = thumbnail;
        }

        public StandardResolution getStandardResolution() {
            return standardResolution;
        }

        public void setStandardResolution(StandardResolution standardResolution) {
            this.standardResolution = standardResolution;
        }



    public class LowResolution {

        @Expose
        private String url;
        @Expose
        private Integer width;
        @Expose
        private Integer height;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

    }


    public class StandardResolution {

        @Expose
        private String url;
        @Expose
        private Integer width;
        @Expose
        private Integer height;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

    }

    public class Thumbnail {

        @Expose
        private String url;
        @Expose
        private Integer width;
        @Expose
        private Integer height;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

    }

}
