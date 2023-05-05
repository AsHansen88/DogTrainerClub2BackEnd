package com.example.dogtrainerclub2.Controller;

import com.example.dogtrainerclub2.model.PostModel;
import com.example.dogtrainerclub2.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.Date;
import java.util.List;

@RestController
public class BlogController {

  @Autowired
  private PostService postService;

  @GetMapping(value = "/")
  public String index(){
    return "index";
  }

  @GetMapping(value = "/posts")
  public List<PostModel> posts(){
    return postService.getAllPosts();
  }

  @PostMapping(value = "/post")
  public void publishPosts(@RequestBody PostModel post){
    if (post.getDateCreated() == null)
    post.setDateCreated(new Date());
    postService.insertPost(post);

  }

}
