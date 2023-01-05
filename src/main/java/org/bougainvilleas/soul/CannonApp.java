package org.bougainvilleas.soul;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.entity.Entity;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.Map;

import static com.almasb.fxgl.dsl.FXGL.*;
import static org.bougainvilleas.soul.EntityType.BASKET;
import static org.bougainvilleas.soul.EntityType.BULLET;

public class CannonApp extends GameApplication
{
    private Entity cannon;

    @Override
    protected void initSettings(GameSettings settings)
    {
        settings.setWidth(800);
        settings.setHeight(600);
        settings.setTitle("Cannon");
        settings.setVersion("0.2.1");
    }
    @Override
    protected void initInput() {
        onBtnDown(MouseButton.PRIMARY, () -> shoot());
    }

    @Override
    protected void initGameVars(Map<String, Object> vars) {
        vars.put("score", 0);
    }

    @Override
    protected void initGame() {
        getGameWorld().addEntityFactory(new CannonFactory());

        initScreenBounds();
        initCannon();
        initBasket();
    }

    private void initScreenBounds() {
        entityBuilder().buildScreenBoundsAndAttach(100);
    }

    private void initCannon() {
        cannon = spawn("cannon", 50, getAppHeight() - 300);
    }

    private void initBasket() {
        spawn("basketBarrier", 400, getAppHeight() - 300);
        spawn("basketBarrier", 700, getAppHeight() - 300);
        spawn("basketGround", 500, getAppHeight());
    }

    private void shoot() {
        spawn("bullet", cannon.getPosition().add(70, 0));
    }

    @Override
    protected void initPhysics() {
        onCollisionBegin(BULLET, BASKET, (bullet, basket) -> {
            bullet.removeFromWorld();
            inc("score", +1000);
        });
    }

    @Override
    protected void initUI() {
        Text scoreText = getUIFactoryService().newText("", Color.BLACK, 24);
        scoreText.textProperty().bind(getip("score").asString("Score: [%d]"));

        addUINode(scoreText, 550, 100);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
