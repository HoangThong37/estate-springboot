package com.laptrinhjavaweb.dto.reponse;

import com.laptrinhjavaweb.dto.UserDTO;

public class StaffAssignmentReponse  extends UserDTO  {
    private String checkes = "";

    public String getCheckes() {
        return checkes;
    }
    public void setCheckes(String checkes) {
        this.checkes = checkes;
    }
}
