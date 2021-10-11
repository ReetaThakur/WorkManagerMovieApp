package com.example.workmanagermovieapp.javaClass;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

//@Generated("com.robohorse.robopojogenerator")
public class ResponseModel implements Serializable {

	@SerializedName("page")
	private int page;

	@SerializedName("results")
	private List<ResultsModel> results;

	@SerializedName("total_pages")
	private int totalPages;

	@SerializedName("total_results")
	private int totalResults;

	public int getPage(){
		return page;
	}

	public List<ResultsModel> getResults(){
		return results;
	}

	public int getTotalPages(){
		return totalPages;
	}

	public int getTotalResults(){
		return totalResults;
	}

	@Override
 	public String toString(){
		return 
			"ResponseModel{" + 
			"page = '" + page + '\'' + 
			",results = '" + results + '\'' + 
			",total_pages = '" + totalPages + '\'' + 
			",total_results = '" + totalResults + '\'' + 
			"}";
		}
}