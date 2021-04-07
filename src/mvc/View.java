package mvc;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class View extends JPanel implements PropertyChangeListener {
	
    protected Model model;
    
    public View(Object model) {
        this.model = (Model)model;
        this.model.addPropertyChangeListener(this);
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        repaint();
    }
    // discard this view  with the old model or reuse it?
    
	public void setModel(Model model) {
        this.model.removePropertyChangeListener(this);
        this.model = model;
        this.model.initSupport();
        this.model.addPropertyChangeListener(this);
        repaint();
	}
}
