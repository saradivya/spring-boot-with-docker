package com.sprintretroapp.domain;

import lombok.Data;



@Data
public class RetroSectionNotes {
  String noteId;
  String note;
  int noOfVotes = 0;
  int noOfThumbsUp = 0;
  boolean active = true;
  String sprintBoardNumber;
  String sectionName;

}
