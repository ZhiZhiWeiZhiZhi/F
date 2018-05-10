package com.f.test;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by F on 2016/11/28 15:51.
 */
public class ThreadTest {
    public static void main(String[] args) {
        new Thread(new Runnable(){public void run(){

        }}).start();

        Thread1 mTh1 = new Thread1("A");
        Thread1 mTh2 = new Thread1("B");
        mTh1.start();
        mTh2.start();

        new Thread(new Thread2("C")).start();
        new Thread(new Thread2("D")).start();
    }
}

class Thread1 extends Thread{
    private String name;
    public Thread1(String name) {
        this.name=name;
    }
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + "运行  :  " + i);
            try {
                sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Thread2 implements Runnable{
    private String name;
    public Thread2(String name) {
        this.name=name;
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + "运行  :  " + i);
            try {
                Thread.sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//线程安全
class Sum {
    private Integer sum;
    Sum(Integer sum){
        this.sum=sum;
    }

    public Integer getSum(){
        return  this.sum;
    }
    public void setSum(Integer sum) {
        this.sum = sum+this.sum;
    }
}

//分解任务
class Thread3 implements Runnable{
    private List<Integer> integerList;
    private Sum sum ;
    private Date startDate;
    private Integer startIndex;
    private Integer endIndex;
    public Thread3(List<Integer> integerList,Sum sum,Date startDate,Integer startIndex,Integer endIndex) {
        this.integerList=integerList;
        this.sum=sum;
        this.startDate=startDate;
        this.startIndex=startIndex;
        this.endIndex=endIndex;
    }
    public void c(Integer i){
       Sum s= new Sum(i);
       s.setSum(i);
       try {
           Thread.sleep(100);
       } catch (Exception e){

       }
    }
    private boolean b = true;
    @Override
    public  void run() {
        for (Integer i : integerList) {
            c(i);
          //  sum.setSum(i);
        //    System.out.println(Thread.currentThread().getName()+"===="+i+"========="+sum.getSum());
       }
        System.out.println("startDate"+this.startDate);
        System.out.println("endDate"+new Date());
    }

    public static void main(String[] args) throws Exception{
        Integer max= 101;

        List<Object> objList = new LinkedList<Object>();
        List<Integer> integerList = new LinkedList<Integer>();
        for (Integer num=0;num<max;num++) {
            integerList.add(num);
            if(num%((max-1)/10)==0){
                objList.add(integerList);
                integerList= new LinkedList<Integer>();
            }
        }

        Sum sum =new Sum(0);
        Date date=new Date();
        int size = objList.size();
        for (int i = 0; i < size; i++) {
            LinkedList<Integer> linkedList = (LinkedList<Integer>)objList.get(i);
            new Thread(new Thread3(linkedList,sum,date,i,i+50000),"thread"+i).start();
        }

//        for (Integer num=0;num<max;num++) {
//            integerList.add(num);
//        }
//        Sum sum =new Sum(0);
//        Date date=new Date();
//
//        for (int i = 0; i <1; i++) {
//            new Thread(new Thread3(integerList,sum,date,i,i+50000),"thread"+i).start();
//        }
    }
}

//信号量
class MySemaphore extends Thread {
    private Semaphore position;
    private int id;

    public MySemaphore(int i, Semaphore s) {
        this.id = i;
        this.position = s;
    }

    public void run() {
        try {
            //有没有空厕所
            if (position.availablePermits() > 0) {
                System.out.println("顾客[" + this.id + "]进入厕所，有空位");
            }else {
                System.out.println("顾客[" + this.id + "]进入厕所，没空位，排队");
            }
            //获取到空厕所了
            position.acquire();
            System.out.println("顾客[" + this.id + "]获得坑位");
            //使用中...
            Thread.sleep((int) (Math.random() * 1000));
            System.out.println("顾客[" + this.id + "]使用完毕");
            //厕所使用完之后释放
            position.release();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        ExecutorService list = Executors.newCachedThreadPool();
        Semaphore position = new Semaphore(2);//只有两个厕所
        //有十个人
        for (int i = 0; i < 10; i++) {
            list.submit(new MySemaphore(i + 1, position));
        }
        list.shutdown();
        position.acquireUninterruptibly(2);
        System.out.println("使用完毕，需要清扫了");
        position.release(2);
    }

}