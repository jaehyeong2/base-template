package jjfactory.template.crud.service;


import jjfactory.template.crud.domain.Board;
import jjfactory.template.crud.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public Board getOne(Long id){
        return boardRepository.findById(id).orElseThrow(() ->{
            throw new NoSuchElementException("조회에 실패하였습니다.");
        });
    }

    public List<Board> getAll(){
        return boardRepository.findAll();
    }

    @Transactional
    public void save(){

    }

    @Transactional
    public void delete(){

    }

    @Transactional
    public void update(){

    }
}
