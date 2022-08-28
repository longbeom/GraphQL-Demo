package com.longbeom.graphqldemo.board.interfaces.dto;

import com.longbeom.graphqldemo.board.domain.Board;
import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class BoardResponse {
    String id;
    String title;
    String content;

    public static BoardResponse of(Board board) {
        return BoardResponse.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getTitle())
                .build();
    }
}
