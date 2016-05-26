package com.qa.ims.view;

import com.alee.laf.WebLookAndFeel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.annotation.PostConstruct;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.springframework.stereotype.Component;

import com.alee.laf.label.WebLabel;
import com.alee.laf.panel.WebPanel;
import com.alee.laf.rootpane.WebFrame;
import com.qa.ims.view.impl.LoginView;

@Component
public class TemplateView extends WebFrame {

	private static final long serialVersionUID = 8843033345602636426L;

	private final CardLayout cardLayout;
	private final View[] loadedViews;

	private WebPanel mainPanel;

	public TemplateView() {
		cardLayout = new CardLayout();
		loadedViews = new View[8];
	}

	@PostConstruct
	public void init() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				WebLookAndFeel.install();
				JFrame.setDefaultLookAndFeelDecorated(true);
				JDialog.setDefaultLookAndFeelDecorated(true);
				render();
			}

		});
	}

	public void render() {
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				int choice = JOptionPane.showConfirmDialog(TemplateView.this, "Are you sure you want to exit?",
						"Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

				if (choice == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}

			@Override
			public void windowOpened(WindowEvent e) {
				switchView("login");
			}

		});

		setLayout(new BorderLayout());

		mainPanel = new WebPanel();
		mainPanel.setLayout(cardLayout);
		add(mainPanel, BorderLayout.CENTER);

		WebLabel buildNumberLabel = new WebLabel("Build #19052016");
		buildNumberLabel.setBorder(BorderFactory.createEmptyBorder(0, 5, 2, 0));
		add(buildNumberLabel, BorderLayout.SOUTH);

		addView(new LoginView());

		changeTitle("Login");
		setSize(800, 600);
		setMinimumSize(getSize());
		setLocationRelativeTo(null);
		setVisible(true);
		toFront();
	}

	public void addView(View view) {
		for (int i = 0; i < loadedViews.length; i++) {
			if (loadedViews[i] == null) {
				loadedViews[i] = view;
				mainPanel.add(view, view.getIdentifier());
				break;
			}
		}
	}

	public void switchView(String identifier) {
		for (View loadedView : loadedViews) {
			if (loadedView == null) {
				continue;
			}

			if (loadedView.getIdentifier().equals(identifier)) {
				if (!loadedView.hasInitialized()) {
					loadedView.initialize();
				}

				loadedView.preSwitch();
				cardLayout.show(mainPanel, identifier);
				loadedView.postSwitch();
				break;
			}
		}
	}

	private void changeTitle(String suffix) {
		setTitle("Ims | " + suffix);
	}

}
