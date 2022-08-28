package com.longbeom.graphqldemo.board.interfaces;

import com.longbeom.graphqldemo.board.application.BoardService;
import com.longbeom.graphqldemo.board.interfaces.dto.BoardCreateRequest;
import com.longbeom.graphqldemo.board.interfaces.dto.BoardResponse;
import com.longbeom.graphqldemo.board.interfaces.dto.BoardUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {
    private final BoardService boardService;

    @QueryMapping
    public BoardResponse board(@Argument String id) {
        return boardService.findById(id);
    }

    @QueryMapping
    public List<BoardResponse> boardList() {
        return boardService.findAll();
    }

    @MutationMapping
    public BoardResponse create(@Argument BoardCreateRequest request) {
        return boardService.create(request);
    }

    @MutationMapping
    public BoardResponse update(@Argument BoardUpdateRequest request) {
        return boardService.update(request);
    }

    @MutationMapping
    public void delete(@Argument String id) {
        boardService.delete(id);
    }
}
