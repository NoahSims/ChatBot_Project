import javax.swing.JFrame;

public class TestMyFirstGUI {
	public static void main(String [] args)
	{
		MyFirstCalc window = new MyFirstCalc();
		window.setTitle("Learning GUI");
		window.setSize(500, 300);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		//window.setResizable(false);
	}
}
