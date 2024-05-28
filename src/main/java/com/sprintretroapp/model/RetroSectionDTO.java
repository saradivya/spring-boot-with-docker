package com.sprintretroapp.model;



public class RetroSectionDTO {

  public String getSprintBoardNumber() {
    return sprintBoardNumber;
  }

  public void setSprintBoardNumber(String sprintBoardNumber) {
    this.sprintBoardNumber = sprintBoardNumber;
  }

  String sprintBoardNumber;
  String sectionName;
  boolean thumbsUpRequired;
  boolean votingRequired;
  String color;


  public String getSectionName() {
    return sectionName;
  }

  public void setSectionName(String sectionName) {
    this.sectionName = sectionName;
  }

  public boolean isThumbsUpRequired() {
    return thumbsUpRequired;
  }

  public void setThumbsUpRequired(boolean thumbsUpRequired) {
    this.thumbsUpRequired = thumbsUpRequired;
  }

  public boolean isVotingRequired() {
    return votingRequired;
  }

  public void setVotingRequired(boolean votingRequired) {
    this.votingRequired = votingRequired;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }
}
