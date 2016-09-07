package ArduinoTest;

import javax.swing.JFrame;
import javax.swing.JSlider;

public class Main {

	public static void main(String[] args) {
		JFrame windows = new JFrame();
		JSlider slider = new JSlider();
		slider.setMaximum(1023);
		windows.add(slider);
		windows.pack();
		windows.setVisible(true);

	}

}
