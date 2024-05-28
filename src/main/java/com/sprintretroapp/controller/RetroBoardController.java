package com.sprintretroapp.controller;

import com.sprintretroapp.model.RetroBoardDTO;
import com.sprintretroapp.service.RetroBoardService;
import com.sprintretroapp.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("/sprint/retroBoard")
@RestController
public class RetroBoardController {

  @Autowired private RetroBoardService retroBoardService;

  @GetMapping
  public Flux<RetroBoardDTO> getAllBoards() {
    return retroBoardService.getAllRetroBoards();
  }

  @PostMapping
  public Mono<RetroBoardDTO> createSprintRetroBoard(
      @RequestBody Mono<RetroBoardDTO> retroBoardDTO) {
     return retroBoardService.saveRetroBoard(retroBoardDTO);
  }
}
