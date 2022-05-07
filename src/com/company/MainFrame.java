package com.company;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    private static final int WIDTH = 1280, HEIGHT = 720;
    private JPanel mainPanel;
    private VisualizerPanel visualizerPanel;
    private FunctionPanel functionPanel;
    private AlgorithmsPanel algorithmsPanel;
    private CodePanel codePanel;

    private int[] arr;

    public void setArr(int[] newArr) {
        arr = newArr;
        visualizerPanel.setArr(arr);
    }

    public int[] getArr() {
        return arr;
    }

    public MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMaximumSize(new Dimension(WIDTH, HEIGHT + 200));
        setMinimumSize(new Dimension(WIDTH, HEIGHT + 20));
        setPreferredSize(new Dimension(WIDTH, HEIGHT + 20));
        setLocationRelativeTo(null);
        setResizable(false);
        setBackground(ColorManager.BACKGROUND);
        setTitle("Sorting Visualizer");

        initialize();
    }

    private void initialize() {
        mainPanel = new JPanel();
        visualizerPanel = new VisualizerPanel(this);
        functionPanel = new FunctionPanel(this);
        codePanel = new CodePanel(this);
        algorithmsPanel = new AlgorithmsPanel(this);

        mainPanel.setLayout(null);
        mainPanel.setBackground(ColorManager.BACKGROUND);

        visualizerPanel.setBounds(0, 0, WIDTH - 13, HEIGHT / 2);
        // visualizePanel.setBackground(ColorManager.BAR_CYAN);
        mainPanel.add(visualizerPanel);

        functionPanel.setBounds(0, HEIGHT / 2, WIDTH / 3, HEIGHT / 2 - 18);
        // functionPanel.setBackground(ColorManager.BAR_ORANGE);
        mainPanel.add(functionPanel);

        algorithmsPanel.setBounds(WIDTH / 3, HEIGHT / 2, WIDTH * 2 / 9 + 1, HEIGHT / 2 - 18);
        // algorithmsPanel.setBackground(ColorManager.BAR_WHITE);
        mainPanel.add(algorithmsPanel);

        codePanel.setBounds(WIDTH * 5 / 9, HEIGHT / 2, WIDTH * 4 / 9 - 13, HEIGHT / 2 - 18);
        // codePanel.setBackground(ColorManager.BAR_RED);
        mainPanel.add(codePanel);

        add(mainPanel);
        pack();
    }
}