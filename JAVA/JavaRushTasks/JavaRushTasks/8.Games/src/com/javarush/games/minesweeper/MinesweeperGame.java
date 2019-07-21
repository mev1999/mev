package com.javarush.games.minesweeper;

import com.javarush.engine.cell.*;
import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";
    
    private int countMinesOnField = 0;
    private int countFlags;
    private int countClosedTiles = SIDE * SIDE;
    private int score;
    
    private boolean isGameStopped;
    
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];;
    
    private void createGame() {
        boolean isMine;
        countMinesOnField = 0;
        for(int i = 0; i < SIDE; i++) 
            for(int j = 0; j < SIDE; j++) {
                setCellValue(i, j, "");
                isMine = (getRandomNumber(10) > 8);
                if(isMine) countMinesOnField++;
                gameField[i][j] = new GameObject(j,i,isMine);
                setCellColor(i,j, Color.ORANGE);
            }
            countMineNeighbors();
            countFlags = countMinesOnField;
//            countClosedTiles = SIDE * SIDE;
//            isGameStopped = false;
            score = 0;
    }
    
    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }
    
    private void restart() {

        countClosedTiles = SIDE * SIDE;
        countMinesOnField = 0;
        createGame();        
        countFlags = countMinesOnField;
        score = 0;
        setScore(score);
        isGameStopped = false;

    }

    private void openTile(int x, int y) {
        
        if(gameField[y][x].isOpen || gameField[y][x].isFlag || isGameStopped) return;

        gameField[y][x].isOpen = true;
        countClosedTiles--;
        
        if(gameField[y][x].isMine) { // открыли мину
            setCellValueEx(x, y, Color.RED, MINE);
            gameOver();
            return;
        }    
        else {
            setCellColor(x, y, Color.GREEN);
            score+=5;
            if(gameField[y][x].countMineNeighbors > 0)
                setCellNumber(x, y, gameField[y][x].countMineNeighbors); 
            else { // 0 соседей    
                setCellValue(x, y, "");
            // откроем соседние ячейки при нулевой текущей
                List<GameObject> neighbors = getNeighbors(gameField[y][x]);
                for(GameObject o : neighbors) 
                    if(!o.isOpen) openTile(o.x, o.y);
            }
        }    
        setScore(score);
        if(countMinesOnField == countClosedTiles) win();
    }

    private void markTile(int x, int y) {
        if(isGameStopped) return;
        if(gameField[y][x].isOpen) return; // для открытых ячеек флаг не ставим
        
        if(gameField[y][x].isFlag) { // снять флаг
            gameField[y][x].isFlag = false;
            setCellValue(x, y, "");
            setCellColor(x, y, Color.ORANGE);
            countFlags++;
        }    
        else { // установить флаг
            if(countFlags == 0) return; // флаги кончились
            gameField[y][x].isFlag = true;
            setCellValue(x, y, FLAG);
            setCellColor(x, y, Color.YELLOW);
            countFlags--;
        }    
    }
    
    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.RED, "Game over !", Color.YELLOW, 24);
    }
    
    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.ORANGE, "You win !", Color.GREEN, 24);
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        if(isGameStopped) restart();
        else    openTile(x, y);
    }

    @Override
    public void onMouseRightClick(int x, int y) {
        markTile(x, y);
    }

    // 123 
    // 4O5          
    // 678
    
    private List<GameObject> getNeighbors(GameObject cell) {
        List<GameObject> neighbors = new ArrayList<GameObject>();

        if(cell.x > 0) neighbors.add(gameField[cell.y][cell.x - 1]); // 4
        if(cell.x > 0 && cell.y > 0) neighbors.add(gameField[cell.y - 1][cell.x - 1]); // 1
        if(cell.x > 0  && cell.y < SIDE-1) neighbors.add(gameField[cell.y+1][cell.x - 1]); // 6
        
        if(cell.y > 0) neighbors.add(gameField[cell.y-1][cell.x]); // 2
        if(cell.y < SIDE-1) neighbors.add(gameField[cell.y+1][cell.x]); // 7
        
        if(cell.x < SIDE-1) neighbors.add(gameField[cell.y][cell.x + 1]); // 5 
        if(cell.x < SIDE-1 && cell.y > 0) neighbors.add(gameField[cell.y - 1][cell.x + 1]); // 3
        if(cell.x < SIDE-1 && cell.y < SIDE-1) neighbors.add(gameField[cell.y + 1][cell.x + 1]); // 8
        
        return neighbors;
    }
    
    private void countMineNeighbors() {
        for(int i = 0; i < SIDE; i++) 
            for(int j = 0; j < SIDE; j++) {
                if(!gameField[j][i].isMine) {
                    gameField[j][i].countMineNeighbors = 0;
                    List<GameObject> neighbors = getNeighbors(gameField[j][i]);
                    for(GameObject o : neighbors)
                        if(o.isMine) gameField[j][i].countMineNeighbors++;
                }
            }

    }

}