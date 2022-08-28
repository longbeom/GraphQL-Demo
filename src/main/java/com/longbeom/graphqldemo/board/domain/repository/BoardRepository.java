package com.longbeom.graphqldemo.board.domain.repository;

import com.longbeom.graphqldemo.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, String> {
}
