package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import controllers.HomeController;
import core.Model;
import core.View;


/**
 * View associated with HomeController. Main screen with all tabs.
 */
@SuppressWarnings("serial")
public class HomeView extends JPanel implements View
{
	@SuppressWarnings("unused")
	private HomeController homeController;
	private JFrame mainFrame;
	private final static int MAIN_FRAME_WIDTH  = 600;
	private final static int MAIN_FRAME_HEIGHT = 400;
	private final static int MAIN_FRAME_X = 100;
	private final static int MAIN_FRAME_Y = 100;

	public HomeView(HomeController homeController, JFrame mainFrame)
	{
		this.homeController = homeController;
		this.mainFrame = mainFrame;

		make_mainFrame();
		make_tabs();
	}

	@Override
	public void update(Model model, Object data) {}

	private void make_mainFrame()
	{
		mainFrame.setOpacity(1.0f);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setBounds(MAIN_FRAME_X, MAIN_FRAME_Y, MAIN_FRAME_WIDTH, MAIN_FRAME_HEIGHT);
		mainFrame.setMinimumSize(new Dimension(MAIN_FRAME_WIDTH, MAIN_FRAME_HEIGHT));

		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout(0, 0));
	}

	private void make_tabs()
	{
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		// Tab 1: Crear evento (ya existía)
		tabbedPane.addTab("New event", homeController.getNewEventView());

		// Tab 2: Listar eventos (ya existía)
		tabbedPane.addTab("Events", homeController.getEventListView());

		// Tab 3: Eliminar evento (NUEVO)
		tabbedPane.addTab("Remove Event",
				new RemoveEventView(homeController.getEventListController()));

		// Tab 4: Registrar invitado (NUEVO)
		tabbedPane.addTab("Registrar invitado", new RegistrarInvitadoView());

		add(tabbedPane, BorderLayout.CENTER);
	}
}