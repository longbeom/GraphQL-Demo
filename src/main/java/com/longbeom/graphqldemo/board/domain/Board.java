package com.longbeom.graphqldemo.board.domain;

import com.longbeom.graphqldemo.board.interfaces.dto.BoardCreateRequest;
import com.longbeom.graphqldemo.board.interfaces.dto.BoardUpdateRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "BOARD")
@Entity
public class Board {
    @Id
    private String id;

    private String title;

    private String content;

    public static Board create(BoardCreateRequest request) {
        return Board.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build();
    }

    public void update(BoardUpdateRequest request) {
        this.title = request.getTitle();
        this.content = request.getContent();
    }
}
