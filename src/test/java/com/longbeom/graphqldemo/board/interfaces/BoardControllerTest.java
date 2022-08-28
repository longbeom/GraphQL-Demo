package com.longbeom.graphqldemo.board.interfaces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.GraphQlTester;

@SpringBootTest
@AutoConfigureGraphQlTester
class BoardControllerTest {
    @Autowired
    private GraphQlTester graphQlTester;

    @DisplayName(value = "1. 게시글 1개 조회하기")
    @Test
    void test_1() {
        this.graphQlTester.documentName("board")
                .variable("id", "1")
                .execute()
                .path("board.title")
                .entity(String.class)
                .isEqualTo("제목1");
    }

    @DisplayName(value = "2. 게시글 전체 조회하기")
    @Test
    void test_2() {
        this.graphQlTester.documentName("boardList")
                .execute()
                .path("boardList[*].title")
                .entityList(String.class)
                .contains("제목1", "제목2", "제목3");
    }
}