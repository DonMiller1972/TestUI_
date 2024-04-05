package pages;

public class JobTittleParameterObj {
    private String title;
    private String description;
    private String note;
    private String fileName;
    private String xput;

    public String getTitle() {
        return title;
    }

    public JobTittleParameterObj setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public JobTittleParameterObj setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getNote() {
        return note;

    }

    public JobTittleParameterObj setNote(String note) {
        this.note = note;
        return this;
    }

    public String getFileName() {
        return fileName;
    }

    public JobTittleParameterObj setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public String getXput() {
        return xput;
    }

    public JobTittleParameterObj setXput(String xput) {
        this.xput = xput;
        return this;
    }
}
