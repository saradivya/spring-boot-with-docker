package com.sprintretroapp.service;

import com.sprintretroapp.domain.RetroBoard;
import com.sprintretroapp.model.RetroBoardDTO;
import com.sprintretroapp.repository.RetroBoardRepository;
import com.sprintretroapp.util.AppUtil;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RetroBoardService {

  @Autowired private RetroBoardRepository retroBoardRepository;

  // Get all retro boards
  public Flux<RetroBoardDTO> getAllRetroBoards() {
    return retroBoardRepository.findAll().map(AppUtil::RetroBoardEntityToRetroBoardDTO);
  }


  // Create Sprint Retro Board
  public Mono<String> saveRetroBoard(Mono<RetroBoardDTO> retroBoardDTO) {
    return retroBoardDTO
        .flatMap(
            retroBoardDTO1 ->
                retroBoardRepository.findFirstBySprintBoardNumber(
                    retroBoardDTO1.getSprintBoardNumber())
        .hasElement()
        .flatMap(
            exists ->
                Boolean.TRUE.equals(exists)
                    ? Mono.just("RetroBoard for this sprint already exist")
                    : saveRetroBoard(retroBoardDTO1)));
  }

  private Mono<String> saveRetroBoard(RetroBoardDTO retroBoardDTO) {
    RetroBoard retroBoard =
        AppUtil.RetroBoardDTOTORetroBoardEntity(retroBoardDTO);
    retroBoard.setSprintBoardId(UUID.randomUUID().toString());
         return
             retroBoardRepository.insert(retroBoard)
                 .map(retroBoard1 -> "Retro Board for Sprint Number " + retroBoard1.sprintBoardNumber + "created successfully");

  }
}
