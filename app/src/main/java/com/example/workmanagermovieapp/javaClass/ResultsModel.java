package com.example.workmanagermovieapp.javaClass;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

//@Generated("com.robohorse.robopojogenerator")
public class ResultsModel implements Serializable {

	@SerializedName("adult")
	private boolean adult;

	@SerializedName("backdrop_path")
	private String backdropPath;

	@SerializedName("genre_ids")
	private List<Integer> genreIds;

	@SerializedName("id")
	private int id;

	@SerializedName("original_language")
	private String originalLanguage;

	@SerializedName("original_title")
	private String originalTitle;

	@SerializedName("overview")
	private String overview;

	@SerializedName("popularity")
	private Object popularity;

	@SerializedName("poster_path")
	private String posterPath;

	@SerializedName("release_date")
	private String releaseDate;

	@SerializedName("title")
	private String title;

	@SerializedName("video")
	private boolean video;

	@SerializedName("vote_average")
	private Object voteAverage;

	@SerializedName("vote_count")
	private int voteCount;

	public boolean isAdult(){
		return adult;
	}

	public String getBackdropPath(){
		return backdropPath;
	}

	public List<Integer> getGenreIds(){
		return genreIds;
	}

	public int getId(){
		return id;
	}

	public String getOriginalLanguage(){
		return originalLanguage;
	}

	public String getOriginalTitle(){
		return originalTitle;
	}

	public String getOverview(){
		return overview;
	}

	public Object getPopularity(){
		return popularity;
	}

	public String getPosterPath(){
		return posterPath;
	}

	public String getReleaseDate(){
		return releaseDate;
	}

	public String getTitle(){
		return title;
	}

	public boolean isVideo(){
		return video;
	}

	public Object getVoteAverage(){
		return voteAverage;
	}

	public int getVoteCount(){
		return voteCount;
	}

	@Override
 	public String toString(){
		return 
			"ResultsModel{" + 
			"adult = '" + adult + '\'' + 
			",backdrop_path = '" + backdropPath + '\'' + 
			",genre_ids = '" + genreIds + '\'' + 
			",id = '" + id + '\'' + 
			",original_language = '" + originalLanguage + '\'' + 
			",original_title = '" + originalTitle + '\'' + 
			",overview = '" + overview + '\'' + 
			",popularity = '" + popularity + '\'' + 
			",poster_path = '" + posterPath + '\'' + 
			",release_date = '" + releaseDate + '\'' + 
			",title = '" + title + '\'' + 
			",video = '" + video + '\'' + 
			",vote_average = '" + voteAverage + '\'' + 
			",vote_count = '" + voteCount + '\'' + 
			"}";
		}
}