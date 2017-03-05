package edu.tomer.java;

public class Main {

    public static boolean[][] canvas = new boolean[30][50];

    public static void main(String[] args) {

        //drawHorizontalLine(4);
        //drawVerticalLine(7);
        drawRect(2,3,5,7);
        drawSquare(10,4,8);
        render();

        /*
        boolean b = true;
        boolean c = false;
        boolean d = true;
        boolean[] arr = new boolean[3];
        arr[0] = b;
        arr[1] = c;
        arr[2] = d;

        int[][] grades = {{65,70},{85,40},{60,96},{0,40}};

        for (int i = 0; i < grades.length; i++){
            for (int j = 0; j < grades[i].length; j++){
                System.out.println(grades[i][j]);
            }
        }


        //grades[2][1] = -6;
        //System.out.println(grades[2][1]);
        */
    }

    public static void drawSquare(int top, int left, int width){
        drawRect(top, left, width, width);
    }

    public static void drawRect(int top, int left, int height, int width){
        for (int i = left; i < width + left; i++){
            canvas[top][i] = true;
            canvas[top + height-1][i] = true;
        }
        for (int i = top; i < top + height; i++){
            canvas[i][left] = true;
            canvas[i][left + width-1] = true;
        }
    }

    public static void drawVerticalLine(int columnNumber) {
        for (int i = 0; i < canvas.length; i++) {
            canvas[i][columnNumber] = true;
        }
    }

    public static void drawHorizontalLine(int lineNumber){
        for (int i = 0; i < canvas[lineNumber].length; i++){
            canvas[lineNumber][i] = true;
        }
    }

    public static void render(){
        for (int i = 0; i < canvas.length; i++){
            for (int j = 0; j < canvas[i].length; j++){
                System.out.print(canvas[i][j] ? "0 " : "- ");
            }
            System.out.println();
        }
    }

}
