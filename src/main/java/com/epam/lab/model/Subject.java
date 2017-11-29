package com.epam.lab.model;

public class Subject {
    private Integer idSubject;
    private String subjectName;
    private String subjectDescribe;

    public Integer getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(Integer idSubject) {
        this.idSubject = idSubject;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectDescribe() {
        return subjectDescribe;
    }

    public void setSubjectDescribe(String subjectDescribe) {
        this.subjectDescribe = subjectDescribe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subject subject = (Subject) o;

        if (idSubject != null ? !idSubject.equals(subject.idSubject) : subject.idSubject != null) return false;
        if (subjectName != null ? !subjectName.equals(subject.subjectName) : subject.subjectName != null) return false;
        return subjectDescribe != null ? subjectDescribe.equals(subject.subjectDescribe) : subject.subjectDescribe == null;
    }

    @Override
    public int hashCode() {
        int result = idSubject != null ? idSubject.hashCode() : 0;
        result = 31 * result + (subjectName != null ? subjectName.hashCode() : 0);
        result = 31 * result + (subjectDescribe != null ? subjectDescribe.hashCode() : 0);
        return result;
    }
}
