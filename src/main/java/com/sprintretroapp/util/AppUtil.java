package com.sprintretroapp.util;

import com.sprintretroapp.domain.RetroBoard;
import com.sprintretroapp.domain.RetroSection;
import com.sprintretroapp.domain.RetroSectionNotes;
import com.sprintretroapp.model.RetroBoardDTO;
import com.sprintretroapp.model.RetroSectionDTO;
import com.sprintretroapp.model.RetroSectionNotesDTO;
import org.springframework.beans.BeanUtils;

public class AppUtil {

  public static RetroBoardDTO RetroBoardEntityToRetroBoardDTO(RetroBoard retroBoard) {
    RetroBoardDTO retroBoardDTO = new RetroBoardDTO();
    BeanUtils.copyProperties(retroBoard, retroBoardDTO);
    return retroBoardDTO;
  }

  public static RetroBoard RetroBoardDTOTORetroBoardEntity(RetroBoardDTO retroBoardDTO) {
    RetroBoard retroBoard = new RetroBoard();
    BeanUtils.copyProperties(retroBoardDTO, retroBoard);
    return retroBoard;
  }

  public static RetroSectionDTO RetroSectionEntityToRetroSectionDTO(RetroSection retroSection) {
    RetroSectionDTO retroSectionDTO = new RetroSectionDTO();
    BeanUtils.copyProperties(retroSection, retroSectionDTO);
    return retroSectionDTO;
  }

  public static RetroSection RetroSectionDTOTORetroSectionEntity(RetroSectionDTO retroSectionDTO) {
    RetroSection retroSection = new RetroSection();
    BeanUtils.copyProperties(retroSectionDTO, retroSection);
    return retroSection;
  }

  public static RetroSectionNotes RetroSectionNotesDTORetroSectionNotesEntity(RetroSectionNotesDTO retroSectionNotesDTO) {
    RetroSectionNotes retroSectionNotes = new RetroSectionNotes();
    BeanUtils.copyProperties(retroSectionNotesDTO, retroSectionNotes);
    return retroSectionNotes;
  }

  public static RetroSectionNotesDTO RetroSectionNotesEntityToRetroSectionNotesDTO(RetroSectionNotes retroSectionNotes) {
    RetroSectionNotesDTO retroSectionNotesDTO = new RetroSectionNotesDTO();
    BeanUtils.copyProperties(retroSectionNotes, retroSectionNotesDTO);
    return retroSectionNotesDTO;
  }
}
