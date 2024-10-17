package casillaObjetos;

import inicioDeSesión.User;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectCharacter extends JFrame {
    private int currentIndex1 = 0;
    private int currentIndex2 = 0;
    private List<Image> images1;
    private List<Image> images2;
    private JLabel characters1;
    private JLabel characters2;
    private JLabel characterName1;
    private JLabel characterName2;
    private Map<String, Color> elementColors;
    private boolean checked1 = false;
    private boolean checked2 = false;
    private List<Character> team1;
    private List<Character> team2;
    private JPanel leftPanel;
    private JSlider lifeSlider1;
    private JSlider damageSlider1;
    private JSlider manaSlider1;
    private JSlider lifeSlider2;
    private JSlider damageSlider2;
    private JSlider manaSlider2;
    private JPanel rightPanel;
    private List<Integer> selectedCharacters;
    private JLabel lifeValue1;
    private JLabel damageValue1;
    private JLabel manaValue1;
    private JLabel damageValue2;
    private JLabel manaValue2;
    private JLabel lifeValue2;


    public SelectCharacter(User usuario1, User usuario2, int numCharacter) {
        team1 = new ArrayList<>();
        team2 = new ArrayList<>();
        selectedCharacters = new ArrayList<>();
        elementColors = createElementColors();

        setTitle("LeagueTEC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);

        images1 = getCharacterImages();
        images2 = getCharacterImages();

        characterName1 = createCharacterLabel(currentIndex1);
        JLabel abilities1 = createLabel("Habilidades", 160, 55, 190, 25, 14);
        JLabel abilityI1 = createAbilityLabel(currentIndex1, 0, 160, 75);
        JLabel abilityI2 = createAbilityLabel(currentIndex1, 1, 160, 95);

        lifeValue1 = createValueLabel(String.valueOf(CharacterRepository.CHARACTERS.get(currentIndex1).getLife()), 295, 122);
        JLabel life1 = createLabel("Vida", 160, 122, 190, 25, 11);
        lifeSlider1 = createSlider(430, 600, CharacterRepository.CHARACTERS.get(currentIndex1).getLife(), 190, 125, new Color(50, 205, 50), new Color(0,0,0), e -> {
            //updateImageSize(lifeSlider1, characters1, images1, currentIndex1);
            lifeValue1.setText(String.valueOf(lifeSlider1.getValue()));
        });

        JLabel damageValue1 = createValueLabel(String.valueOf(CharacterRepository.CHARACTERS.get(currentIndex1).getDamage()) , 295, 142);
        JLabel damage1 = createLabel("Daño", 160, 142, 190, 25, 11);
        damageSlider1 = createSlider(50, 70, CharacterRepository.CHARACTERS.get(currentIndex1).getDamage(), 190, 145, new Color(11,23,31), new Color(21,213,111), e -> {
            //updateImageSize(damageSlider1, characters1, images1, currentIndex1);
            damageValue1.setText(String.valueOf(damageSlider1.getValue()));
        });

        JLabel manaValue1 = createValueLabel(String.valueOf(CharacterRepository.CHARACTERS.get(currentIndex1).getMana()), 295, 162);
        JLabel mana1 = createLabel("Maná", 160, 162, 190, 25, 11);
        manaSlider1 = createSlider(180, 250, CharacterRepository.CHARACTERS.get(currentIndex1).getMana(), 190, 165, new Color(21,112,212), new Color(213,11,0), e -> {
            //updateImageSize(manaSlider1, characters1, images1, currentIndex1);
            manaValue1.setText(String.valueOf(manaSlider1.getValue()));
        });

        leftPanel = createPanel(new Color(117, 2, 2), 400, 600);
        RoundedPanel charactersRD = createRoundedPanel(30, 60, 340, 200, Color.WHITE);

        JLabel jugador1 = createLabel(usuario1.getUserName(), 30, 15, 340, 25, 20, Color.WHITE, SwingConstants.CENTER);
        characters1 = new RoundedImageLabel(new ImageIcon(resizeImage(images1.get(currentIndex1), 140, 180)));
        characters1.setBounds(10, 10, 140, 180);

        JButton addButton1 = createButton("Agregar", 145, 275, e -> {
            addCharacterToTeam(team1, currentIndex1, numCharacter, false, lifeSlider1.getValue(), damageSlider1.getValue(), manaSlider1.getValue());
            navigateCharacter(1, images1, characters1, characterName1, abilityI1, abilityI2, true);
        });

        JButton prevButton1 = createNavigationButton("todo/images/leftArrow.png",0, 143, e -> navigateCharacter(-1, images1, characters1, characterName1, abilityI1, abilityI2, true));
        JButton nextButton1 = createNavigationButton("todo/images/rightArrow.png", 368, 143, e -> navigateCharacter(1, images1, characters1, characterName1, abilityI1, abilityI2, true));
        JButton checkButton1 = createCheckButton(335, 469, numCharacter, team1, true);

        addComponentsToPanel(charactersRD, characterName1, characters1, lifeSlider1, abilities1, abilityI1, abilityI2, life1, damage1, mana1, damageSlider1, lifeValue1, damageValue1, manaSlider1, manaValue1);
        addComponentsToPanel(leftPanel, jugador1, charactersRD, addButton1, prevButton1, nextButton1, checkButton1);
        addSpacesToPanel(leftPanel, numCharacter);

        characterName2 = createCharacterLabel(currentIndex2);
        JLabel abilities2 = createLabel("Habilidades", 160, 55, 190, 25, 14);
        JLabel abilityII1 = createAbilityLabel(currentIndex2, 0, 160, 75);
        JLabel abilityII2 = createAbilityLabel(currentIndex2, 1, 160, 95);

        lifeValue2 = createValueLabel(String.valueOf(CharacterRepository.CHARACTERS.get(currentIndex2).getLife()), 295, 122);
        JLabel life2 = createLabel("Vida", 160, 122, 190, 25, 11);
        lifeSlider2 = createSlider(430, 600, CharacterRepository.CHARACTERS.get(currentIndex2).getLife(), 190, 125, new Color(50, 205, 50), new Color(0,0,0), e -> {
            //updateImageSize(lifeSlider2, characters2, images2, currentIndex2);
            lifeValue2.setText(String.valueOf(lifeSlider2.getValue()));
        });

        JLabel damageValue2 = createValueLabel(String.valueOf(CharacterRepository.CHARACTERS.get(currentIndex2).getDamage()) , 295, 142);
        JLabel damage2 = createLabel("Daño", 160, 142, 190, 25, 11);
        damageSlider2 = createSlider(50, 70, CharacterRepository.CHARACTERS.get(currentIndex2).getDamage(), 190, 145, new Color(11,23,31), new Color(21,213,111), e -> {
            //updateImageSize(damageSlider2, characters2, images2, currentIndex2);
            damageValue2.setText(String.valueOf(damageSlider2.getValue()));
        });

        JLabel manaValue2 = createValueLabel(String.valueOf(CharacterRepository.CHARACTERS.get(currentIndex2).getMana()), 295, 162);
        JLabel mana2 = createLabel("Maná", 160, 162, 190, 25, 11);
        manaSlider2 = createSlider(180, 250, CharacterRepository.CHARACTERS.get(currentIndex2).getMana(), 190, 165, new Color(21,112,212), new Color(213,11,0), e -> {
            //updateImageSize(manaSlider2, characters2, images2, currentIndex2);
            manaValue2.setText(String.valueOf(manaSlider2.getValue()));
        });

        rightPanel = createPanel(new Color(11, 25, 71), 400, 600);
        RoundedPanel charactersRD2 = createRoundedPanel(30, 60, 340, 200, Color.WHITE);

        JLabel jugador2 = createLabel(usuario2.getUserName(), 30, 15, 340, 25, 20, Color.WHITE, SwingConstants.CENTER);
        characters2 = new RoundedImageLabel(new ImageIcon(resizeImage(images2.get(currentIndex2), 140, 180)));
        characters2.setBounds(10, 10, 140, 180);

        JButton addButton2 = createButton("Agregar", 145, 275, e -> {
            addCharacterToTeam(team2, currentIndex2, numCharacter, true, lifeSlider2.getValue(), damageSlider2.getValue(), manaSlider2.getValue());
            navigateCharacter(1, images2, characters2, characterName2, abilityII1, abilityII2, false);
        });
        JButton prevButton2 = createNavigationButton("todo/images/leftArrow.png", 0, 143, e ->
                navigateCharacter(-1, images2, characters2, characterName2, abilityII1, abilityII2, false));
        JButton nextButton2 = createNavigationButton("todo/images/rightArrow.png", 368, 143, e ->
                navigateCharacter(1, images2, characters2, characterName2, abilityII1, abilityII2, false));
        JButton checkButton2 = createCheckButton(335, 469, numCharacter, team2, false);

        addComponentsToPanel(charactersRD2, characterName2, characters2, lifeSlider2, abilities2, abilityII1, abilityII2, life2, damage2, mana2, damageSlider2, lifeValue2, damageValue2, manaSlider2, manaValue2);
        addComponentsToPanel(rightPanel, jugador2, charactersRD2, addButton2, prevButton2, nextButton2, checkButton2);
        addSpacesToPanel(rightPanel, numCharacter);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        splitPane.setDividerLocation(400);
        splitPane.setDividerSize(10);

        add(splitPane, BorderLayout.CENTER);
        setSize(800, 600);
    }



    private List<Image> getCharacterImages() {
        List<Image> images = new ArrayList<>();
        for (Character character : CharacterRepository.CHARACTERS) {
            images.add(character.getAspect());
        }
        return images;
    }

    private Image resizeImage(Image originalImage, int width, int height) {
        BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, width, height, null);
        g.dispose();
        return resizedImage;
    }

    private Map<String, Color> createElementColors() {
        Map<String, Color> colors = new HashMap<>();
        colors.put("fuego", new Color(252, 75, 8));
        colors.put("agua", new Color(135, 206, 250));
        colors.put("tierra", new Color(139, 69, 19));
        colors.put("aire", new Color(192, 217, 222));
        return colors;
    }

    private JLabel createCharacterLabel(int index) {
        JLabel label = new JLabel(CharacterRepository.CHARACTERS.get(index).getName(), SwingConstants.CENTER);
        label.setBounds(190, 20, 110, 25);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        String element = CharacterRepository.CHARACTERS.get(index).getElement().toLowerCase().trim();
        label.setForeground(elementColors.get(element));
        return label;
    }

    private JLabel createLabel(String text, int x, int y, int width, int height, int fontSize) {
        return createLabel(text, x, y, width, height, fontSize, Color.BLACK, SwingConstants.LEFT);
    }

    private JLabel createLabel(String text, int x, int y, int width, int height, int fontSize, Color color, int alignment) {
        JLabel label = new JLabel(text, alignment);
        label.setBounds(x, y, width, height);
        label.setFont(new Font("Arial", Font.BOLD, fontSize));
        label.setForeground(color);
        return label;
    }

    private JLabel createAbilityLabel(int index, int abilityIndex, int x, int y) {
        JLabel label = new JLabel("• " + CharacterRepository.CHARACTERS.get(index).getAbilities()[abilityIndex].nombre);
        label.setBounds(x, y, 190, 25);
        label.setFont(new Font("Arial", Font.PLAIN, 12));
        label.setForeground(Color.BLACK);
        return label;
    }

    private JSlider createSlider(int min, int max, int value, int x, int y, Color background, Color foreground, ChangeListener listener) {
        JSlider slider = new JSlider(min, max, value);
        slider.setBounds(x, y, 115, 20);
        slider.addChangeListener(listener);
        return slider;
    }


    private JLabel createValueLabel(String text, int x, int y) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setBounds(x, y, 40, 25);
        label.setFont(new Font("Arial", Font.BOLD, 11));
        label.setForeground(Color.BLACK);
        return label;
    }

    private JPanel createPanel(Color color, int width, int height) {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(width, height));
        panel.setMaximumSize(new Dimension(width, height));
        panel.setMinimumSize(new Dimension(width, height));
        panel.setBackground(color);
        return panel;
    }

    private RoundedPanel createRoundedPanel(int x, int y, int width, int height, Color color) {
        RoundedPanel panel = new RoundedPanel();
        panel.setLayout(null);
        panel.setBounds(x, y, width, height);
        panel.setPreferredSize(new Dimension(width, height));
        panel.setMaximumSize(new Dimension(width, height));
        panel.setMinimumSize(new Dimension(width, height));
        panel.backgroundColor = color;
        return panel;
    }

    private JButton createButton(String text, int x, int y, ActionListener listener) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 100, 30);
        button.setBackground(Color.WHITE);
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(true);
        button.setContentAreaFilled(true);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.addActionListener(listener);
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(Color.LIGHT_GRAY);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(Color.WHITE);
            }
        });
        return button;
    }

    private JButton createNavigationButton(String iconPath, int x, int y, ActionListener listener) {
        JButton button = new JButton(new ImageIcon(iconPath));
        button.setBounds(x, y, 32, 32);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(true);
        button.setContentAreaFilled(false);
        button.addActionListener(listener);
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setIcon(new ImageIcon(iconPath.replace(".png", "Hover.png")));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setIcon(new ImageIcon(iconPath));
            }
        });
        return button;
    }

    private JButton createCheckButton(int x, int y, int numCharacter, List<Character> team, boolean isFirstButton) {
        JButton button = new JButton(new ImageIcon("todo/images/unchecked.png"));
        button.setBounds(x, y, 32, 32);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(true);
        button.setContentAreaFilled(false);
        button.addActionListener(e -> {
            if (team.size() == numCharacter) {
                if (isFirstButton) {
                    checked1 = !checked1;
                } else {
                    checked2 = !checked2;
                }
                button.setIcon(new ImageIcon("todo/images/" + ((isFirstButton ? checked1 : checked2) ? "checked" : "unchecked") + ".png"));
                checkBothButtons();
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar " + numCharacter + " personajes");
            }
        });
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setIcon(new ImageIcon("todo/images/" + ((isFirstButton ? checked1 : checked2) ? "checked" : "unchecked") + "Hover.png"));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setIcon(new ImageIcon("todo/images/" + ((isFirstButton ? checked1 : checked2) ? "checked" : "unchecked") + ".png"));
            }
        });
        return button;
    }

    private void checkBothButtons() {
        if (checked1 && checked2) {
            dispose();
        }
    }

    private void addComponentsToPanel(JPanel panel, Component... components) {
        for (Component component : components) {
            panel.add(component);
        }
    }

    private void addSpacesToPanel(JPanel panel, int numCharacter) {
        int[][] positions = getSpacePositions(numCharacter);
        for (int[] pos : positions) {
            RoundedPanel space = createRoundedPanel(pos[0], pos[1], 90, 90, Color.WHITE);
            RoundedPanel frame = createRoundedPanel(5, 5, 80, 80, Color.WHITE);
            frame.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            space.add(frame);
            panel.add(space);
        }
    }

    private void placeCharacterImage(Image image, int index, int numCharacter, boolean isSecondTeam) {
        int[][] positions = getSpacePositions(numCharacter);
        int[] pos = positions[index];
        RoundedPanel space = createRoundedPanel(pos[0], pos[1], 90, 90, Color.WHITE);
        RoundedImageLabel frame = new RoundedImageLabel(new ImageIcon(resizeImage(image, 80, 80)));
        frame.setBounds(5, 5, 80, 80);
        space.setLayout(null);
        space.add(frame);

        JPanel targetPanel = isSecondTeam ? rightPanel : leftPanel;
        Component existingComponent = targetPanel.getComponentAt(pos[0], pos[1]);
        if (existingComponent != null) {
            targetPanel.remove(existingComponent);
        }

        targetPanel.add(space);
        targetPanel.revalidate();
        targetPanel.repaint();
    }

    private int[][] getSpacePositions(int numCharacter) {
        if (numCharacter == 3) {
            return new int[][]{{66, 330}, {234, 330}, {150, 450}};
        } else if (numCharacter == 4) {
            return new int[][]{{66, 320}, {234, 320}, {66, 440}, {234, 440}};
        } else {
            return new int[][]{{25, 320}, {150, 320}, {275, 320}, {87, 440}, {212, 440}};
        }
    }

    private void updateImageSize(JSlider slider, JLabel label, List<Image> images, int index) {
        int newSize = slider.getValue();
        label.setIcon(new ImageIcon(resizeImage(images.get(index), newSize, newSize)));
    }

    private boolean isCharacterInTeam(int index, List<Character> team) {
        Character character = CharacterRepository.CHARACTERS.get(index);
        return team.stream().anyMatch(c -> c.getName().equals(character.getName()));
    }

    private void updateCharacterName(int currentIndex, JLabel characterNameLabel) {
        Character character = CharacterRepository.CHARACTERS.get(currentIndex);
        characterNameLabel.setText(character.getName());
        String element = character.getElement().toLowerCase().trim();
        characterNameLabel.setForeground(elementColors.get(element));
    }

    private void updateAbilities(int currentIndex, JLabel ability1, JLabel ability2) {
        Character character = CharacterRepository.CHARACTERS.get(currentIndex);
        ability1.setText("• " + character.getAbilities()[0].nombre);
        ability2.setText("• " + character.getAbilities()[1].nombre);
    }

    private void navigateCharacter(int direction, List<Image> images, JLabel label, JLabel nameLabel, JLabel abilityLabel1, JLabel abilityLabel2, boolean isFirstPlayer) {
        int targetIndex = isFirstPlayer ? currentIndex1 : currentIndex2;
        List<Character> currentTeam = isFirstPlayer ? team1 : team2;

        // Navega por los personajes hasta encontrar uno que no esté en el equipo actual
        do {
            targetIndex = (targetIndex + direction + images.size()) % images.size();
        } while (isCharacterInTeam(targetIndex, currentTeam));

        Image targetImage = images.get(targetIndex);
        animateImageTransition(label, targetImage, 140, 180);

        // Actualiza el índice
        if (isFirstPlayer) {
            currentIndex1 = targetIndex;
            updateSliders(lifeSlider1, damageSlider1, manaSlider1, currentIndex1);
        } else {
            currentIndex2 = targetIndex;
            updateSliders(lifeSlider2, damageSlider2, manaSlider2, currentIndex2);
        }

        // Actualiza la información del personaje
        updateCharacterName(targetIndex, nameLabel);
        if (abilityLabel1 != null && abilityLabel2 != null) {
            updateAbilities(targetIndex, abilityLabel1, abilityLabel2);
        }


    }

    private void animateImageTransition(JLabel label, Image targetImage, int width, int height) {
        Timer timer = new Timer(10, null);
        timer.addActionListener(new ActionListener() {
            int step = 0;
            int totalSteps = 20;
            Image initialImage = ((ImageIcon) label.getIcon()).getImage();

            @Override
            public void actionPerformed(ActionEvent e) {
                step++;
                float ratio = (float) step / totalSteps;
                Image blendedImage = blendImages(initialImage, targetImage, ratio, width, height);
                label.setIcon(new ImageIcon(blendedImage));
                if (step >= totalSteps) {
                    timer.stop();
                }
            }
        });
        timer.start();
    }

    private Image blendImages(Image img1, Image img2, float ratio, int width, int height) {
        BufferedImage blendedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = blendedImage.createGraphics();
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1 - ratio));
        g.drawImage(img1, 0, 0, width, height, null);
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, ratio));
        g.drawImage(img2, 0, 0, width, height, null);
        g.dispose();
        return blendedImage;
    }


    private void addCharacterToTeam(List<Character> team, int index, int numCharacter, boolean isSecondTeam, int life, int damage, int mana) {
        Character original = CharacterRepository.CHARACTERS.get(index);
        boolean alreadyInTeam = team.stream().anyMatch(c -> c.getName().equals(original.getName()));

        if ((isSecondTeam && images2.contains(original.getAspect())) || (!isSecondTeam && images1.contains(original.getAspect()))) {
            if (team.size() < numCharacter && !alreadyInTeam) {
                Character clone = new Character(
                        original.getName(),
                        life,
                        damage,
                        original.getElement(),
                        original.getAbilities(),
                        mana,
                        original.movements,
                        original.getAspect()
                );
                team.add(clone);
                placeCharacterImage(clone.getAspect(), team.size() - 1, numCharacter, isSecondTeam);
            } else {
                JOptionPane.showMessageDialog(null, "Ya seleccionó " + numCharacter + " personajes");
            }
        }
    }

    private void updateSliders(JSlider lifeSlider, JSlider damageSlider, JSlider manaSlider, int index) {
        Character character = CharacterRepository.CHARACTERS.get(index);
        lifeSlider.setValue((int) character.getLife());
        damageSlider.setValue((int) character.getDamage());
        manaSlider.setValue((int) character.getMana());
    }
}