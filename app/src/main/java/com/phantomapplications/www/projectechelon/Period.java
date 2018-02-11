package com.phantomapplications.www.projectechelon;
class Period {

    private String periodNum;

    private String courseName;
    private String cycle1;
    private String cycle2;
    private String cycle3;
    private String cycle4;

    private String exam1;
    private String exam2;

    private String sem1;
    private String sem2;

    private String teacher;

    public String getperiod() {
        return periodNum;
    }

    public void setperiod(String periodNum) {
        this.periodNum = periodNum;
    }

    public String getclassName() {
        return courseName;
    }

    public void setclassName(String courseName) {
        this.courseName = courseName;
    }

    public String getcycle1() {
        return cycle1;
    }

    public void setcycle1(String cycle1) {
        this.cycle1 = (cycle1);
    }

    public String getcycle2() {
        return cycle2;
    }

    public void setcycle2(String cycle2) {
        this.cycle2 = (cycle2);
    }

    public String getcycle3() {
        return cycle3;
    }

    public void setcycle3(String cycle3) {
        this.cycle3 = cycle3;
    }

    public String getcycle4() {
        return cycle4;
    }

    public void setcycle4(String cycle4) {
        this.cycle4 = cycle4;
    }

    public String getexam1() {
        return exam1;
    }

    public void setexam1(String exam1) {
        this.exam1 = exam1;
    }

    public String getexam2() {
        return exam2;
    }

    public void setexam2(String exam2) {
        this.exam2 = (exam2);
    }

    public String getsem1() {
        return sem1;
    }

    public void setsem1(String sem1) {
        this.sem1 = (sem1);
    }

    public String getsem2() {
        return sem2;
    }

    public void setsem2(String sem2) {
        this.sem2 = (sem2);
    }

    public String getteacher() {
        return teacher;
    }

    public void setteacher(String teacher) {
        this.teacher = teacher;
    }
}