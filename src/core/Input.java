package core;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import maths.Vector2;

public class Input implements KeyListener, MouseMotionListener, MouseListener {

	private static List<Integer> pressed = new ArrayList<Integer>();
	private static boolean[] keys = new boolean[65536];
	
	public boolean[] mouseButtons = new boolean[5];
	public Vector2 mousePosition = new Vector2(0, 0);
	
	public static boolean keyPressed(int key) {
		return keys[key];
	}

	public static boolean keyTyped(int key) {
		if (!keys[key]) return false;
		if (pressed.contains(new Integer(key))) return false;
		pressed.add(new Integer(key));
		return true;
	}

	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		if (pressed.contains(new Integer(e.getKeyCode()))) pressed.remove(new Integer(e.getKeyCode()));

	}

	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mousePosition.y = e.getY();
		mousePosition.x = e.getX();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mousePosition.y = e.getY();
		mousePosition.x = e.getX();
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == 1) {
			mouseButtons[0] = true;
		} else if (e.getButton() == 3) {
			mouseButtons[1] = true;
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getButton() == 1) {
			mouseButtons[0] = false;
		}else if (e.getButton() == 3) {
			mouseButtons[1] = false;
		}
	}

}
