package com.example.recyclerviewth3;

import android.app.Application;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyApplication extends Application {
    private static List<President> presidentList = new ArrayList<President>();
    private static int nextID = 10;

    public MyApplication() {
        Log.d("MyApplication", "onCreate called");
        fillPeresidentList();
    }

    private void fillPeresidentList() {
        President p0 = new President(0,"George Washington ",1792,"https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Gilbert_Stuart_Williamstown_Portrait_of_George_Washington.jpg/225px-Gilbert_Stuart_Williamstown_Portrait_of_George_Washington.jpg");
        President p1 = new President(1,"John Adams ",1796,"https://upload.wikimedia.org/wikipedia/commons/thumb/0/07/John_Adams_A18236.jpg/225px-John_Adams_A18236.jpg");
        President p2 = new President(2,"Thomas Jefferson ",1804,"https://upload.wikimedia.org/wikipedia/commons/thumb/1/1e/Thomas_Jefferson_by_Rembrandt_Peale%2C_1800.jpg/225px-Thomas_Jefferson_by_Rembrandt_Peale%2C_1800.jpg");
        President p3 = new President(3,"James Madison ",1808,"https://upload.wikimedia.org/wikipedia/commons/thumb/1/1d/James_Madison.jpg/225px-James_Madison.jpg");
        President p4 = new President(4,"James Monroe ",1816,"https://upload.wikimedia.org/wikipedia/commons/thumb/d/d4/James_Monroe_White_House_portrait_1819.jpg/225px-James_Monroe_White_House_portrait_1819.jpg");
        President p5 = new President(5,"John Quincy Adams ",1824,"https://upload.wikimedia.org/wikipedia/commons/thumb/4/4f/John_Quincy_Adams_by_Charles_Osgood.jpg/225px-John_Quincy_Adams_by_Charles_Osgood.jpg");
        President p6= new President(6,"Andrew Jackson ",1828,"https://upload.wikimedia.org/wikipedia/commons/thumb/4/43/Andrew_jackson_head.jpg/225px-Andrew_jackson_head.jpg");
        President p7 = new President(7,"Martin Van Buren ",1836,"https://upload.wikimedia.org/wikipedia/commons/thumb/8/8b/Martin_Van_Buren_circa_1837_crop.jpg/225px-Martin_Van_Buren_circa_1837_crop.jpg");
        President p8 = new President(8,"William Henry Harrison ",1840,"https://upload.wikimedia.org/wikipedia/commons/thumb/3/34/William_Henry_Harrison_by_James_Reid_Lambdin%2C_1835_crop.jpg/225px-William_Henry_Harrison_by_James_Reid_Lambdin%2C_1835_crop.jpg");
        President p9 = new President(9,"John Tyler ", 1845,"https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/John_Tyler_crop.jpg/225px-John_Tyler_crop.jpg");

       presidentList.addAll(Arrays.asList(new President[]{p0, p1, p2, p3, p4, p5, p6, p7, p8, p9}));


    }

    public List<President> getPresidentList() {
        return presidentList;
    }

    public void setPresidentList(List<President> presidentList) {
        this.presidentList = presidentList;
    }

    public static int getNextID() {
        return nextID;
    }

    public static void setNextID(int nextID) {
        MyApplication.nextID = nextID;
    }
}
