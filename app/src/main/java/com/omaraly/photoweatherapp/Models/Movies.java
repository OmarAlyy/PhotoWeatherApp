package com.omaraly.photoweatherapp.Models;

import java.io.Serializable;
import java.util.List;

public class Movies implements Serializable {

    public int page;
    public int total_results;
    public int total_pages;
    public List<ResultsBean> results;

    public static class ResultsBean implements Serializable {
        public double popularity;
        public int vote_count;
        public boolean video;
        public String poster_path;
        public int id;
        public boolean adult;
        public String backdrop_path;
        public String original_language;
        public String original_title;
        public String title;
        public double vote_average;
        public String overview;
        public String release_date;
        public List<Integer> genre_ids;
    }
}
