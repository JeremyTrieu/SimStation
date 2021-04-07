/**
 * 
 */
package mvc;

/**
 * Interface for handling file menu
 * @author Jake Kao 
 * @version 1
 */
public interface AppFactory {
    
    /**
     * 
     * @return Model
     */
    public Model makeModel();
    
    /**
     * 
     * @param model
     * @return View
     */
    public View makeView(Model model);
    
    /**
     * 
     * @return title
     */
    public String getTitle();
    
    /**
     * 
     * @return help
     */
    public String[] getHelp(); 
    
    /**
     * 
     * @return about
     */
    public String about(); 
    
    /**
     * 
     * @return edit commands 
     */
    public String[] getEditCommands(); 
    
    /**
     * 
     * @param model
     * @param name
     * @return command from model and String name
     */
    public Command makeEditCommand(Model model, String name); 

}
