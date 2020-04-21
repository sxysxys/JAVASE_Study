package innerclass;

/**
 * @Author: shenge
 * @Date: 2020-04-02 20:46
 * <p>
 * 内部类工厂游戏
 *
 * 封装游戏的构造方法，通过工厂创建实例。
 * 主要解决了有时候构造方法过于冗余，可以通过这种方式很快捷，并且不会出错。
 */

interface Game {
    boolean move();
}

interface GameFactory {
    Game getGame();
}

class Checkers implements Game {
    private Checkers() {
    }

    private int moves=0;

    public static int MOVES=3;

    @Override
    public boolean move() {
        System.out.println("Checkers move "+ moves);
        return ++moves !=MOVES;
    }

    public static GameFactory gameFactory=new GameFactory() {
        @Override
        public Game getGame() {
            return new Checkers();
        }
    };
}

class Chess implements Game{
    private Chess(){
    }
    private int moves=0;
    public static int MOVES=4;

    @Override
    public boolean move() {
        System.out.println("Chess move "+ moves);
        return ++moves!=MOVES;
    }
    public static GameFactory gameFactory=new GameFactory() {
        @Override
        public Game getGame() {
            return new Chess();
        }
    };
}


public class FactoryGames {
    public static void playGame(GameFactory gameFactory){
        Game game = gameFactory.getGame();
        while (game.move()){
        }
    }

    public static void main(String[] args) {
        playGame(Checkers.gameFactory);
        playGame(Chess.gameFactory);
    }
}
