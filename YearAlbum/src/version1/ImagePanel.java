package version1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

// ImagePanel 
public class ImagePanel extends JPanel {

	// JButton ������Ʈ��
	JButton addFolderBtn;
	JButton addFileBtn;
	JButton deleteFileBtn;

	// JLabel ������Ʈ��
	JLabel testLabel;
	JPanel imageListPanel;
	JPanel btnPanel;
	
	// ImagePanel ������ 
	public ImagePanel() {

		// FlowLayout ����
		setLayout(new FlowLayout());
		
		// JoinPanel�� Scroll�ٸ� ���� 
		JScrollPane scroll = new JScrollPane(new JoinPanel());
		// ���� �ٸ� ������� �ʵ��� ���� 
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		// �׻�, ���� �ٸ� ����ϵ��� ����
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		// ImageListPanel�� Size ���� 
		scroll.setPreferredSize(new Dimension(500, 400));
	
		// ButtonPanel ��ü ����
		btnPanel = new BtnPanel();
		// ButtonPanel�� size ����
		btnPanel.setPreferredSize(new Dimension(170, 500));
		
		// ImagePanel�� ButtonPanel�� scroll �ǳ� �߰�
		add(scroll);
		add(btnPanel);
	}

	// ButtonPanel Ŭ���� 
	class BtnPanel extends JPanel {

		// ButtonPanel ������
		BtnPanel() {

			// Button���� ���� Box ��ü ���� 
			Box btnBox = Box.createVerticalBox();
	
			// JButton ��ü ���� 
			addFolderBtn = new JButton("���� �߰�");
			addFileBtn = new JButton("���� �߰�");
			deleteFileBtn = new JButton("���� ����");

			// Box�ȿ� �ִ� Component�� ������ ���� ����
			// �������� 80�� ������ ���� 
			btnBox.add(Box.createVerticalStrut(80));
			// Box�� ���� �߰� Button �߰� 
			btnBox.add(addFolderBtn);
			// �ڽ� �ȿ� �ִ� ��ư���� ���� ������ ����
			btnBox.add(Box.createVerticalStrut(80));
			// Box�� ���� �߰� Button �߰�
			btnBox.add(addFileBtn);
			// �ڽ� �ȿ� �ִ� ��ư���� ���� ������ ����
			btnBox.add(Box.createVerticalStrut(80));
			// Box�� ���� ���� Button �߰�
			btnBox.add(deleteFileBtn);

			// ButtonPanel�� ButtonBox �߰�
			add(btnBox);
		
		}
		
		// ButtonUI ����
		public void setButtonUI(JButton button) {
			// �ܰ��� ����
			button.setBorderPainted(false);
			// ���� ü��� ����
			button.setContentAreaFilled(false);
			// ��Ŀ�� �Ǿ����� �׵θ� ����
			button.setFocusPainted(false);
		}
	}

	// ������ Image�� ���� ������ ��� �ִ� Class  
	class ImageListPanel extends JPanel {
		
		// �̹����� �׷��ִ� ��ü ����
		JPanel drawPanel = new DrawPanel();
		// File �̸��� ������ ���� ����
		File f = new File("images/penguin.jpg");
		// f.getName()�� ���� Label ����
		JLabel fileName = new JLabel(f.getName());
		
		ImageListPanel() {
			// Layout ����
			setLayout(new BorderLayout());
			// PreferredSize ���� 
			setPreferredSize(new Dimension(100, 100));
			// Label�� �߾� ����
			fileName.setHorizontalAlignment(SwingConstants.CENTER);
			// Image�� �׷��ִ� Panel �� fileName Panel �߰�
				add(drawPanel, BorderLayout.CENTER);
				add(fileName, BorderLayout.SOUTH);
		}
	}
	
	// ��ģ(Image�� filename)Panel�� �׷��ִ� Panel
	class JoinPanel extends JPanel {
		// 200���� �����ϱ� ���� �迭 ����
		ImageListPanel listPanel[] = new ImageListPanel[200];
		// GridLayout���� ����
		JoinPanel() {
			// GridLayout ����
			setLayout(new GridLayout(0, 4, 5, 5));
			// �ݺ����� ���� ImageListPanel�� �������
			for(int j = 0; j < 200 ; j++) {
				listPanel[j] = new ImageListPanel();
				add(listPanel[j]);
			}
		}
	}
	
	// Panel�� �����Ǹ� �ٹ��� Image�� �׷��� �ǳ�
	class DrawPanel extends JPanel {
		// File�� �̸��� ������ ���� File ��ü
		ImageIcon testImage = new ImageIcon("images/penguin.jpg");
		Image image = testImage.getImage();
		
		// paintComponent�� ���� Image�� �׷��ش�.
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			// paintComponent �޼ҵ�
			g.drawImage(image, 0, 0, this);
		}
	}
	
}
