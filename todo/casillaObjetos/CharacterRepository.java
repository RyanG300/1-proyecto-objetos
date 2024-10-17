package casillaObjetos;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CharacterRepository {
    public static final List<Character> CHARACTERS = new ArrayList<>();

    static{
        Ability flareAbility = new Ability("Llamarada",120,  180);
        Ability ashExplosion = new Ability("Explosión de ceniza", 110, 150);
        Ability torrent = new Ability("Torrente", 100, 140);
        Ability wave = new Ability("Oleada", 90, 120);
        Ability earthquake = new Ability("Terremoto", 130, 165);
        Ability rockShield = new Ability("Escudo de roca", 90, 90);
        Ability gust = new Ability("Ráfaga", 140, 180);
        Ability whirlwind = new Ability("Torbellino", 110, 140);
        Ability hellfire = new Ability("Fuego infernal", 130, 175);
        Ability flamingFury = new Ability("Furia llameante", 95, 135);
        Ability highTide = new Ability("Marea alta", 110, 160);
        Ability waterShield = new Ability("Escudo de agua", 95, 110);
        Ability Avalanche = new Ability("Avalancha", 125, 170);
        Ability stoneBarrier = new Ability("Barrera de piedra", 105, 130);
        Ability gale = new Ability("Vendaval", 130, 170);
        Ability cyclone = new Ability("Ciclón", 115, 150);
        Ability fieryExplosion = new Ability("Explosión ígnea", 115, 175);
        Ability fireWall = new Ability("Muro de fuego", 100, 125);
        Ability storm = new Ability("Tormenta", 150, 185);
        Ability windCut = new Ability("Corte de viento", 120, 145);

        Image aquarisImage = new ImageIcon("todo/images/Aquaris.jpg").getImage();
        Image blazeImage = new ImageIcon("todo/images/Blaze.jpg").getImage();
        Image cascadeImage = new ImageIcon("todo/images/Cascade.jpg").getImage();
        Image flareImage = new ImageIcon("todo/images/Flare.jpg").getImage();
        Image infernoImage = new ImageIcon("todo/images/Inferno.jpg").getImage();
        Image quicksandImage = new ImageIcon("todo/images/Quicksand.jpg").getImage();
        Image rockjawImage = new ImageIcon("todo/images/Rockjaw.jpg").getImage();
        Image skybreakerImage = new ImageIcon("todo/images/Skybreaker.jpg").getImage();
        Image tempestImage = new ImageIcon("todo/images/Tempest.jpg").getImage();
        Image zephyrImage = new ImageIcon("todo/images/Zephyr.jpg").getImage();

        Character aquaris = new Character("Aquaris", 520, 50, "Agua", new Ability[]{torrent, wave}, 210, 1, aquarisImage);
        Character blaze = new Character("Blaze", 510,  58, "Fuego", new Ability[]{hellfire, flamingFury}, 220, 2, blazeImage);
        Character cascade = new Character("Cascade", 550,  54, "Agua", new Ability[]{highTide, waterShield}, 200, 1, cascadeImage);
        Character flare = new Character("Flare", 490,  56, "Fuego", new Ability[]{fieryExplosion, fireWall}, 225, 2, flareImage);
        Character inferno = new Character("Inferno", 480,  60, "Fuego", new Ability[]{flareAbility, ashExplosion}, 230, 2, infernoImage);
        Character quicksand = new Character("Quicksand", 580,  50, "Tierra", new Ability[]{Avalanche, stoneBarrier}, 190, 1, quicksandImage);
        Character rockjaw = new Character("Rockjaw", 600,  55, "Tierra", new Ability[]{earthquake, rockShield}, 180, 1, rockjawImage);
        Character skybreaker = new Character("Skybreaker", 440,  65, "Aire", new Ability[]{gust, whirlwind}, 250, 3, skybreakerImage);
        Character tempest = new Character("Tempest", 460,  63, "Aire", new Ability[]{gale, cyclone}, 240,3, tempestImage);
        Character zephyr = new Character("Zephyr", 430,  68, "Aire", new Ability[]{storm, windCut}, 235, 3, zephyrImage);

        CHARACTERS.add(aquaris);
        CHARACTERS.add(blaze);
        CHARACTERS.add(cascade);
        CHARACTERS.add(flare);
        CHARACTERS.add(inferno);
        CHARACTERS.add(quicksand);
        CHARACTERS.add(rockjaw);
        CHARACTERS.add(skybreaker);
        CHARACTERS.add(tempest);
        CHARACTERS.add(zephyr);

    }

}

