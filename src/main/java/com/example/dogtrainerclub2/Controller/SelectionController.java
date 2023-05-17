package com.example.dogtrainerclub2.Controller;

import com.example.dogtrainerclub2.model.SelectionModel;
import com.example.dogtrainerclub2.service.SelectionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:63342")
@AllArgsConstructor
@RequestMapping("Selection")
public class SelectionController {

  private SelectionService selectionService;

  // build create User REST API
  @PostMapping
  public ResponseEntity<SelectionModel> createSelection(@RequestBody SelectionModel selection){
    SelectionModel savedSelection = selectionService.createSelection(selection);
    return new ResponseEntity<>(savedSelection, HttpStatus.CREATED);
  }

  // build get user by id REST API
  // http://localhost:8080/api/users/1
  @GetMapping("{id}")
  public ResponseEntity<SelectionModel> getSelectionById(@PathVariable("id") Long selectionId){
    SelectionModel selection = selectionService.getSelectionUserById(selectionId);
    return new ResponseEntity<>(selection, HttpStatus.OK);
  }

  // Build Get All Users REST API
  // http://localhost:8080/api/users
  @GetMapping
  public ResponseEntity<List<SelectionModel>> getAllSelections(){
    List<SelectionModel> users = selectionService.getAllSelectionUsers();
    return new ResponseEntity<>(users, HttpStatus.OK);
  }

  // Build Update User REST API
  @PutMapping("{id}")
  // http://localhost:8080/api/users/1
  public ResponseEntity<SelectionModel> updateSelection(@PathVariable("id") Long selectionId,
                                         @RequestBody SelectionModel selection){
    selection.setId(selectionId);
    SelectionModel updatedUser = selectionService.updateSelectionUser(selection);
    return new ResponseEntity<>(updatedUser, HttpStatus.OK);
  }

  // Build Delete User REST API
  @DeleteMapping("{id}")
  public ResponseEntity<String> deleteSelection(@PathVariable("id") Long selectionId){
    selectionService.deleteSelectionUser(selectionId);
    return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
  }
}
