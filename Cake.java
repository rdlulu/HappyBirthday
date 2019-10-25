import java.util.Arrays;
import java.util.Random;

public class Cake {
    char[][] cake;
    public Cake() {
        this.cake = new char[60][200];
        //draw pan
        for(int i = 0; i < this.cake.length; i++) {
            for(int j = 0; j < this.cake[0].length; j++) {
                int val = 2 * (i - 30) * (i - 30) + (j - 50) * (j - 50) / 4;
                if(val <= 280 && val > 260) {
                    this.cake[i][j] = 'X';
                    //this.drawCandle(i, j);
                }
                else {
                    this.cake[i][j] = ' ';
                }
            }
        }
        //draw cake surface
        for(int i = 0; i < this.cake.length; i++) {
            for(int j = 0; j < this.cake[0].length; j++) {
                if(2 *(i - 20) * (i - 20) + (j - 50) * (j - 50) / 4 <= 100) {
                    this.cake[i][j] = 'X';
                    //this.drawCandle(i, j);
                }

            }
        }
        //draw cake bottom and edges
        for(int i = 0; i < this.cake.length; i++) {
            for(int j = 0; j < this.cake[0].length; j++) {
                if(i < 30 && j > 30 && j < 70 && this.cake[i][j] == 'X' && this.cake[i + 1][j] == ' ') {
                    this.cake[i + 9][j] = 'X';
                }
                else if(i > 20 && i < 31) {
                    this.cake[i][30] = 'X';
                    this.cake[i][70] = 'X';
                }
            }
        }
        //draw random candles
        for(int i = 0; i < this.cake.length; i++) {
            for(int j = 0; j < this.cake[0].length; j++) {
                if(2 *(i - 20) * (i - 20) + (j - 50) * (j - 50) / 4 <= 60) {
                    this.drawCandle(i, j);
                }
            }
        }
    }

    private void drawCandle(int i, int j) {
        Random r = new Random();
        if(r.nextInt(100) == 25) {
            int k = 0;
            while(k++ <= 10) {
                this.cake[i - k][j] = this.cake[i - k][j] == 'X' ? ' ' : 'X';
            }
        }

    }
    public static void main(String[] args) {
        Cake c = new Cake();
        for(int i = 0; i < c.cake.length; i++) {
            for(int j = 0; j < c.cake[0].length; j++) {
                System.out.print(c.cake[i][j]);
            }
            System.out.println("");
        }

    }
}
