package com.sxy.sparsearray;

/**
 * 需求：稀疏数组的存取和提出
 * 五子棋模型
 *
 */
public class SparseArray {
    public static void main(String[] args) {
        //输出二维数组
        int chessArr1[][]=new int[11][11];
        chessArr1[1][2]=1;
        chessArr1[2][3]=2;
        for (int[] ints : chessArr1) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
            }
            System.out.println();
        }
        int sum=0;
        //将二维数组转成稀疏数组
        for (int[] ints : chessArr1) {
            for (int anInt : ints) {
                if (anInt!=0){
                    sum++;
                }
            }
        }
        //创建对应的稀疏数组
        int sparseArray[][]=new int[sum+1][3];
        sparseArray[0][0]=11;
        sparseArray[0][1]=11;
        sparseArray[0][2]=sum;
        //将数据遍历进稀疏数组
        int count=0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j]!=0){
                    count++;
                    sparseArray[count][0]=i;
                    sparseArray[count][1]=j;
                    sparseArray[count][2]=chessArr1[i][j];
                }
            }
        }
        //输出稀疏数组
        System.out.println("下列是转换后的稀疏数组：");
        for (int[] ints : sparseArray) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
            }
            System.out.println();
        }

        //将稀疏数组转换为二维数组
        System.out.println("恢复后的数组：");
        int chessArr2[][]=new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            chessArr2[sparseArray[i][0]][sparseArray[i][1]]=sparseArray[i][2];
        }
        for (int[] ints : chessArr2) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
            }
            System.out.println();
        }
    }
}
