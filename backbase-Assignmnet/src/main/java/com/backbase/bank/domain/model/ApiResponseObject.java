package com.backbase.bank.domain.model;

import java.util.List;

/**
 * Created by kkalkur 
 */
public class ApiResponseObject<E> {

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }

    private List<E> list;
}
