package com.example.baseapp;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    private String nome;
    private String password;

    public User(String nome, String password) {
        this.nome = nome;
        this.password = password;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
