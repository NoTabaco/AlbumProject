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

	// ���� ��ư �⺻ �̹���
	ImageIcon leftButtonBasicImage = new ImageIcon("images/leftButtonBasicImage.png");
	// ���� ��ư Enter �̹���
	ImageIcon leftButtonEnterImage = new ImageIcon("images/leftButtonEnterImage.png");
	// ������ ��ư �⺻ �̹���
	ImageIcon rightButtonBasicImage = new ImageIcon("images/rightButtonBasicImage.png");
	// ������ ��ư Enter �̹���
	ImageIcon rightButtonEnterImage = new ImageIcon("images/rightButtonEnterImage.png");

	// CardLayout�� ���� ������ Panel
	JPanel firstPanel;
	JPanel secondPanel;
	JPanel thirdPanel;
	// CardLayout ��ü ����
	CardLayout card = new CardLayout();

	public AlbumPanel() {
		// BorderLayout ���� 
		setLayout(new BorderLayout());
		// cardLayout ���̾ƿ��� ���� ��ü ����
		JPanel cardPanel = new cardPanel();
		// cardPanel�� �߰�, BorderLayout CENTER
		add(cardPanel, BorderLayout.CENTER);
	}

	// cardLayout�� ���� cardPanel Ŭ����  
	class cardPanel extends JPanel {

		cardPanel(){
			// CardLayout ����
			setLayout(card);

			// ������ Panel ��ü ����
			firstPanel = new FirstPanel();
			secondPanel = new SecondPanel();
			thirdPanel = new ThirdPanel();

			// CardLayout�� Panel �߰�
			add(firstPanel, "first");
			add(secondPanel, "second");
			add(thirdPanel, "third");
		}

	}


	// ù ��° ȭ��
	class FirstPanel extends JPanel {
		// ������ ��ư �⺻ �̹���
		ImageIcon rightButtonBasicImage = new ImageIcon("images/rightButtonBasicImage.png");
		// ������ ��ư Enter �̹���
		ImageIcon rightButtonEnterImage = new ImageIcon("images/rightButtonEnterImage.png");
		// ȭ�� ��� �� Button��
		JButton rightButton = new JButton(rightButtonBasicImage);
		JButton leftButton = new JButton("leftButton");
		JButton titleButton = new JButton("���� ����");
		JButton subtitleButton = new JButton("������ ����");
		JButton inputModifyButton = new JButton("�Է� ����");
		JButton backgroundButton = new JButton("��� ����");
		// ����, ������ ������ ����� JLabel ��
		JLabel titleLabel = new JLabel("The Memory 2014(�츮���� 2014�� �̾߱�)");
		JLabel subtitleLabel = new JLabel("�ູ�ߴ� �ð���!");
		// test �̹���
		ImageIcon testImage = new ImageIcon("images/book.png");
		// Label�� book �̹��� ���
		JLabel book = new JLabel(testImage);
		// ������, �ڷ� Label
		JLabel previousLabel = new JLabel("������");
		JLabel nextLabel = new JLabel("�ڷ�");

		FirstPanel() {
			// Button�� ��ġ�� �������� �����Ƿ� layout�� null�� ����
			setLayout(null);
			// setBounds�� ���� Button�� x, y ��ǥ �� Size ����
			rightButton.setBounds(540, 170, 40, 75);
			// rightButton Ŭ�� �� ���� Panel�� ��µǵ��� ����
			rightButton.addMouseListener(new MouseAdapter() {
				// ��ư �Է� �� cardLayout�� �Է� �� ���� �ǳڷ� �Ѿ���� ��
				public void mousePressed(MouseEvent e) {
					card.next(FirstPanel.this.getParent());
				}

			});
			// leftButton ��ġ, ��� ����
			leftButton.setBounds(15, 170, 40, 75);

			// ���η� ����� JLabel
			JLabel upDownLabel = new JLabel(transformStringToHtml("The Memory 2014"));
			// Label �߾� ����
			upDownLabel.setHorizontalAlignment(JLabel.CENTER);
			// Label ��ġ, ��� ����
			upDownLabel.setBounds(225, -150, 100, 500);

			// ���� Label, ������ Label ��ġ ��� ���� 
			titleLabel.setBounds(350, 80, 180, 50);
			subtitleLabel.setBounds(350, 100, 180, 50);
			// Label RIGHT ����
			titleLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			subtitleLabel.setHorizontalAlignment(SwingConstants.RIGHT);

			// ������, �ڷ� Label ��ġ ��� ���� 
			previousLabel.setBounds(15, 240, 180, 50);
			nextLabel.setBounds(550, 240, 180, 50);

			// ��ư���� ��ġ, ��� ����
			titleButton.setBounds(350, 60, 75, 30);
			subtitleButton.setBounds(350, 140, 75, 30);
			inputModifyButton.setBounds(450, 140, 75, 30);
			backgroundButton.setBounds(600, 150, 75, 30);
			// ButtonUI ����
			// setButtonUI(rightButton);
			// Btn �߰�
			leftButton.setEnabled(false);
			add(titleButton);
			add(subtitleButton);
			add(rightButton);
			add(leftButton);
			add(inputModifyButton);
			add(backgroundButton);
			// Label �߰�
			add(previousLabel);
			add(nextLabel);
			add(titleLabel);
			add(subtitleLabel);
			add(upDownLabel);

		}
		// ButtonUI ���� �޼ҵ� 
		public void setButtonUI(JButton button) {
			// �ܰ��� ����
			button.setBorderPainted(false);
			// ���� ü��� ����
			button.setContentAreaFilled(false);
			// ��Ŀ�� �Ǿ����� �׵θ� ����
			button.setFocusPainted(false);
		}
		// ���η� ����ϴ� JLabel �Լ� 
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

	// ���� ȭ�鿡�� �Ѿ�� ����� Second Panel
	class SecondPanel extends JPanel {
		// ��ư ����
		JButton rightButton = new JButton("rightButton");
		JButton leftButton = new JButton("leftButton");
		JButton backgroundButton = new JButton("backgroundButton");
		JButton layoutButton = new JButton("layoutButton");

		// ������, �ڷ� Label
		JLabel previousLabel = new JLabel("������");
		JLabel nextLabel = new JLabel("�ڷ�");

		SecondPanel() {
			// ��ư�� ��ġ�� �������� �����Ƿ� ������ ����
			setLayout(null);
			// ũ��, ��ġ ����
			leftButton.setBounds(15, 170, 40, 75);
			// Ŭ�� �� ���콺 �̺�Ʈ ó��
			leftButton.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					card.previous(SecondPanel.this.getParent());
				}
			});

			previousLabel.setBounds(15, 240, 180, 50);

			// ũ��, ��ġ ����
			rightButton.setBounds(540, 170, 40, 75);
			// Ŭ�� �� ���콺 �̺�Ʈ ó��
			rightButton.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					card.next(SecondPanel.this.getParent());
				}
			});

			nextLabel.setBounds(550, 240, 180, 50);

			// ��ư �� �� ũ�� �� ��ġ ����
			backgroundButton.setBounds(600, 150, 75, 30);
			layoutButton.setBounds(600, 100, 75, 30);

			// �ǳڿ� ��ư �߰�
			add(leftButton);
			add(previousLabel);
			add(rightButton);
			add(nextLabel);
			add(layoutButton);
			add(backgroundButton);
		}

		// ButtonUI ���� �޼ҵ� 
		public void setButtonUI(JButton button) {
			// �ܰ��� ����
			button.setBorderPainted(false);
			// ���� ü��� ����
			button.setContentAreaFilled(false);
			// ��Ŀ�� �Ǿ����� �׵θ� ����
			button.setFocusPainted(false);
		}
	}

	class ThirdPanel extends JPanel {
		// ��ư ����
		JButton rightButton = new JButton("rightButton");
		JButton leftButton = new JButton("leftButton");
		JButton backgroundButton = new JButton("backgroundButton");
		JButton layoutButton = new JButton("layoutButton");
		JButton confirmButton = new JButton("confirmButton");

		// ������, �ڷ� Label
		JLabel previousLabel = new JLabel("������");
		JLabel nextLabel = new JLabel("�ڷ�");

		ThirdPanel() {
			// ��ư�� ��ġ�� �������� �����Ƿ� ������ ����
			setLayout(null);
			// ũ��, ��ġ ����
			leftButton.setBounds(15, 170, 40, 75);
			// Ŭ�� �� ���콺 �̺�Ʈ ó��
			leftButton.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					card.previous(ThirdPanel.this.getParent());
				}
			});

			previousLabel.setBounds(15, 240, 180, 50);

			// ũ��, ��ġ ����
			rightButton.setBounds(540, 170, 40, 75);
			// Ŭ�� �� ���콺 �̺�Ʈ ó��
			rightButton.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					card.next(ThirdPanel.this.getParent());
				}
			});

			nextLabel.setBounds(550, 240, 180, 50);

			// ��ư �� �� ũ�� �� ��ġ ����
			backgroundButton.setBounds(600, 150, 75, 30);
			layoutButton.setBounds(600, 100, 75, 30);
			confirmButton.setBounds(550, 450, 75, 30);
			
			// �̹��� ���� ����
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


			// �ǳڿ� ��ư �߰�
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
