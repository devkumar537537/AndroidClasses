package com.example.restapiexampleonjava.models;

import java.util.ArrayList;

public class NowPlayingModel {
   public Dates dates;
   public int page;
   public ArrayList<Results> results;
   public int total_pages;
   public int total_results;

   public NowPlayingModel(Dates dates, int page, ArrayList<Results> results, int total_pages, int total_results) {
      this.dates = dates;
      this.page = page;
      this.results = results;
      this.total_pages = total_pages;
      this.total_results = total_results;
   }

   public NowPlayingModel() {
   }

   public Dates getDates() {
      return dates;
   }

   public void setDates(Dates dates) {
      this.dates = dates;
   }

   public int getPage() {
      return page;
   }

   public void setPage(int page) {
      this.page = page;
   }

   public ArrayList<Results> getResults() {
      return results;
   }

   public void setResults(ArrayList<Results> results) {
      this.results = results;
   }

   public int getTotal_pages() {
      return total_pages;
   }

   public void setTotal_pages(int total_pages) {
      this.total_pages = total_pages;
   }

   public int getTotal_results() {
      return total_results;
   }

   public void setTotal_results(int total_results) {
      this.total_results = total_results;
   }
}
