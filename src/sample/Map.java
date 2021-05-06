package sample;

import java.util.Scanner;

public class Map{
    private int size;
    private int x;
    private int y;
    String[][] arr;

    public Map(Scanner input) throws InvalidMapException{

        this.size = input.nextInt();
        if(size == 0){
            try {
                throw new InvalidMapException("Map size can not be zero");
            }catch (InvalidMapException e){
                System.out.println(e.getMessage());
                System.exit(0);
            }

        }

        arr = new String[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                arr[i][j] = input.next();
                if(arr[i][j].equals("R") || arr[i][j].equals("D") || arr[i][j].equals("U") || arr[i][j].equals("L")){
                    try {
                        throw new InvalidMapException("Not enough map elements");
                    }catch (InvalidMapException e){
                        System.out.println(e.getMessage());
                        System.exit(0);
                    }
                }
            }
        }
    }
    public int getSize() {
        return this.size;
    }

    public void print(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                System.out.print(arr[i][j] + ' ');
            }
            System.out.println();
        }
    }
    public char getValueAt(int x, int y) {
        this.x = x;
        this.y = y;
        return arr[y][x].charAt(0);
    }
}
