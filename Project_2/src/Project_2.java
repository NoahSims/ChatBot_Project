import javax.swing.JFrame;

public class Project_2 {
	public static void main(String[] args)
	{
		ProgrammerCalc window = new ProgrammerCalc();
		window.setTitle("calculator");
		window.setSize(350, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
}
