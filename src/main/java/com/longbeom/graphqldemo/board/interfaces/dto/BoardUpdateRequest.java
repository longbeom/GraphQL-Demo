package com.longbeom.graphqldemo.board.interfaces.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class BoardUpdateRequest {
    @NotNull(message = "The id must not be Null")
    private String id;
    @NotNull(message = "The title must not be Null")
    private String title;
    @NotNull(message = "The content must not be Null")
    private String content;
}
