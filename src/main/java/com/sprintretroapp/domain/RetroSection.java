package com.sprintretroapp.domain;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "RetroSection")
public class RetroSection {
  @Id
  String sectionId;
  String sprintBoardNumber;
  String sectionName;
  List<RetroSectionNotes> sectionNotes = new ArrayList<>();
  boolean thumbsUpRequired;
  boolean votingRequired;
  String color;
}
