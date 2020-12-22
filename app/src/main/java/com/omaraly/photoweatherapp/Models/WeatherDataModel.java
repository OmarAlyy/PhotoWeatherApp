package com.omaraly.photoweatherapp.Models;

import java.util.List;

public class WeatherDataModel {

    /**
     * coord : {"lon":-122.08,"lat":37.42}
     * weather : [{"id":800,"main":"Clear","description":"clear sky","icon":"01d"}]
     * base : stations
     * main : {"temp":285.77,"feels_like":284.06,"temp_min":283.71,"temp_max":287.04,"pressure":1020,"humidity":57}
     * visibility : 10000
     * wind : {"speed":0.65,"deg":350}
     * clouds : {"all":1}
     * dt : 1608578359
     * sys : {"type":1,"id":5845,"country":"US","sunrise":1608563964,"sunset":1608598442}
     * timezone : -28800
     * id : 5375480
     * name : Mountain View
     * cod : 200
     */

    public CoordBean coord;
    public String base;
    public MainBean main;
    public String visibility;
    public WindBean wind;
    public CloudsBean clouds;
    public String dt;
    public SysBean sys;
    public String timezone;
    public String id;
    public String name;
    public String cod;
    public List<WeatherBean> weather;

    public static class CoordBean {
        /**
         * lon : -122.08
         * lat : 37.42
         */

        public String lon;
        public String lat;
    }

    public static class MainBean {
        /**
         * temp : 285.77
         * feels_like : 284.06
         * temp_min : 283.71
         * temp_max : 287.04
         * pressure : 1020
         * humidity : 57
         */

        public String temp;
        public String feels_like;
        public String temp_min;
        public String temp_max;
        public String pressure;
        public String humidity;
    }

    public static class WindBean {
        /**
         * speed : 0.65
         * deg : 350
         */

        public String speed;
        public String deg;
    }

    public static class CloudsBean {
        /**
         * all : 1
         */

        public String all;
    }

    public static class SysBean {
        /**
         * type : 1
         * id : 5845
         * country : US
         * sunrise : 1608563964
         * sunset : 1608598442
         */

        public String type;
        public String id;
        public String country;
        public String sunrise;
        public String sunset;
    }

    public static class WeatherBean {
        /**
         * id : 800
         * main : Clear
         * description : clear sky
         * icon : 01d
         */

        public String id;
        public String main;
        public String description;
        public String icon;
    }
}
