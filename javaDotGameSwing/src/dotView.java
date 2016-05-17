import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;



public interface dotView extends ActionListener {
	void registerObserver(dotController controll);
	void updatScorePlayerOneScore();
	void updatePlayerTwoScore();
	void updateTurn();
	void updateScreen();
	void updateClickAllowed(JButton clicked);
}