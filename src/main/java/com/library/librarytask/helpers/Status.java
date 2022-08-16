package com.library.librarytask.helpers;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Status {

    private int id;
    private String status;

    public List<String> statusList(){
        List<String> statuses = new LinkedList<>();
        statuses.add("W obiegu");
        statuses.add("Zniszczona");
        statuses.add("Zagubiona");

        return statuses;
    }


}
