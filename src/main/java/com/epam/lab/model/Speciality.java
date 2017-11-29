package com.epam.lab.model;

public class Speciality {
 private Integer idSpeciality;
 private String specialtyName;
 private String specialtyDescribe;

    public Integer getIdSpeciality() {
        return idSpeciality;
    }

    public void setIdSpeciality(Integer idSpeciality) {
        this.idSpeciality = idSpeciality;
    }

    public String getSpecialtyName() {
        return specialtyName;
    }

    public void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName;
    }

    public String getSpecialtyDescribe() {
        return specialtyDescribe;
    }

    public void setSpecialtyDescribe(String specialtyDescribe) {
        this.specialtyDescribe = specialtyDescribe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Speciality that = (Speciality) o;

        if (idSpeciality != null ? !idSpeciality.equals(that.idSpeciality) : that.idSpeciality != null) return false;
        if (specialtyName != null ? !specialtyName.equals(that.specialtyName) : that.specialtyName != null)
            return false;
        return specialtyDescribe != null ? specialtyDescribe.equals(that.specialtyDescribe) : that.specialtyDescribe == null;
    }

    @Override
    public int hashCode() {
        int result = idSpeciality != null ? idSpeciality.hashCode() : 0;
        result = 31 * result + (specialtyName != null ? specialtyName.hashCode() : 0);
        result = 31 * result + (specialtyDescribe != null ? specialtyDescribe.hashCode() : 0);
        return result;
    }
}
