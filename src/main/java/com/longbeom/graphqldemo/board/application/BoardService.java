package com.longbeom.graphqldemo.board.application;

import com.longbeom.graphqldemo.board.domain.Board;
import com.longbeom.graphqldemo.board.domain.repository.BoardRepository;
import com.longbeom.graphqldemo.board.interfaces.dto.BoardCreateRequest;
import com.longbeom.graphqldemo.board.interfaces.dto.BoardResponse;
import com.longbeom.graphqldemo.board.interfaces.dto.BoardUpdateRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public BoardResponse findById(@NonNull final String id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        return BoardResponse.of(board);
    }

    @Transactional(readOnly = true)
    public List<BoardResponse> findAll() {
        return boardRepository.findAll()
                .stream()
                .map(BoardResponse::of)
                .collect(Collectors.toList());
    }

    @Transactional
    public BoardResponse create(BoardCreateRequest request) {
        Board board = Board.create(request);
        Board createdBoard = boardRepository.save(board);

        return BoardResponse.of(createdBoard);
    }

    @Transactional
    public BoardResponse update(BoardUpdateRequest request) {
        Board board = boardRepository.findById(request.getId())
                .orElseThrow(EntityNotFoundException::new);

        board.update(request);

        return BoardResponse.of(board);
    }

    @Transactional
    public void delete(@NonNull final String id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        boardRepository.delete(board);
    }
}
