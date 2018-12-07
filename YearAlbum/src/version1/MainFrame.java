package version1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MainFrame extends JFrame {

	// Frame�� �߰� �� menubarPanel
	JPanel menubarPanel;
	// Frame�� �߰� �� JTabbedPane
	JTabbedPane pane;
	// mouse�� X, Y ��ǥ
	int mouseX;
	int mouseY;

	public MainFrame() {
		Container c = getContentPane();
		// Frame�� Title ���� 
		setTitle("Year Album");
		// JFrame ���� �� ���� ���α׷��� ����ǵ��� ��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// ȭ�� ũ�⸦ ���Ƿ� �������� ���ϰ� ����
		setResizable(true);
		// �޴��ٰ� ������ �ʰԲ� ����
		setUndecorated(false);
		setLocationRelativeTo(null);
		// menubarPanel ��ü ����
		menubarPanel = new MenubarPanel();
		// menubar�� ���� Mouse Event ó��
		menubarPanel.addMouseListener(new MouseAdapter() {
			// ���콺�� �Է������� ������Ʈ���� ���콺�� x��ǥ�� y��ǥ�� �����´�
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		// menuBar�� �巡�� ������ �̺�Ʈ ó���� ���ش�.
		menubarPanel.addMouseMotionListener(new MouseMotionAdapter() {
			// ���콺�� �Է������� ��ũ��(�����)���� ���콺�� x��ǥ�� y��ǥ�� �����´�
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				// ��ũ������ ���콺�� ��ǥ�� ������Ʈ���� ���콺�� ��ǥ�� ���� ����â�� ��ġ�̴�.
				setLocation(x - mouseX, y - mouseY);
			}
		});
		
		// JTabbedPane �߰� 
		pane = new TabbedPane();
		
		// Frame�� menubarPanel �߰�
		add(menubarPanel, BorderLayout.NORTH);
		// Frame�� JTabbedPane �߰�
		add(pane, BorderLayout.CENTER);
		setSize(700, 600);
		setVisible(true);

	}

	public static void main(String args[]) {
		new MainFrame();
	}

}
