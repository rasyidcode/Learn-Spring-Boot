package com.rasyidcode.thymeleaf_experiment.movie;

import java.util.List;
import java.util.Objects;

public class Movie {

	private int id;

	private String title;

	private String posterUrl;

	private String tagline;

	private String overview;

	private int year;

	private String category;

	private List<Genre> genres;

	public Movie(int id, String title, String posterUrl, String tagline, String overview, int year, String category,
			List<Genre> genres) {
		this.id = id;
		this.title = title;
		this.posterUrl = posterUrl;
		this.tagline = tagline;
		this.overview = overview;
		this.year = year;
		this.category = category;
		this.genres = genres;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPosterUrl() {
		return posterUrl;
	}

	public void setPosterUrl(String posterUrl) {
		this.posterUrl = posterUrl;
	}

	public String getTagline() {
		return tagline;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, genres, id, overview, posterUrl, tagline, title, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return Objects.equals(category, other.category) && Objects.equals(genres, other.genres) && id == other.id
				&& Objects.equals(overview, other.overview) && Objects.equals(posterUrl, other.posterUrl)
				&& Objects.equals(tagline, other.tagline) && Objects.equals(title, other.title) && year == other.year;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", posterUrl=" + posterUrl + ", tagline=" + tagline
				+ ", overview=" + overview + ", year=" + year + ", category=" + category + ", genres=" + genres + "]";
	}

}
