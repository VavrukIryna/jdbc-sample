package com.epam.lab.model;
import java.sql.*;

public class Exam {
  private Integer idExam;
  private Date examDate;
    private Integer examMark;

    public Integer getIdExam() {
        return idExam;
    }

    public void setIdExam(Integer idExam) {
        this.idExam = idExam;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public Integer getExamMark() {
        return examMark;
    }

    public void setExamMark(Integer examMark) {
        this.examMark = examMark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Exam exam = (Exam) o;

        if (idExam != null ? !idExam.equals(exam.idExam) : exam.idExam != null) return false;
        if (examDate != null ? !examDate.equals(exam.examDate) : exam.examDate != null) return false;
        return examMark != null ? examMark.equals(exam.examMark) : exam.examMark == null;
    }

    @Override
    public int hashCode() {
        int result = idExam != null ? idExam.hashCode() : 0;
        result = 31 * result + (examDate != null ? examDate.hashCode() : 0);
        result = 31 * result + (examMark != null ? examMark.hashCode() : 0);
        return result;
    }
}
