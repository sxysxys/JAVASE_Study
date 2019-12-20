package com.sxy.recursion;

/**
 * 实现迷宫的路径。
 */
public class MiGong {
    public static void main(String[] args) {
        //先创建地图
        int[][] map=new int[8][7];
        for (int i = 0; i < 7; i++) {
            map[0][i]=1;
            map[7][i]=1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0]=1;
            map[i][6]=1;
        }
        map[3][1]=1;
        map[3][2]=1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("路径如图所示:");
        setWay(map,1,1);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println("");
        }
    }

    /**
     * 说明
     * 1.通过map表示地图，（i，j）表示起始点的坐标
     * 2.小球到了map（6，5）的位置，表示通路已经找到。
     * 3. 0 表示没有走过，1表示墙，2表示通路可以走，3表示此路不通
     * 4.在走迷宫的时候，需要确定一个策略，下->右->上->左，走不通再回溯。
     * @param map  地图
     * @param i
     * @param j
     * @return
     */
    public static boolean setWay(int[][] map,int i,int j){  //其中map是引用类型，每次递归都是在改变同一个地图。
        if (map[6][5]==2){  //此时通路已经找到
            return true;
        }
        if (map[i][j]==0){  //此路没走过
            map[i][j]=2;  //默认它就是要走下去的点
            if (setWay(map,i+1,j)){
                return true;
            }else if (setWay(map,i,j+1)){
                return true;
            }else if (setWay(map,i-1,j)){
                return true;
            }else if (setWay(map,i,j-1)){
                return true;
            }else {
                map[i][j]=3;
                return false;
            }
        }else {  //如果探的路不为0，直接返回false到上一级。
            return false;
        }
    }
}
