package Exam2;

import java.util.Scanner;

public class Exam2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("nhập số dòng ");
        int row = scanner.nextInt();
        System.out.println("nhập số cột ");
        int col = scanner.nextInt();
        int[][] array = new int[row][col];
        do {
            System.out.println("1. Nhập giá trị các phần tử của mảng");
            System.out.println("2. In giá trị các phần tử trong mảng theo ma trận");
            System.out.println("3. Tính số lượng các phần tử chia hết cho 2 và 3 trong mảng");
            System.out.println("4. In các phần tử và tổng các phần tử nằm trên đường biên, đường chéo chính và \n" +
                    "đường chéo phụ");
            System.out.println("5. Sử dụng thuật toán sắp xếp lựa chọn sắp xếp các phần tử tăng dần theo cột của \n" +
                    "mảng");
            System.out.println("6. In ra các phần tử là số nguyên tố trong mảng ");
            System.out.println("7. Sử dụng thuật toán chèn (Insertion sort) sắp xếp các phần tử trên đường chéo chính \n" +
                    "của mảng giảm dần");

            System.out.println("8. Nhập giá trị một mảng 1 chiều gồm m phần tử và chỉ số dòng muốn chèn vào mảng, \n" +
                    "thực hiện chèn vào mảng 2 chiều");
            System.out.println("9. Thoát");
            System.out.println("Vui lòng nhập từ 1 - 8 :");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    for (int i = 0; i < row; i++) {
                        for (int j = 0; j < col; j++) {
                            System.out.println("nhập phần tử array[" + i + "][" + j + "]");
                            array[i][j] = scanner.nextInt();
                        }
                    }

                    break;
                case 2:
                    System.out.println("in ra cá phâ tử theo ma trận");
                    for (int i = 0; i < row; i++) {
                        for (int j = 0; j < col; j++) {
                            System.out.print(array[i][j] + " ");

                        }
                        System.out.println();
                    }


                    break;
                case 3:
                    int count = 0;
                    for (int i = 0; i < row; i++) {
                        for (int j = 0; j < col; j++) {
                            if (array[i][j] % 2 == 0 || array[i][j] % 3 == 0) {
                                count++;
                            }
                        }
                    }
                    System.out.println("số lượng các phần tử chia hết cho 2 và 3 la : " + count);

                    break;
                case 4:
                    int countArround = 0;
                    System.out.println("Border elements:");
                    // In phần tử ở hàng đầu tiên và cuối cùng
                    for (int j = 0; j < col; j++) {
                        System.out.print(array[0][j] + " ");
                        countArround += array[0][j];
                    }
                    System.out.println();

                    // In phần tử ở hàng cuối cùng và đầu tiên
                    for (int i = 1; i < row - 1; i++) {
                        System.out.print(array[i][col - 1] + " ");
                        countArround += array[i][col - 1];
                    }
                    System.out.println();

                    // In phần tử ở hàng cuối cùng và đầu tiên (ngược lại)
                    for (int j = col - 1; j >= 0; j--) {
                        System.out.print(array[row - 1][j] + " ");
                        countArround += array[row - 1][j];
                    }
                    System.out.println();

                    // In phần tử ở hàng đầu tiên và cuối cùng (ngược lại)
                    for (int i = row - 2; i > 0; i--) {
                        System.out.print(array[i][0] + " ");
                        countArround += array[i][0];
                    }
                    System.out.println();

// in và tính tổng chéo chính


                    System.out.println("các phần tử trên đường chéo chính là");
                    int sumMainDiagonal = 0;

                    if (row == col) {
                        for (int i = 0; i < row; i++) {
                            System.out.print(array[i][i] + " ");
                            sumMainDiagonal = array[i][i];
                        }
                        System.out.println("tổng các phần tử trên đường chéo chính là  : " + sumMainDiagonal);
                    } else {
                        System.out.println("không có đường chéo chính");
                    }

                    System.out.println();
//                    in va tính tổng chéo phụ
                    int sumSecondaryDiagonal = 0;
                    System.out.println("các phần ử trên chéo phụ :");

                    if (row == col) {
                        for (int i = 0; i < row; i++) {
                            System.out.print(array[i][row - i - 1] + " ");
                            sumSecondaryDiagonal += array[i][row - i - 1];
                        }
                        System.out.println("tổng các phần tử trên đường chéo phụ là : " + sumSecondaryDiagonal);
                    } else {
                        System.out.println("không có đường chéo phụ");
                    }

                    System.out.println();


                    break;
                case 5:
                    int rows = array.length;
                    int columns = array[0].length;

                    for (int cols = 0; cols < columns; cols++) {
                        for (int i = 0; i < rows - 1; i++) {
                            int minIndex = i;
                            for (int j = i + 1; j < rows; j++) {
                                if (array[j][cols] < array[minIndex][cols]) {
                                    minIndex = j;
                                }
                            }
                            if (minIndex != i) {
                                int temp = array[i][cols];
                                array[i][cols] = array[minIndex][cols];
                                array[minIndex][cols] = temp;
                            }
                        }
                    }
                    for (int i = 0; i < row; i++) {
                        for (int j = 0; j < col; j++) {
                            System.out.print(array[i][j] + " ");
                        }
                        System.out.println();
                    }

                    break;
                case 6:
                    int countPrime = 0;
                    boolean isPrime = false;
                    for (int i = 0; i < row; i++) {
                        for (int j = 0; j < col; j++) {
                            if (array[i][j] < 2) {
                                isPrime = false;
                            }
                            for (int k = 2; k < Math.sqrt(array[i][k]); k++) {
                                if (array[i][j] % k == 0) {
                                    isPrime = false;
                                    break;
                                }
                                isPrime = true;
                            }
                            if (isPrime) {
                                countPrime++;
                            }
                        }
                    }
                    System.out.printf("số lương các số nguyên tố trong mảng là " + countPrime);
                    break;


                case 7:
                    int[] mainDiagonalArray = new int[row];
                    for (int i = 0; i < row; i++) {
                        for (int j = 0; j < col; j++) {
                            if (i == j) {
                                mainDiagonalArray[i] = array[i][j];
                            }
                        }
                    }
                    for (int i = 1; i < mainDiagonalArray.length; i++) {
                        int key = mainDiagonalArray[i];
                        int j = i - 1;


                        while (j >= 0 && mainDiagonalArray[j] < key) {
                            mainDiagonalArray[j + 1] = mainDiagonalArray[j];
                            j = j - 1;
                        }


                        mainDiagonalArray[j + 1] = key;
                    }

                    for (int i = 0; i < row; i++) {
                        array[i][i] = mainDiagonalArray[i];
                    }

                    for (int i = 0; i < row; i++) {
                        for (int j = 0; j < col; j++) {
                            System.out.print(array[i][j] + " ");
                        }
                        System.out.println();
                    }
                    break;
                case 8:
                    int[][] myNewArr=new int[row][col+1];
                    int[] addArr=new int[row];
                    int indexAdd=100;
                    System.out.println("hãy nhập so cần chèn");
                    for (int i = 0; i < row; i++) {
                        System.out.printf("nhập add %d :" , i);
                        addArr[i]=scanner.nextInt();
                    }
                    while (indexAdd>col+1){
                        System.out.println("nhập vị trí cần add");
                        indexAdd= scanner.nextInt();
                    }
                    for (int i = 0; i < row; i++) {
                        for (int j = 0; j < col+1; j++) {
                            if(j<indexAdd){
                                myNewArr[i][j]=array[i][j];
                            } else if (j==indexAdd) {
                                myNewArr[i][j]=addArr[i];
                            }else {
                                myNewArr[i][j]=array[i][j-1];
                            }
                        }
                    }
                    System.out.println("mảng sau khi add ");
                    for (int i=0;i<row;i++){
                        for (int j=0;j<col+1;j++){
                            System.out.print(myNewArr[i][j]+" ");
                        }
                        System.out.println();
                    }
                    break;
                case 9:
                    System.out.println("thoát");
                    System.exit(0);
                    break;
                default:
                    System.out.println("vui lòng nhập 1 - 9");

                    break;


            }

        }while (true) ;

    }
}
