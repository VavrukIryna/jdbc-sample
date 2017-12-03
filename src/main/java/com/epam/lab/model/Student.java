package com.epam.lab.model;

import java.sql.Date;

public class Student {
    private Integer idStudent;
    private String name;
    private String surname;
    private Integer bookNumber;
    private Integer telephone;
    private String sex;
    private Date birthdayData;
    private Address address;
    private Integer subjectId;
    private Integer specialtyId;
    private Integer parentsId;
    private Integer examId;
    private String group;
    private String learningForm;
    private Department department;

    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(Integer bookNumber) {
        this.bookNumber = bookNumber;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthdayData() {
        return birthdayData;
    }

    public void setBirthdayData(Date birthdayData) {
        this.birthdayData = birthdayData;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getLearningForm() {
        return learningForm;
    }

    public void setLearningForm(String learningForm) {
        this.learningForm = learningForm;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(Integer specialtyId) {
        this.specialtyId = specialtyId;
    }

    public Integer getParentsId() {
        return parentsId;
    }

    public void setParentsId(Integer parentsId) {
        this.parentsId = parentsId;
    }

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (idStudent != null ? !idStudent.equals(student.idStudent) : student.idStudent != null) return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        if (surname != null ? !surname.equals(student.surname) : student.surname != null) return false;
        if (bookNumber != null ? !bookNumber.equals(student.bookNumber) : student.bookNumber != null) return false;
        if (telephone != null ? !telephone.equals(student.telephone) : student.telephone != null) return false;
        if (sex != null ? !sex.equals(student.sex) : student.sex != null) return false;
        if (birthdayData != null ? !birthdayData.equals(student.birthdayData) : student.birthdayData != null)
            return false;
        if (address != null ? !address.equals(student.address) : student.address != null) return false;
        if (subjectId != null ? !subjectId.equals(student.subjectId) : student.subjectId != null) return false;
        if (specialtyId != null ? !specialtyId.equals(student.specialtyId) : student.specialtyId != null) return false;
        if (parentsId != null ? !parentsId.equals(student.parentsId) : student.parentsId != null) return false;
        if (examId != null ? !examId.equals(student.examId) : student.examId != null) return false;
        if (group != null ? !group.equals(student.group) : student.group != null) return false;
        if (learningForm != null ? !learningForm.equals(student.learningForm) : student.learningForm != null)
            return false;
        return department != null ? department.equals(student.department) : student.department == null;
    }

    @Override
    public int hashCode() {
        int result = idStudent != null ? idStudent.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (bookNumber != null ? bookNumber.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (birthdayData != null ? birthdayData.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (subjectId != null ? subjectId.hashCode() : 0);
        result = 31 * result + (specialtyId != null ? specialtyId.hashCode() : 0);
        result = 31 * result + (parentsId != null ? parentsId.hashCode() : 0);
        result = 31 * result + (examId != null ? examId.hashCode() : 0);
        result = 31 * result + (group != null ? group.hashCode() : 0);
        result = 31 * result + (learningForm != null ? learningForm.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "idStudent=" + idStudent +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", bookNumber=" + bookNumber +
                ", telephone=" + telephone +
                ", sex='" + sex + '\'' +
                ", birthdayData=" + birthdayData +
                ", address=" + address +
                ", subjectId=" + subjectId +
                ", specialtyId=" + specialtyId +
                ", parentsId=" + parentsId +
                ", examId=" + examId +
                ", group='" + group + '\'' +
                ", learningForm='" + learningForm + '\'' +
                ", department=" + department +
                '}';
    }
}
