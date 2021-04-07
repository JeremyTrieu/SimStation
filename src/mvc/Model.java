package mvc;

public class Model extends Bean {
    boolean unsavedChanges = false;
    String fileName        = null;
    public void changed() {
        unsavedChanges = true;
        firePropertyChange(null, null, null);
        // inheringin classes shall add more
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fname) {
        fileName = fname;
    }

    public void setUnsavedChanges(boolean unsavedChanges) {
        this.unsavedChanges = unsavedChanges;
    }

    public boolean getUnsavedChanges() {
        return unsavedChanges;
    }

}
