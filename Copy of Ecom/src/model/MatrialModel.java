package model;

public class MatrialModel {
	private String TopicName;
	private String Link;
	private String LinkID;
	private int LikesNum;

public MatrialModel() {
	// TODO Auto-generated constructor stub
}

public MatrialModel(String TopicName,String Link,String LinkID,int LikesNum) {
	this.Link=Link;
	this.TopicName=TopicName;
	this.LinkID=LinkID;
	this.LikesNum=LikesNum;
}

public String getLink() {
	return Link;
}

public String getTopicName() {
	return TopicName;
}

public void setLink(String link) {
	Link = link;
}

 public void setTopicName(String topicName) {
	TopicName = topicName;
}
public String getLinkID() {
	return LinkID;
}

public void setLinkID(String linkID) {
	LinkID = linkID;
}
public int getLikesNum() {
	return LikesNum;
}
public void setLikesNum(int likesNum) {
	LikesNum = likesNum;
}
}
