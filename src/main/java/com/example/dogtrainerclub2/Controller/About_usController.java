package com.example.dogtrainerclub2.Controller;

import com.example.dogtrainerclub2.model.About_usModel;
import com.example.dogtrainerclub2.service.impl.About_usService_impl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:63342")
@AllArgsConstructor
@RequestMapping("/About")
public class About_usController {

  private About_usService_impl about_usService_impl;

  // build create User REST API
  @PostMapping
  public ResponseEntity<About_usModel> createUser(@RequestBody About_usModel member){
    About_usModel savedUser = about_usService_impl.createAboutUsModel(member);
    return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
  }

  // build get user by id REST API
  // http://localhost:8080/api/users/1
  @GetMapping("{id}")
  public ResponseEntity<About_usModel> getUserById(@PathVariable("id") Long id){
    About_usModel member = about_usService_impl.getAboutUsModelById(id);
    return new ResponseEntity<>(member, HttpStatus.OK);
  }

  // Build Get All Users REST API
  // http://localhost:8080/api/users

  @GetMapping
  public ResponseEntity<List<About_usModel>> getAllUsers(){
    List<About_usModel> member = about_usService_impl.getAllAboutUsModel();
    return new ResponseEntity<>(member, HttpStatus.OK);
  }

  // Build Update User REST API
  @PutMapping("{id}")
  // http://localhost:8080/api/users/1
  public ResponseEntity<About_usModel> updateUser(@PathVariable("id") Long id,
                                         @RequestBody About_usModel user){
    user.setId(id);
    About_usModel updatedUser = about_usService_impl.updateAboutUsModel(user);
    return new ResponseEntity<>(updatedUser, HttpStatus.OK);
  }

  // Build Delete User REST API
  @DeleteMapping("{id}")
  public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
    about_usService_impl.deleteAboutUsModel(id);
    return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
  }
}


