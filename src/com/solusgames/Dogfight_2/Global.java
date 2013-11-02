package com.solusgames.Dogfight_2;

import org.lwjgl.util.Dimension;

import com.badlogic.gdx.Input.Keys;
import com.solusgames.entities.planes.Plane;

public class Global {
    // Players
    public static Plane player1;
    public static Plane player2;
    // Game options
    public static boolean paused = false;
    public static boolean fullscreen = false;
    public static boolean vsync = true;
    public static boolean player_collision = false;
    public static boolean singlePlayer = false;
    public static boolean vertical_split = false;
    public static Dimension dim_720 = new Dimension(1280, 720);

    // Scores
    public static int score_p1 = 0, score_p2 = 0;
    // RespawnTimer
    public static final long RESPAWNTIME_PLAYER = 3000L;
    public static final long RESPAWNTIME_TURRET = 9000L;

    public static float music_volume = 0.2f;
    public static float sounds_volume = 0.05f;

    public static int p1_key_left = Keys.LEFT;
    public static int p1_key_right = Keys.RIGHT;
    public static int p1_key_up = Keys.UP;
    public static int p1_key_down = Keys.DOWN;
    public static int p1_key_prim1 = Keys.COMMA;
    public static int p1_key_prim2 = Keys.COMMA;
    public static int p1_key_sec1 = Keys.PERIOD;
    public static int p1_key_sec2 = Keys.MINUS;

    public static int p2_key_left = Keys.D;
    public static int p2_key_right = Keys.G;
    public static int p2_key_up = Keys.R;
    public static int p2_key_down = Keys.F;
    public static int p2_key_prim1 = Keys.NUM_1;
    public static int p2_key_prim2 = Keys.NUM_1;
    public static int p2_key_sec1 = Keys.NUM_2;
    public static int p2_key_sec2 = Keys.NUM_3;
}
