package cacpter1_3;


import cacpter1_3.common.queue.ArrayQueue;

import java.io.File;

public class Homework1_3_43 {
    public static void main(String[]args){

    }

    public static void showFile(ArrayQueue<String>queue, File file){
        if(!file.exists()){
            return;
        }
        if(file.isFile()){
            return;
        }
    }

}
