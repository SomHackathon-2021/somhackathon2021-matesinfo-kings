package com.MatesInfoKings.localpoint;

public class BescanviarData {

    private String BescanviarName;
    private String BescanviarSubname;
    private String BescanviarPreu;
    private Integer BescanviarImage;

    public BescanviarData(String bescanviarName, String bescanviarSubname, Integer bescanviarImage, String bescanviarPreu) {
        BescanviarName = bescanviarName;
        BescanviarSubname = bescanviarSubname;
        BescanviarImage = bescanviarImage;
        BescanviarPreu = bescanviarPreu;
    }

    public String getBescanviarName() {
        return BescanviarName;
    }

    public void setBescanviarName(String bescanviarName) {
        BescanviarName = bescanviarName;
    }

    public String getBescanviarSubname() {
        return BescanviarSubname;
    }

    public void setBescanviarSubname(String bescanviarSubname) {
        BescanviarSubname = bescanviarSubname;
    }

    public Integer getBescanviarImage() {
        return BescanviarImage;
    }

    public void setBescanviarImage(Integer bescanviarImage) {
        BescanviarImage = bescanviarImage;
    }

    public String getBescanviarPreu() {
        return BescanviarPreu;
    }

    public void setBescanviarPreu(String bescanviarPreu) {
        BescanviarPreu = bescanviarPreu;
    }
}
