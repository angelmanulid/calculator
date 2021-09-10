package calculator_v2_03;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class SimpleCalc_Main {
	
	public static void main(String[] args) {
		
		
		
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
			System.err.print(e);
		}
		
		
		try {
		//GUI
		new SimpleCalc_GUI();
		} catch (Exception ex) {
			System.err.print(ex);
		}
	}

}
