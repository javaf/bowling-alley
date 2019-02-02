package iiit.swing;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;


public class JListPanel extends JPanel {
  public JList list;
  public Collection<String> values;
  
  public JListPanel(String text, Collection<String> values) {
    super();
    super.setLayout(new FlowLayout());
    super.setBorder(new TitledBorder(text));
    list = new JList();
    setValues(values);
  }
  
  public void setValues(Collection<String> values) {
    list.setListData(values.isEmpty()? new String[]{"(Empty)"}:values.toArray());
    this.values = values;
  }
}
