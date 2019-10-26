import java.util.Arrays;
import java.util.Random;

public class Cake {
    char[][] cake;
    public Cake() {
        this.cake = new char[60][200];
        Random r = new Random();
        //draw pan
        for(int i = 0; i < this.cake.length; i++) {
            for(int j = 0; j < this.cake[0].length; j++) {
                //draw pan
                int val = 2 * (i - 30) * (i - 30) + (j - 50) * (j - 50) / 4;
                if(val <= 280 && val > 260) {
                    this.cake[i][j] = 'X';
                }
                else {
                    this.cake[i][j] = ' ';
                }
                //draw cake surface
                if(2 *(i - 20) * (i - 20) + (j - 50) * (j - 50) / 4 <= 100) {
                    this.cake[i][j] = 'X';
                }
                //draw random candles
                if(2 *(i - 20) * (i - 20) + (j - 50) * (j - 50) / 4 <= 60) {
                    if(r.nextInt(100) == 25) {
                        int k = 0;
                        while(k++ <= 10) {
                            this.cake[i - k][j] = this.cake[i - k][j] == 'X' ? ' ' : 'X';
                        }
                    }
                }

                //draw cake bottom and edges
                if(i > 10 && i < 40 && j > 30 && j < 70 && this.cake[i - 9][j] == 'X' && this.cake[i - 8][j] == ' ') {
                    this.cake[i][j] = 'X';
                }
                else if(i > 20 && i < 31 && (j == 30 || j == 70)) {
                    this.cake[i][j] = 'X';
                    this.cake[i][j] = 'X';
                }
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
