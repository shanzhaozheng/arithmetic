package chapter01;

public class Checkerboard {

    int [][] sourceArray;

    {
        sourceArray = new int[11][11];
        sourceArray[1][3] = 1;
        sourceArray[2][4] = 2;
        sourceArray[1][4] = 1;
    }

    /**
     * 备份稀疏数组
     * @return
     */
    public int[][] backups(){
        int count = 0;
        for (int[] ints : sourceArray) {
            for (int anInt : ints) {
                if (anInt != 0){
                    count++;
                }
            }
        }

        int [][] spareArray= new int[count + 1][3];
        spareArray[0][0] = 11;
        spareArray[0][1] = 11;
        spareArray[0][2] = count;
        int index = 1;
        for (int i = 0; i < sourceArray.length; i++) {
            for (int j = 0; j < sourceArray[i].length; j++) {
                if (sourceArray[i][j] != 0){
                    spareArray[index][0] = i;
                    spareArray[index][1] = j;
                    spareArray[index][2] = sourceArray[i][j];
                    index++;
                }

            }
        }
        return spareArray;
    }


    /**
     * 恢复一个稀疏数组
     */
    public void spareArraySource(int[][] spareArray){
        this.sourceArray = new int[spareArray[0][0]][spareArray[0][0]];
        for (int i = 1; i < spareArray.length; i++) {
            sourceArray [spareArray[i][0]] [spareArray[i][1]] = spareArray[i][2];
        }
    }

    public void display(){
        for (int[] ints : sourceArray) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Checkerboard checkerboard = new Checkerboard();
        checkerboard.display();
        int[][] backups = checkerboard.backups();
        System.out.println("===稀疏数组===");
        for (int[] ints : backups) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }
        checkerboard.spareArraySource(backups);
        System.out.println("===回复===");
        checkerboard.display();

    }
}

