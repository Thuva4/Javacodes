import java.util.Stack;
class Solution {
        public static int maximalRectangle(char[][] matrix) {
                int y = matrix.length;
                if(y == 0) return 0;

                int max = 0;
                int x = matrix[0].length;
                System.out.println("adsada");
                for(int yFrom = 0; yFrom < y; yFrom++){
                        for(int yTo = yFrom; yTo < y; yTo++){
                                for(int xFrom = 0; xFrom < x; xFrom++){
                                        for(int xTo = xFrom; xTo < x; xTo++){
                                                if(isValid(matrix, xFrom, xTo, yFrom, yTo)){
                                                        max = Math.max(max, getArea(xFrom, xTo, yFrom, yTo));
                                                }
                                        }
                                }
                        }
                }
                return max;
        }

        public static int getArea(int xFrom, int xTo, int yFrom, int yTo){

                System.out.println((xTo - xFrom + 1) * (yTo - yFrom + 1));
                return (xTo - xFrom + 1) * (yTo - yFrom + 1);
        }

        public static boolean isValid(char[][] matrix, int xFrom, int xTo, int yFrom, int yTo){

                for(int i = yFrom; i <= yTo; i++){
                        for(int j = xFrom; j <= xTo; j++){
                                if(matrix[i][j] != '1') return false;
                        }
                }
                return true;
        }

        public static void main(String [] g){
                char A[][] = { {1, 1, 1, 1,1,1,1},
                        {1, 1, 0, 1,1,1,1},
                        {1, 1, 0, 1,0,1,0},
                        {0, 1, 1,1, 0,1,1},
                        {1, 1, 1,1, 0,0,1},
                        {1, 1, 0,1, 1,1,1},

                };
         System.out.println(maximalRectangle(A));
        }


}