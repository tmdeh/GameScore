package com.gamescore.controller;

import com.gamescore.domain.response.DefaultResponse;
import com.gamescore.domain.score.ScoreDTO;
import com.gamescore.service.score.ScoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/score")
public class ScoreController {

    private ScoreService service;

    public ScoreController(ScoreService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity allLanking() throws Exception{
        List<ScoreDTO> list = service.allSearch();
        DefaultResponse<List<ScoreDTO>> responseData = new DefaultResponse<>("OK", 200, list);
        return new ResponseEntity(responseData, HttpStatus.OK);
    }

    @GetMapping("/{nickname}")
    public ResponseEntity searchLanking(@PathVariable(value = "nickname") String nickname) throws Exception{
        return null;
    }

    @GetMapping("/my")
    public ResponseEntity myLanking() throws Exception{
        return null;
    }
}
