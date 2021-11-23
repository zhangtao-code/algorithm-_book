package cacpter1_3;


import cacpter1_3.common.queue.ArrayQueue;

import java.io.File;
import java.util.Iterator;

public class Homework1_3_43 {
    public static void main(String[]args){
        ArrayQueue<String>tab=new ArrayQueue<>(30,2);
        showFile(tab,new File("E:\\github\\algorithm_book\\src"));
    }

    public static void showFile(ArrayQueue<String>queue, File file){
        if(!file.exists()){
            return;
        }
        Iterator<String> iterable= queue.iterator();
        while (iterable.hasNext()){
            System.out.print(iterable.next());
        }
        System.out.println(file.getName());
        if(file.isDirectory()){
            ArrayQueue clone=new ArrayQueue(queue);
            clone.enqueue("\t");
            for (File listFile : file.listFiles()) {
                showFile(clone,listFile);
            }
        }
    }

}
