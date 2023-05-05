package com.example.dogtrainerclub2.repository;

import com.example.dogtrainerclub2.model.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostModel, Long> {
}
