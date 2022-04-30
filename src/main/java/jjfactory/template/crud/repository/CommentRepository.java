package jjfactory.template.crud.repository;

import jjfactory.template.crud.domain.Comment;
import jjfactory.template.crud.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
