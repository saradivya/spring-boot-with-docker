package com.sprintretroapp.controller;


import com.sprintretroapp.model.RetroSectionDTO;
import com.sprintretroapp.model.RetroSectionNotesDTO;
import com.sprintretroapp.service.RetroSectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("/sprint/section")
@RestController
public class RetroSectionController {

  @Autowired
  RetroSectionService retroSectionService;

  @GetMapping("/board/{boardNumber}")
  public Flux<RetroSectionDTO> getAllSectionsByBoard(@PathVariable String boardNumber) {
    return retroSectionService.getSectionsBySprintBoardNumber(boardNumber);
  }

  @GetMapping("/{sectionName}/notes")
  public Flux<RetroSectionNotesDTO> getActiveNotesBySectionName(@PathVariable String sectionName) {
    return retroSectionService.getActiveNotesBySectionName(sectionName);
  }

  @PostMapping
  public Mono<RetroSectionDTO> createSectionForRetroBoard(
      @RequestBody Mono<RetroSectionDTO> retroSectionDTO) {
    return retroSectionService.createRetroSection(retroSectionDTO);
  }

  @PutMapping("/{sectionName}")
  public Mono<RetroSectionDTO> updateRetroSection(
      @PathVariable String  sectionName,@RequestBody Mono<RetroSectionDTO> retroSectionDTO) {
    return retroSectionService.updateRetroSection(sectionName,retroSectionDTO);
  }

  @PostMapping("/{sectionName}/notes")
  public Mono<String> addNotesInRetroSection(@PathVariable String  sectionName,
      @RequestBody Mono<RetroSectionNotesDTO> retroSectionNotesDTO) {
    return retroSectionService.addNotesToRetroSection(sectionName,retroSectionNotesDTO);
  }

  @PutMapping("/{sectionName}/notes/{noteId}")
  public Mono<String> updateNoteInRetroSection(
      @PathVariable String sectionName, @PathVariable String noteId,
      @RequestBody Mono<RetroSectionNotesDTO> retroSectionNotesDTO) {
    return retroSectionService.updateNotesInRetroSection(sectionName,noteId,retroSectionNotesDTO);
  }

  @DeleteMapping("/{sectionName}/notes/{noteId}")
  public Mono<String> deleteNoteInRetroSection(
      @PathVariable String sectionName, @PathVariable String noteId) {
    return retroSectionService.deleteNoteInRetroSection(sectionName,noteId);
  }

}
