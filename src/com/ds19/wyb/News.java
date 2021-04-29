package com.ds19.wyb;

public class News {
	private String News_title;
	private String News_date;
	private String News_content;
	private String News_read;
	private int News_id;
	
	public String getNews_title() {
		return News_title;
	}
	public void setNews_title(String news_title) {
		News_title = news_title;
	}
	public String getNews_date() {
		return News_date;
	}
	public void setNews_date(String news_date) {
		News_date = news_date;
	}
	public String getNews_content() {
		return News_content;
	}
	public void setNews_content(String news_content) {
		News_content = news_content;
	}
	public String getNews_read() {
		return News_read;
	}
	public void setNews_read(String news_read) {
		News_read = news_read;
	}
	public int getNews_id() {
		return News_id;
	}
	public void setNews_id(int news_id) {
		News_id = news_id;
	}
	public News(String news_title, String news_date, String news_content, String news_read, int news_id) {
		super();
		News_title = news_title;
		News_date = news_date;
		News_content = news_content;
		News_read = news_read;
		News_id = news_id;
	}
	
	
	
	
}
