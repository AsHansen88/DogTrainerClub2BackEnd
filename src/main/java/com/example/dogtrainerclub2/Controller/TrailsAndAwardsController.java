package com.example.dogtrainerclub2.Controller;

import com.example.dogtrainerclub2.model.TrailsAndAwardsModel;
import com.example.dogtrainerclub2.service.TrailsAndAwardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@CrossOrigin("http://localhost:63342")
public class TrailsAndAwardsController {

  @Autowired
  private TrailsAndAwardsService trailsAndAwardsService;


  @GetMapping(value = "/prover")
  public List<TrailsAndAwardsModel> TrailsAndAwards(){
    return trailsAndAwardsService.getAllTrailsAndAwards();
  }

  @PostMapping(value = "/prove")
  public void publishTrailsAndAwards(@RequestBody TrailsAndAwardsModel trailsAndAwards){
    if (trailsAndAwards.getDateCreated() == null)
      trailsAndAwards.setDateCreated(new Date());
    trailsAndAwardsService.insertTrailsAndAwards(trailsAndAwards);

  }

}
