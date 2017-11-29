package com.epam.lab.model;

public class Parents {
    private Integer idParents;
  private String fatherName;
    private String fatherSurname;
    private String motherName;
    private String motherSurname;

    public Integer getIdParents() {
        return idParents;
    }

    public void setIdParents(Integer idParents) {
        this.idParents = idParents;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getFatherSurname() {
        return fatherSurname;
    }

    public void setFatherSurname(String fatherSurname) {
        this.fatherSurname = fatherSurname;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getMotherSurname() {
        return motherSurname;
    }

    public void setMotherSurname(String motherSurname) {
        this.motherSurname = motherSurname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Parents parents = (Parents) o;

        if (idParents != null ? !idParents.equals(parents.idParents) : parents.idParents != null) return false;
        if (fatherName != null ? !fatherName.equals(parents.fatherName) : parents.fatherName != null) return false;
        if (fatherSurname != null ? !fatherSurname.equals(parents.fatherSurname) : parents.fatherSurname != null)
            return false;
        if (motherName != null ? !motherName.equals(parents.motherName) : parents.motherName != null) return false;
        return motherSurname != null ? motherSurname.equals(parents.motherSurname) : parents.motherSurname == null;
    }

    @Override
    public int hashCode() {
        int result = idParents != null ? idParents.hashCode() : 0;
        result = 31 * result + (fatherName != null ? fatherName.hashCode() : 0);
        result = 31 * result + (fatherSurname != null ? fatherSurname.hashCode() : 0);
        result = 31 * result + (motherName != null ? motherName.hashCode() : 0);
        result = 31 * result + (motherSurname != null ? motherSurname.hashCode() : 0);
        return result;
    }
}
