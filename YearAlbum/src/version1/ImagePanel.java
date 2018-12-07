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

	// JButton 컴포넌트들
	JButton addFolderBtn;
	JButton addFileBtn;
	JButton deleteFileBtn;

	// JLabel 컴포넌트들
	JLabel testLabel;
	JPanel imageListPanel;
	JPanel btnPanel;
	
	// ImagePanel 생성자 
	public ImagePanel() {

		// FlowLayout 설정
		setLayout(new FlowLayout());
		
		// JoinPanel에 Scroll바를 붙임 
		JScrollPane scroll = new JScrollPane(new JoinPanel());
		// 수평 바를 사용하지 않도록 설정 
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		// 항상, 수직 바만 사용하도록 설정
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		// ImageListPanel의 Size 설정 
		scroll.setPreferredSize(new Dimension(500, 400));
	
		// ButtonPanel 객체 생성
		btnPanel = new BtnPanel();
		// ButtonPanel의 size 설정
		btnPanel.setPreferredSize(new Dimension(170, 500));
		
		// ImagePanel에 ButtonPanel과 scroll 판넬 추가
		add(scroll);
		add(btnPanel);
	}

	// ButtonPanel 클래스 
	class BtnPanel extends JPanel {

		// ButtonPanel 생성자
		BtnPanel() {

			// Button들을 담을 Box 객체 생성 
			Box btnBox = Box.createVerticalBox();
	
			// JButton 객체 생성 
			addFolderBtn = new JButton("폴더 추가");
			addFileBtn = new JButton("파일 추가");
			deleteFileBtn = new JButton("파일 삭제");

			// Box안에 있는 Component의 일정한 간격 설정
			// 수직으로 80의 간격을 설정 
			btnBox.add(Box.createVerticalStrut(80));
			// Box에 폴더 추가 Button 추가 
			btnBox.add(addFolderBtn);
			// 박스 안에 있는 버튼들의 수직 사이의 간격
			btnBox.add(Box.createVerticalStrut(80));
			// Box에 파일 추가 Button 추가
			btnBox.add(addFileBtn);
			// 박스 안에 있는 버튼들의 수직 사이의 간격
			btnBox.add(Box.createVerticalStrut(80));
			// Box에 파일 삭제 Button 추가
			btnBox.add(deleteFileBtn);

			// ButtonPanel에 ButtonBox 추가
			add(btnBox);
		
		}
		
		// ButtonUI 설정
		public void setButtonUI(JButton button) {
			// 외곽선 제거
			button.setBorderPainted(false);
			// 내용 체우기 제거
			button.setContentAreaFilled(false);
			// 포커스 되었을시 테두리 제거
			button.setFocusPainted(false);
		}
	}

	// 각각의 Image에 대한 정보를 담고 있는 Class  
	class ImageListPanel extends JPanel {
		
		// 이미지를 그려주는 객체 생성
		JPanel drawPanel = new DrawPanel();
		// File 이름을 얻어오기 위해 생성
		File f = new File("images/penguin.jpg");
		// f.getName()을 통해 Label 생성
		JLabel fileName = new JLabel(f.getName());
		
		ImageListPanel() {
			// Layout 설정
			setLayout(new BorderLayout());
			// PreferredSize 설정 
			setPreferredSize(new Dimension(100, 100));
			// Label의 중앙 정렬
			fileName.setHorizontalAlignment(SwingConstants.CENTER);
			// Image를 그려주는 Panel 및 fileName Panel 추가
				add(drawPanel, BorderLayout.CENTER);
				add(fileName, BorderLayout.SOUTH);
		}
	}
	
	// 합친(Image와 filename)Panel을 그려주는 Panel
	class JoinPanel extends JPanel {
		// 200개를 생성하기 위해 배열 생성
		ImageListPanel listPanel[] = new ImageListPanel[200];
		// GridLayout으로 설정
		JoinPanel() {
			// GridLayout 설정
			setLayout(new GridLayout(0, 4, 5, 5));
			// 반복문을 통해 ImageListPanel을 만들어줌
			for(int j = 0; j < 200 ; j++) {
				listPanel[j] = new ImageListPanel();
				add(listPanel[j]);
			}
		}
	}
	
	// Panel이 생성되면 앨범의 Image를 그려줄 판넬
	class DrawPanel extends JPanel {
		// File의 이름을 얻어오기 위한 File 객체
		ImageIcon testImage = new ImageIcon("images/penguin.jpg");
		Image image = testImage.getImage();
		
		// paintComponent를 통해 Image를 그려준다.
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			// paintComponent 메소드
			g.drawImage(image, 0, 0, this);
		}
	}
	
}
