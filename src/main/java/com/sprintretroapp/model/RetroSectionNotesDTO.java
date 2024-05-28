package com.sprintretroapp.model;

public class RetroSectionNotesDTO {

  String noteId;
  String note;
  int noOfVotes;
  int noOfThumbsUp;
  boolean active = true;
  String sprintBoardNumber;
  String sectionName;

  public String getSprintBoardNumber() {
    return sprintBoardNumber;
  }

  public void setSprintBoardNumber(String sprintBoardNumber) {
    this.sprintBoardNumber = sprintBoardNumber;
  }



  public String getSectionName() {
    return sectionName;
  }

  public void setSectionName(String sectionName) {
    this.sectionName = sectionName;
  }


  public String getNoteId() {
    return noteId;
  }

  public void setNoteId(String noteId) {
    this.noteId = noteId;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public int getNoOfVotes() {
    return noOfVotes;
  }

  public void setNoOfVotes(int noOfVotes) {
    this.noOfVotes = noOfVotes;
  }

  public int getNoOfThumbsUp() {
    return noOfThumbsUp;
  }

  public void setNoOfThumbsUp(int noOfThumbsUp) {
    this.noOfThumbsUp = noOfThumbsUp;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }


}
