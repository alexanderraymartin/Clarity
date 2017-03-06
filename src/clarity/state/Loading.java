package clarity.state;

import java.awt.Graphics2D;

public class Loading extends State {

    private Level nextLevel;
    private boolean isRendered;

    public Loading(StateManager manager) {
        super(manager);
        this.background = StateManager.loadingScreen;
    }

    @Override
    public void update() {
        if (isRendered) {
            // TODO: Currently hard-coded to 0 for testing purposes
            manager.setCurrentLevelIndex(0);
            nextLevel = new Level(this.manager);
            manager.loadNextState(this.nextLevel);
        }
    }

    @Override
    public void render(Graphics2D graphics) {
        System.out.println("I am in render in Loading");
        this.background.render(graphics);
        isRendered = true;
    }
}

