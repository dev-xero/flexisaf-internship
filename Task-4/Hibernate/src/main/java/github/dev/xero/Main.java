package github.dev.xero;

import github.dev.xero.config.HibernateConfig;
import github.dev.xero.config.LoggerUtil;
import github.dev.xero.model.*;
import jakarta.persistence.EntityManager;

import java.time.LocalDateTime;

import static github.dev.xero.util.Constants.MINUTE;

public class Main {
    public static void main(String[] args) {
        EntityManager em = HibernateConfig.getEntityManager();
        em.getTransaction().begin();

        Player playerOne = new Player("algo_xero", "xero@email.com", "pass_hash_one");
        Player playerTwo = new Player("torvalds", "torvalds@email.com", "pass_hash_two");
        em.persist(playerOne);
        em.persist(playerTwo);
        LoggerUtil.info("Successfully persisted player one and two");

        Game game = new Game();
        game.setWhitePlayer(playerOne);
        game.setBlackPlayer(playerTwo);
        game.setDuration(0);
        game.setTimeControl(TimeControl.RAPID.minutes * MINUTE);
        game.setIsOngoing(true);
        game.setCreatedAt(LocalDateTime.now());
        em.persist(game);
        LoggerUtil.info("Successfully created game");

        Board initialBoard = new Board();
        initialBoard.setGame(game);
        initialBoard.setFen("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR"); // FEN for starting games
        initialBoard.setWhoseTurn(Color.WHITE);
        initialBoard.setCreatedAt(LocalDateTime.now());
        em.persist(initialBoard);
        LoggerUtil.info("Successfully created initial board state");

        // Let's simulate a move!
        Move move1 = new Move();
        move1.setBoard(initialBoard);
        move1.setColor(Color.WHITE);
        move1.setMoveNumber(1);
        move1.setMoveNotation("e4");
        move1.setFenAfter("rnbqkbnr/pppppppp/8/8/4P3/8/PPPP1PPP/RNBQKBNR");
        move1.setTimeLeftMs(10 * MINUTE);
        move1.setCreatedAt(LocalDateTime.now());
        em.persist(move1);
        LoggerUtil.info("Move 1: e4");

        em.getTransaction().commit();

        LoggerUtil.info("All entities persisted successfully!");
        LoggerUtil.info("Game ID: " + game.getGameId());
        LoggerUtil.info("White player: " + game.getWhitePlayer().getUsername());
        LoggerUtil.info("Black player: " + game.getBlackPlayer().getUsername());

        em.close();
    }
}
