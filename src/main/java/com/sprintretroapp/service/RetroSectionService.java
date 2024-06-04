package com.sprintretroapp.service;

import com.sprintretroapp.domain.RetroSection;
import com.sprintretroapp.domain.RetroSectionNotes;
import com.sprintretroapp.model.RetroSectionDTO;
import com.sprintretroapp.model.RetroSectionNotesDTO;
import com.sprintretroapp.repository.RetroSectionsRepository;
import com.sprintretroapp.util.AppUtil;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RetroSectionService {

  @Autowired
  RetroSectionsRepository retroSectionsRepository;

  public Flux<RetroSectionDTO> getSectionsBySprintBoardNumber(String boardNumber) {
    return retroSectionsRepository
        .findRetroSectionBySprintBoardNumber(boardNumber)
        .map(AppUtil::RetroSectionEntityToRetroSectionDTO);
  }

  public Flux<RetroSectionNotesDTO> getActiveNotesBySectionName(String sectionName) {
    return retroSectionsRepository
        .findFirstRetroSectionBySectionName(sectionName)
        .flatMapMany(retroSection ->
            Flux.fromIterable(retroSection.getSectionNotes()).filter(RetroSectionNotes::isActive)
                .map(AppUtil::RetroSectionNotesEntityToRetroSectionNotesDTO));
  }

  public Mono<String> createRetroSection(Mono<RetroSectionDTO> retroSectionDTO){

    return retroSectionDTO
        .flatMap(
            retroSectionDTO1 ->
                retroSectionsRepository.findFirstRetroSectionBySectionName(
                        retroSectionDTO1.getSectionName())
                    .hasElement()
                    .flatMap(
                        exists ->
                            Boolean.TRUE.equals(exists)
                                ? Mono.just("RetroSection Name already taken")
                                : createRetroSection(retroSectionDTO1)));
  }

  public Mono<RetroSectionDTO> updateRetroSection(String sectionName,Mono<RetroSectionDTO> retroSectionDTO){

    return retroSectionDTO
        .flatMap(
            retroSectionDTO1 ->
                retroSectionsRepository.findFirstRetroSectionBySectionName(sectionName)
                    .switchIfEmpty(Mono.error(new Exception("RetroSection not present in this sprint board")))
                    .flatMap(
                        retroSection -> updateRetroSection(retroSection,retroSectionDTO1)));
  }

  public Mono<String> addNotesToRetroSection(String sectionName,Mono<RetroSectionNotesDTO> retroSectionNotesDTO){
    return retroSectionNotesDTO.flatMap(retroSectionNotesDTO1 ->
       retroSectionsRepository.findFirstRetroSectionBySectionName(sectionName)
          .switchIfEmpty(Mono.error(new Exception("RetroSection not present in this sprint board")))
          .flatMap(
              retroSection -> {
                RetroSectionNotes retroSectionNotes = AppUtil.RetroSectionNotesDTORetroSectionNotesEntity(
                    retroSectionNotesDTO1);
                retroSectionNotes.setNoteId(UUID.randomUUID().toString());
                retroSection.getSectionNotes().add(retroSectionNotes);
                  return retroSectionsRepository.save(retroSection).map(retroSection1 -> "Notes added successfully");
      }));
  }

  public Mono<String> updateNotesInRetroSection(String sectionName,String noteId, Mono<RetroSectionNotesDTO> retroSectionNotesDTO){
    return retroSectionNotesDTO.flatMap(retroSectionNotesDTO1 ->
        retroSectionsRepository.findFirstRetroSectionBySectionName(sectionName)
            .switchIfEmpty(Mono.error(new Exception("RetroSection not present in this sprint board")))
            .flatMap(
                retroSection -> {
                  Optional<RetroSectionNotes> retroSectionNotesOptional = retroSection.getSectionNotes().stream()
                      .filter(notes -> notes.getNoteId().equals(noteId))
                      .findFirst();
                   retroSectionNotesOptional.ifPresent(retroSectionNotes1 -> {
                      retroSectionNotes1.setNote(retroSectionNotesDTO1.getNote());
                      retroSectionNotes1.setNoOfThumbsUp(retroSectionNotesDTO1.getNoOfThumbsUp());
                      retroSectionNotes1.setNoOfVotes(retroSectionNotesDTO1.getNoOfVotes());
                    });
                     return retroSectionsRepository.save(retroSection).map(retroSection1 -> "Note Updated successfully");
                }));
  }

  public Mono<String> deleteNoteInRetroSection(String sectionName,String noteId){
    return retroSectionsRepository.findFirstRetroSectionBySectionName(sectionName)
            .switchIfEmpty(Mono.error(new Exception("RetroSection not present in this sprint board")))
            .flatMap(
                retroSection -> {
                  Optional<RetroSectionNotes> retroSectionNotesOptional = retroSection.getSectionNotes().stream()
                      .filter(notes -> notes.getNoteId().equals(noteId))
                      .findFirst();
                  retroSectionNotesOptional.ifPresent(retroSectionNotes1 -> retroSectionNotes1.setActive(false));
                  return retroSectionsRepository.save(retroSection).map(retroSection1 ->
                      "Note deleted successfully");
                });
  }


  private Mono<RetroSectionDTO> updateRetroSection(RetroSection retroSection,
      RetroSectionDTO retroSectionDTO){
       retroSection.setColor(retroSectionDTO.getColor());
       retroSection.setThumbsUpRequired(retroSectionDTO.isThumbsUpRequired());
       retroSection.setVotingRequired(retroSectionDTO.isVotingRequired());
       return retroSectionsRepository.save(retroSection).map(AppUtil::RetroSectionEntityToRetroSectionDTO);
  }

  private Mono<String> createRetroSection(RetroSectionDTO retroSectionDTO) {
    RetroSection retroSection =
        AppUtil.RetroSectionDTOTORetroSectionEntity(retroSectionDTO);
    retroSection.setSectionId(UUID.randomUUID().toString());
    return
        retroSectionsRepository.insert(retroSection).map((retroSection1) -> "Retro Section with Title "
            + retroSection1.getSectionName() + " for sprint Board "+ retroSection1.getSprintBoardNumber() + " created successfully");

  }
}
