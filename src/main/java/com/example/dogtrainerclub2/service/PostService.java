package com.example.dogtrainerclub2.service;

import com.example.dogtrainerclub2.model.PostModel;
import com.example.dogtrainerclub2.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

  @Autowired
private PostRepository postRepository;

public List<PostModel> getAllPosts(){
 return postRepository.findAll();
}

public void insertPost(PostModel post){
postRepository.save(post);

}
}
