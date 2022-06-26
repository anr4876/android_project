package kr.ac.mokwon.suti_game;

import android.graphics.Color;
import android.graphics.Paint;

public class Missle {

    private int dy;
    public  int _x, _y;

    public Missle(int x, int y){
        this._x = x;
        this._y = y;

        dy = 13;
    }
    public boolean Move(){
        _y -= dy;
        if(_y <= 0)return true;
        else return false;

    }

}
