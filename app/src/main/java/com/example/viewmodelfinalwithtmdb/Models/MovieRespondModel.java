package com.example.viewmodelfinalwithtmdb.Models;

import java.util.List;

public class MovieRespondModel {
    private List<MovieModel> results;

    public MovieRespondModel(List<MovieModel> results) {
        this.results = results;
    }

    public List<MovieModel> getResults() {
        return results;
    }

    public class MovieModel
    {
        private int id;
        private double popularity;
        private int vote_count;
        private String poster_path;
        private String backdrop_path;
        private String original_language;
        private int[] genre_ids;
        private String title;
        private double vote_average;
        private String overview;
        private String release_date;

        public MovieModel(int id, double popularity, int vote_count, String poster_path, String backdrop_path, String original_language, int[] genre_ids, String title, double vote_average, String overview, String release_date) {
            this.id = id;
            this.popularity = popularity;
            this.vote_count = vote_count;
            this.poster_path = poster_path;
            this.backdrop_path = backdrop_path;
            this.original_language = original_language;
            this.genre_ids = genre_ids;
            this.title = title;
            this.vote_average = vote_average;
            this.overview = overview;
            this.release_date = release_date;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public double getPopularity() {
            return popularity;
        }

        public void setPopularity(double popularity) {
            this.popularity = popularity;
        }

        public int getVote_count() {
            return vote_count;
        }

        public void setVote_count(int vote_count) {
            this.vote_count = vote_count;
        }

        public String getPoster_path() {
            return poster_path;
        }

        public void setPoster_path(String poster_path) {
            this.poster_path = poster_path;
        }

        public String getBackdrop_path() {
            return backdrop_path;
        }

        public void setBackdrop_path(String backdrop_path) {
            this.backdrop_path = backdrop_path;
        }

        public String getOriginal_language() {
            return original_language;
        }

        public void setOriginal_language(String original_language) {
            this.original_language = original_language;
        }

        public int[] getGenre_ids() {
            return genre_ids;
        }

        public void setGenre_ids(int[] genre_ids) {
            this.genre_ids = genre_ids;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public double getVote_average() {
            return vote_average;
        }

        public void setVote_average(double vote_average) {
            this.vote_average = vote_average;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public String getRelease_date() {
            return release_date;
        }

        public void setRelease_date(String release_date) {
            this.release_date = release_date;
        }
    }
}
