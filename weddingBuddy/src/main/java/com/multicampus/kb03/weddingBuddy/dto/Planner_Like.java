package com.multicampus.kb03.weddingBuddy.dto;

public class Planner_Like {
private int planner_like_id;
private int planner_id;
private int user_id;
private boolean isFavorite;


public boolean isFavorite() {
	return isFavorite;
}
public void setFavorite(boolean isFavorite) {
	this.isFavorite = isFavorite;
}
public int getPlanner_like_id() {
	return planner_like_id;
}
public void setPlanner_like_id(int planner_like_id) {
	this.planner_like_id = planner_like_id;
}
public int getPlanner_id() {
	return planner_id;
}
public void setPlanner_id(int planner_id) {
	this.planner_id = planner_id;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}

@Override
public String toString() {
	return "Planner_Like [planner_like_id=" + planner_like_id + ", planner_id=" + planner_id + ", user_id=" + user_id
			+ ", isFavorite=" + isFavorite + "]";
}
}
