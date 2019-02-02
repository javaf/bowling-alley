import iiit.swing.*;
import iiit.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class EndGamePrompt extends EventEmitter implements ActionListener {

  private final JFrame frame;
  private final JButtonPanel yes, no;
  public String result;

  public EndGamePrompt(String partyName) {
    result = "";
    frame = new JFrame("Another Game for " + partyName + "?");
    frame.getContentPane().setLayout(new BorderLayout());
    ((JPanel) frame.getContentPane()).setOpaque(false);

    JPanel columns = new JPanel();
    columns.setLayout(new GridLayout(2, 1));

    String label = partyName+" has finished bowling.\n"+
      "Would they like to bowl another game?";
    JPanel buttons = new JPanel();
    buttons.setLayout(new GridLayout(1, 2));
    buttons.add(yes = new JButtonPanel("Yes", this));
    buttons.add(no = new JButtonPanel("No", this));

    columns.add(new JLabelPanel(label));
    columns.add(buttons);

    frame.getContentPane().add("Center", columns);
    frame.pack();
    JFrames.screenCenter(frame);
    frame.show();
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource().equals(yes.button)) {
      result = "yes";
    }
    if (e.getSource().equals(no.button)) {
      result = "no";
    }

  }

  public String getResult() {
    while (result.length()==0) {
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        System.err.println("Interrupted");
      }
    }
    return result;
  }

  public void destroy() {
    frame.hide();
  }
}
