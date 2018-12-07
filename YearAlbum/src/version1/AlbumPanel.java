package version1;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class AlbumPanel extends JPanel {

	// 왼쪽 버튼 기본 이미지
	ImageIcon leftButtonBasicImage = new ImageIcon("images/leftButtonBasicImage.png");
	// 왼쪽 버튼 Enter 이미지
	ImageIcon leftButtonEnterImage = new ImageIcon("images/leftButtonEnterImage.png");
	// 오른쪽 버튼 기본 이미지
	ImageIcon rightButtonBasicImage = new ImageIcon("images/rightButtonBasicImage.png");
	// 오른쪽 버튼 Enter 이미지
	ImageIcon rightButtonEnterImage = new ImageIcon("images/rightButtonEnterImage.png");

	// CardLayout을 통해 변경할 Panel
	JPanel firstPanel;
	JPanel secondPanel;
	JPanel thirdPanel;
	// CardLayout 객체 생성
	CardLayout card = new CardLayout();

	public AlbumPanel() {
		// BorderLayout 설정 
		setLayout(new BorderLayout());
		// cardLayout 레이아웃을 가진 객체 생성
		JPanel cardPanel = new cardPanel();
		// cardPanel을 추가, BorderLayout CENTER
		add(cardPanel, BorderLayout.CENTER);
	}

	// cardLayout을 가진 cardPanel 클래스  
	class cardPanel extends JPanel {

		cardPanel(){
			// CardLayout 설정
			setLayout(card);

			// 각각의 Panel 객체 생성
			firstPanel = new FirstPanel();
			secondPanel = new SecondPanel();
			thirdPanel = new ThirdPanel();

			// CardLayout에 Panel 추가
			add(firstPanel, "first");
			add(secondPanel, "second");
			add(thirdPanel, "third");
		}

	}


	// 첫 번째 화면
	class FirstPanel extends JPanel {
		// 오른쪽 버튼 기본 이미지
		ImageIcon rightButtonBasicImage = new ImageIcon("images/rightButtonBasicImage.png");
		// 오른쪽 버튼 Enter 이미지
		ImageIcon rightButtonEnterImage = new ImageIcon("images/rightButtonEnterImage.png");
		// 화면 제어를 할 Button들
		JButton rightButton = new JButton(rightButtonBasicImage);
		JButton leftButton = new JButton("leftButton");
		JButton titleButton = new JButton("제목 설정");
		JButton subtitleButton = new JButton("부제목 설정");
		JButton inputModifyButton = new JButton("입력 수정");
		JButton backgroundButton = new JButton("배경 설정");
		// 제목, 부제목 설정시 출력할 JLabel 들
		JLabel titleLabel = new JLabel("The Memory 2014(우리가족 2014년 이야기)");
		JLabel subtitleLabel = new JLabel("행복했던 시간들!");
		// test 이미지
		ImageIcon testImage = new ImageIcon("images/book.png");
		// Label에 book 이미지 등록
		JLabel book = new JLabel(testImage);
		// 앞으로, 뒤로 Label
		JLabel previousLabel = new JLabel("앞으로");
		JLabel nextLabel = new JLabel("뒤로");

		FirstPanel() {
			// Button의 위치가 일정하지 않으므롤 layout을 null로 설정
			setLayout(null);
			// setBounds를 통해 Button의 x, y 좌표 및 Size 설정
			rightButton.setBounds(540, 170, 40, 75);
			// rightButton 클릭 시 다음 Panel이 출력되도록 설정
			rightButton.addMouseListener(new MouseAdapter() {
				// 버튼 입력 시 cardLayout에 입력 된 다음 판넬로 넘어가도록 함
				public void mousePressed(MouseEvent e) {
					card.next(FirstPanel.this.getParent());
				}

			});
			// leftButton 위치, 모양 설정
			leftButton.setBounds(15, 170, 40, 75);

			// 세로로 출력할 JLabel
			JLabel upDownLabel = new JLabel(transformStringToHtml("The Memory 2014"));
			// Label 중앙 설정
			upDownLabel.setHorizontalAlignment(JLabel.CENTER);
			// Label 위치, 모양 설정
			upDownLabel.setBounds(225, -150, 100, 500);

			// 제목 Label, 부제목 Label 위치 모양 설정 
			titleLabel.setBounds(350, 80, 180, 50);
			subtitleLabel.setBounds(350, 100, 180, 50);
			// Label RIGHT 정렬
			titleLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			subtitleLabel.setHorizontalAlignment(SwingConstants.RIGHT);

			// 앞으로, 뒤로 Label 위치 모양 설정 
			previousLabel.setBounds(15, 240, 180, 50);
			nextLabel.setBounds(550, 240, 180, 50);

			// 버튼들의 위치, 모양 설정
			titleButton.setBounds(350, 60, 75, 30);
			subtitleButton.setBounds(350, 140, 75, 30);
			inputModifyButton.setBounds(450, 140, 75, 30);
			backgroundButton.setBounds(600, 150, 75, 30);
			// ButtonUI 설정
			// setButtonUI(rightButton);
			// Btn 추가
			leftButton.setEnabled(false);
			add(titleButton);
			add(subtitleButton);
			add(rightButton);
			add(leftButton);
			add(inputModifyButton);
			add(backgroundButton);
			// Label 추가
			add(previousLabel);
			add(nextLabel);
			add(titleLabel);
			add(subtitleLabel);
			add(upDownLabel);

		}
		// ButtonUI 설정 메소드 
		public void setButtonUI(JButton button) {
			// 외곽선 제거
			button.setBorderPainted(false);
			// 내용 체우기 제거
			button.setContentAreaFilled(false);
			// 포커스 되었을시 테두리 제거
			button.setFocusPainted(false);
		}
		// 세로로 출력하는 JLabel 함수 
		public String transformStringToHtml(String strToTransform) {
			String ans = "<html>";
			String br = "<br>";
			String[] lettersArr = strToTransform.split("");
			for (String letter : lettersArr) {
				ans += letter + br;
			}
			ans += "</html>";
			return ans;
		}
	}

	// 제목 화면에서 넘어가면 출력할 Second Panel
	class SecondPanel extends JPanel {
		// 버튼 생성
		JButton rightButton = new JButton("rightButton");
		JButton leftButton = new JButton("leftButton");
		JButton backgroundButton = new JButton("backgroundButton");
		JButton layoutButton = new JButton("layoutButton");

		// 앞으로, 뒤로 Label
		JLabel previousLabel = new JLabel("앞으로");
		JLabel nextLabel = new JLabel("뒤로");

		SecondPanel() {
			// 버튼의 위치가 일정하지 않으므로 일일이 지정
			setLayout(null);
			// 크기, 위치 설정
			leftButton.setBounds(15, 170, 40, 75);
			// 클릭 시 마우스 이벤트 처리
			leftButton.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					card.previous(SecondPanel.this.getParent());
				}
			});

			previousLabel.setBounds(15, 240, 180, 50);

			// 크기, 위치 설정
			rightButton.setBounds(540, 170, 40, 75);
			// 클릭 시 마우스 이벤트 처리
			rightButton.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					card.next(SecondPanel.this.getParent());
				}
			});

			nextLabel.setBounds(550, 240, 180, 50);

			// 버튼 및 라벨 크기 및 위치 설정
			backgroundButton.setBounds(600, 150, 75, 30);
			layoutButton.setBounds(600, 100, 75, 30);

			// 판넬에 버튼 추가
			add(leftButton);
			add(previousLabel);
			add(rightButton);
			add(nextLabel);
			add(layoutButton);
			add(backgroundButton);
		}

		// ButtonUI 설정 메소드 
		public void setButtonUI(JButton button) {
			// 외곽선 제거
			button.setBorderPainted(false);
			// 내용 체우기 제거
			button.setContentAreaFilled(false);
			// 포커스 되었을시 테두리 제거
			button.setFocusPainted(false);
		}
	}

	class ThirdPanel extends JPanel {
		// 버튼 생성
		JButton rightButton = new JButton("rightButton");
		JButton leftButton = new JButton("leftButton");
		JButton backgroundButton = new JButton("backgroundButton");
		JButton layoutButton = new JButton("layoutButton");
		JButton confirmButton = new JButton("confirmButton");

		// 앞으로, 뒤로 Label
		JLabel previousLabel = new JLabel("앞으로");
		JLabel nextLabel = new JLabel("뒤로");

		ThirdPanel() {
			// 버튼의 위치가 일정하지 않으므로 일일이 지정
			setLayout(null);
			// 크기, 위치 설정
			leftButton.setBounds(15, 170, 40, 75);
			// 클릭 시 마우스 이벤트 처리
			leftButton.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					card.previous(ThirdPanel.this.getParent());
				}
			});

			previousLabel.setBounds(15, 240, 180, 50);

			// 크기, 위치 설정
			rightButton.setBounds(540, 170, 40, 75);
			// 클릭 시 마우스 이벤트 처리
			rightButton.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					card.next(ThirdPanel.this.getParent());
				}
			});

			nextLabel.setBounds(550, 240, 180, 50);

			// 버튼 및 라벨 크기 및 위치 설정
			backgroundButton.setBounds(600, 150, 75, 30);
			layoutButton.setBounds(600, 100, 75, 30);
			confirmButton.setBounds(550, 450, 75, 30);
			
			// 이미지 파일 생성
			confirmButton.addMouseListener(new MouseAdapter() {
			
				public void mousePressed(MouseEvent e) {
					int width = 250;
					int height = 250;
					  BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
							// Save as JPEG
							try {
								File file = new File("myimage.jpg");
								ImageIO.write(bufferedImage, "jpg", file);
							}catch(IOException E) {}
				}
			});


			// 판넬에 버튼 추가
			add(leftButton);
			add(previousLabel);
			add(rightButton);
			add(nextLabel);
			add(layoutButton);
			add(backgroundButton);
			add(confirmButton);
		}
	}
}
