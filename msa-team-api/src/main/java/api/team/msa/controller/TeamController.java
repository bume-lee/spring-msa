package api.team.msa.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
public class TeamController {

	@RequestMapping("/")
	public String getNews() {

		return "team Information";
	}

    @RequestMapping("/get")
    public Mono<ResponseEntity> getTeamCount(@RequestParam(value="teamId") int teamId) {
      System.out.println("add team info Count / teamId Id : "+teamId);

      return Mono.just(ResponseEntity.ok().build());
    }
    
}

