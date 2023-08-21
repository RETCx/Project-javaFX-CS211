package cs211.project.services;

import cs211.project.models.UserList;

public interface Datasource<T> {
    T readData();
    void writeData(T data);

    //T loadData();


}