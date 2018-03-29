package com.jeffwhenderson.topDown;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Window {
	public Window(int width, int height, String title, Game game) {
		JFrame frame = new JFrame(title);
		
		frame.setPreferredSize(new Dimension(width, height));
//		frame.setMaximumSize(new Dimension(width, height));
//		frame.setMinimumSize(new Dimension(width, height));
		
		frame.add(game); // this is where I feel like game and window are calling back and forth too much
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
}
