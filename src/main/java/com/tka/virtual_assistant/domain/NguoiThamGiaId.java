package com.tka.virtual_assistant.domain;

import java.io.Serializable;

public class NguoiThamGiaId implements Serializable {
    private int ID_User;
    private int ID_Meeting;

    public int getID_User() {
        return ID_User;
    }

    public void setID_User(int ID_User) {
        this.ID_User = ID_User;
    }

    public int getID_Meeting() {
        return ID_Meeting;
    }

    public void setID_Meeting(int ID_Meeting) {
        this.ID_Meeting = ID_Meeting;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof NguoiThamGiaId))
            return false;
        NguoiThamGiaId that = (NguoiThamGiaId) o;
        return ID_User == that.ID_User && ID_Meeting == that.ID_Meeting;
    }

    @Override
    public int hashCode() {
        return 31 * ID_User + ID_Meeting;
    }
}
