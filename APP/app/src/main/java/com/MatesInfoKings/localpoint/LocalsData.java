package com.MatesInfoKings.localpoint;

public class LocalsData {

    private String LocalsName;
    private String LocalsSubname;
    private String LocalsOpcions;
    private Integer LocalsImage;

    public LocalsData(String localsName, String localsSubname, Integer localsImage, String opcions) {
        LocalsName = localsName;
        LocalsSubname = localsSubname;
        LocalsImage = localsImage;
        LocalsOpcions = opcions;
    }

    public String getBescanviarName() {
        return LocalsName;
    }

    public void setBescanviarName(String bescanviarName) {
        LocalsName = bescanviarName;
    }

    public String getBescanviarSubname() {
        return LocalsSubname;
    }

    public void setBescanviarSubname(String bescanviarSubname) {
        LocalsSubname = bescanviarSubname;
    }

    public Integer getBescanviarImage() {
        return LocalsImage;
    }

    public void setBescanviarImage(Integer bescanviarImage) {
        LocalsImage = bescanviarImage;
    }

    public String getOpcions() {
        return LocalsOpcions;
    }

    public void setOpcions(String opcions) {
        LocalsOpcions = opcions;
    }
}
