package com.sprintretroapp.domain;

import lombok.Data;



@Data
public class RetroSectionNotes {
  String noteId;
  String note;
  int noOfVotes;
  int noOfThumbsUp;
  boolean active = true;
  String sprintBoardNumber;
  String sectionName;

}
