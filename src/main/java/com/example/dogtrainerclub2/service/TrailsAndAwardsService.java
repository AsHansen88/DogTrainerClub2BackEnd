package com.example.dogtrainerclub2.service;

import com.example.dogtrainerclub2.model.TrailsAndAwardsModel;
import com.example.dogtrainerclub2.repository.TrailsAndAwardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrailsAndAwardsService {


  @Autowired
  private TrailsAndAwardsRepository trailsAndAwardsRepository;

  public List<TrailsAndAwardsModel> getAllTrailsAndAwards(){
    return trailsAndAwardsRepository.findAll();
  }

  public void insertTrailsAndAwards(TrailsAndAwardsModel trailsAndAwardsModel){
    trailsAndAwardsRepository.save(trailsAndAwardsModel);
  }

}
