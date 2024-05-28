package com.sprintretroapp.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "RetroBoard")
public class RetroBoard {

  public RetroBoard(
      String sprintBoardId, String sprintBoardNumber, String sprintContext, String sprintTitle) {
    this.sprintBoardId = sprintBoardId;
    this.sprintBoardNumber = sprintBoardNumber;
    this.sprintContext = sprintContext;
    this.sprintTitle = sprintTitle;
  }

  @Id public String sprintBoardId;
  public String sprintBoardNumber;
  public String sprintContext;
  public String sprintTitle;

  public RetroBoard() {}
}
