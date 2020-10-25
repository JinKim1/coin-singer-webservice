package com.capstone9.coin_singer.domain.comment;

import com.capstone9.coin_singer.domain.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("SELECT c FROM Comment c WHERE c.board_id = ?1")
//    List<Comment> fff(@Param("id") Long id);
    List<Comment> fff(Long id);

}
