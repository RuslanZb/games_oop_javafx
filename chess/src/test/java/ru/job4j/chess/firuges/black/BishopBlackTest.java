package ru.job4j.chess.firuges.black;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void whenTruePosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.B2);
        assertEquals(bishopBlack.position(), (Cell.B2));
    }

    @Test
    public void whenTrueCopy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.B2);
        Figure bishopBlackNew = bishopBlack.copy(Cell.C3);
        assertEquals(bishopBlackNew.position(), (Cell.C3));
    }

    @Test
    public void whenTrueWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertArrayEquals(bishopBlack.way(Cell.G5), (new Cell[]{Cell.D2, Cell.E3,
                Cell.F4, Cell.G5}));
    }

    @Test
    public void whenNotDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertFalse(bishopBlack.isDiagonal(bishopBlack.position(), Cell.A1));
    }

    @Test
    public void whenIsDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D3);
        assertTrue(bishopBlack.isDiagonal(bishopBlack.position(), Cell.B1));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenFalseWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        bishopBlack.way(Cell.G7);
    }
}