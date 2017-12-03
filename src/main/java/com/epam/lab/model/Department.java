package com.epam.lab.model;

public class Department {
 private Integer idDept;
 private String  DeptName;
 private String InstituteName;

    public Integer getIdDept() {
        return idDept;
    }

    public void setIdDept(Integer idDept) {
        this.idDept = idDept;
    }

    public String getDeptName() {
        return DeptName;
    }

    public void setDeptName(String deptName) {
        DeptName = deptName;
    }

    public String getInstituteName() {
        return InstituteName;
    }

    public void setInstituteName(String instituteName) {
        InstituteName = instituteName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (idDept != null ? !idDept.equals(that.idDept) : that.idDept != null) return false;
        if (DeptName != null ? !DeptName.equals(that.DeptName) : that.DeptName != null) return false;
        return InstituteName != null ? InstituteName.equals(that.InstituteName) : that.InstituteName == null;
    }

    @Override
    public int hashCode() {
        int result = idDept != null ? idDept.hashCode() : 0;
        result = 31 * result + (DeptName != null ? DeptName.hashCode() : 0);
        result = 31 * result + (InstituteName != null ? InstituteName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Department{" +
                "idDept=" + idDept +
                ", DeptName='" + DeptName + '\'' +
                ", InstituteName='" + InstituteName + '\'' +
                '}';
    }
}
