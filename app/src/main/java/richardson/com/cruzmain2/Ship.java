package richardson.com.cruzmain2;

import android.graphics.drawable.Drawable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Cordy Work on 7/7/2015.
 */
/*
class representing ship objects
 */
public class Ship implements Serializable {
    //made serializable per a tutorial on how to pass the whole object
    //between fragments
    //http://virtualcompiler.blogspot.com/2014/06/share-object-between-fragments.html

        private CharSequence shipId;
        private String shipName;
        private int buildYear;
        private int capacity;
        private List<Integer> imageIDList = new ArrayList<>();
        private int[] checkBoxesToSet;


        public Ship(CharSequence id, String name, int built, int capacity, int...args){
            shipId = id;
            shipName = name;
            buildYear = built;
            this.capacity = capacity;
            setIDList(args);

        } //end constructor

        public CharSequence getShipId(){ return shipId;}

        public String getShipName(){return shipName;}

        public int getBuildYear(){return buildYear;}

        public int getCapacity(){ return capacity;}

        public void setIDList(int...args){
            for (int id: args){
                imageIDList.add(id);
            }
        }

        public int getimageID(int pos){
            return imageIDList.get(pos);
        }

        public int getImageListSize(){
            return imageIDList.size();
        }

        public int[] getCheckBoxesToSet(){ return checkBoxesToSet;};

        public void setCheckBoxArray(int[] checkBoxArray){
            checkBoxesToSet = checkBoxArray;
        }


        @Override
        public String toString(){
            return "Carnival " + getShipName();
        }
}


