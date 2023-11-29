package Exam1;

import java.util.Scanner;

public class Exam1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("***************");
            System.out.println("1. Nhập giá trị n phần tử của mảng ");
            System.out.println("2. In giá trị các phần tử trong mảng  ");
            System.out.println("3. Tính trung bình các phần tử dương (>0) trong mảng ");
            System.out.println("4. In ra vị trí (chỉ số ) các phần tử có giá trị bằng k trong mảng (k nhập từ bàn phím)");
            System.out.println("5. sử dụng thuật toán nổi bọt sắp xếp mảng giảm dần ");
            System.out.println("6. Tính số lượng các phần tu là so nguyên tố trong mảng ");
            System.out.println("7. Sắp xếp các phần tử chẵn chia hết cho 3 ở đầu mảng theo thứ tự tăng dần ");
            System.out.println("8. nhập giá trị m từ bàn phím , chèn giá trị m vào mảng (sắp xếp giảm dần) đúng vị trí ");
            System.out.println("9. thoát");
            System.out.println("vui lòng chọn số 1- 9");
            int choice = scanner.nextInt();
            int [] array = new int[100];
            switch (choice){
                case 1 :
                    System.out.println("Nhập giá trị n phần tử của mảng : ");

                    for (int i = 0 ; i < array.length ; i++){
                        System.out.println("nhập giá trị thứ " + i);
                        array[i] = scanner.nextInt();
                    }


                    break;
                case 2 :
                    System.out.println("In ra các phần tử trong mảng ");
                    for (int i = 0 ; i < array.length ; i++){
                        System.out.print(array[i] + " ");
                    }
                    break;
                case 3 :
                    System.out.println("tính trung bình các phần tử dương (>0) trong mảng");
                    int sum = 0 ;
                    for (int i = 0 ; i < array.length ; i ++){
                        if (array[i] > 0) {
                            sum += array[i] ;
                        }
                    }
                    System.out.println("Tổng các phần tử dương trong mảng là : "+ sum);
                    break;
                case 4 :
                    System.out.println("in ra vị trí (chỉ số) các phần tử có giá trị bằng k  trong mảng (k ) nhập tử bàn phím");
                    System.out.println(" nhập k :");
                    int k = scanner.nextInt();
                    System.out.println("vị trí các phần tử có giá trị bằng "+ k);
                    for (int i= 0 ; i < array.length ; i++){
                        if (array[i] == k){
                            System.out.print(i + " ");
                        }
                    }
                    break;
                case 5 :
                    System.out.println("sắp xếp giảm dần : ");
                    int temp = 0 ;
                    for (int i = 0 ; i < array.length - 1 ; i ++){
                        for (int j = 0 ; j < array.length - i - 1 ; j++){
                            if (array[j] < array[j+1]){
                                temp = array[j] ;
                                array[j] = array[j+1] ;
                                array[j+1] = temp ;
                            }
                        }
                    }
                    for (int i = 0 ; i < array.length ; i ++ ){
                        System.out.print(array[i] + " ");
                    }

                    break;
                case 6:
                  int primeCount = 0;
                    boolean isPrime=false;
                    for (int i = 0; i < array.length; i++) {
                        if(array[i]<2){
                            isPrime=false;
                        }
                        for (int j = 2; j < Math.sqrt(array[i]); j++) {
                            if(array[i]%j==0){
                                isPrime=false;
                                break;
                            }
                            isPrime=true;
                        }
                        if(isPrime){
                            primeCount++;
                        }
                    }
                    System.out.printf("The amount of Prime Numbers in this array is %d",primeCount);
                    break;


                case 7 :
                    int [] newArray = new int[100];
                    int [] newArrayIncrease = new int[100];
                    int [] newArrayDecrease = new int[100];
                    int [] newArrayOther = new  int [100];
                    int newTemp = 0 ;
                    //lọc các giá trị chẵn chia hết cho 3
                    int countEvenDivisible3 = 0 ;

                    for (int i = 0 ; i < newArrayIncrease.length ; i++){
                        for (int j = 0 ; j < array.length ; j++){
                            if (array[j] %3 == 0&& array[j]%2 == 0){
                                newArrayIncrease[i] = array[j] ;
                                countEvenDivisible3 ++ ;
                            }
                        }
                    }
                    //  sắp xếp tăng dần các giá trị chẵn chia hết cho 3

                    for (int i = 0; i < newArrayIncrease.length - 1; i++) {
                        for (int j = 0; j < newArrayIncrease.length - i - 1; j++) {
                            if (newArrayIncrease[j] > newArrayIncrease[j + 1]) {
                                // Swap arr[j] and arr[j+1]
                                newTemp = newArrayIncrease[j];
                                newArrayIncrease[j] = newArrayIncrease[j + 1];
                                newArrayIncrease[j + 1] = newTemp;
                            }
                        }
                    }
//                    lọc các giá trị lẻ chia hết cho 3
                    int countOddDivisible3 = 0 ;
                    for (int i = 0 ; i < newArrayDecrease.length ; i--){
                        for (int j = 0 ; j < array.length ; j++){
                            if (array[i] %3 == 0&& array[i] %2 != 0){
                                newArrayDecrease[i] = array[j] ;
                            }
                            countOddDivisible3++ ;

                        }
                    }
//                    sắp xếp giảm dần các giá trị lẻ chia hết 3
                    for (int i = 0; i < newArrayDecrease.length - 1; i++) {
                        for (int j = 0; j < newArrayDecrease.length - i - 1; j++) {
                            if (newArrayDecrease[j] < newArrayDecrease[j + 1]) {
                                // Swap arr[j] and arr[j+1]
                                newTemp = newArrayDecrease[j];
                                newArrayDecrease[j] = newArrayDecrease[j + 1];
                                newArrayDecrease[j + 1] = newTemp;
                            }
                        }
                    }
//                    lọc các giá trị không chia hết cho 3
                    int countOther = 0 ;

                    for (int i = 0 ; i < newArrayOther.length ; i ++){
                        for (int j = 0 ; j < array.length ; j ++){
                            if (array[j] %3 != 0 ){
                                newArrayOther[i] = array[j];
                            }
                            countOther++ ;
                        }
                    }
//                    sắp xếp tăng dần các giá trị không chia hết cho 3;
                    for (int i = 0; i < newArrayOther.length - 1; i++) {
                        for (int j = 0; j < newArrayOther.length - i - 1; j++) {
                            if (newArrayOther[j] > newArrayOther[j + 1]) {
                                // Swap arr[j] and arr[j+1]
                                newTemp = newArrayOther[j];
                                newArrayOther[j] = newArrayOther[j + 1];
                                newArrayOther[j + 1] = newTemp;
                            }
                        }
                    }
//                    sắp xếp các phần tử vào mảng mới
                    for (int i = 0 ; i < newArray.length ; i ++){
                        for (int j = 100 - countEvenDivisible3-1 ; j < newArrayIncrease.length ; j ++ ){
                            newArray[i] = newArrayIncrease[j] ;
                        }
                    }
                    for (int i = countEvenDivisible3  ; i < newArray.length ; i++ ){
                        for (int j = 100 - countOther - 1 ; j < newArrayOther.length ; j ++){
                            newArray[i] = newArrayOther[j] ;

                        }

                    }
                    for (int i = countEvenDivisible3 + countOther ; i < newArray.length ; i ++){
                        for (int j = 0 ; j < countOddDivisible3; j++){
                            newArray[i] = newArrayDecrease[j] ;
                        }
                    }
//                    in ra mảng mới
                    System.out.println("mảng mới đã được sắp xếp");
                    for (int i = 0 ; i < newArray.length ; i++){
                        System.out.println(newArray[i] + " ");
                    }

                    break;

                case 8 :
                    System.out.println("nhập vào giá trị m");
                    int m=scanner.nextInt();

                    int[] myNewArray = new int[array.length+1];
                    for (int i = 0; i < myNewArray.length; i++) {
                        if(i<array.length){
                            myNewArray[i]=array[i];
                        }else {
                            myNewArray[i]=m;
                        }
                    }

                    for (int i = 0; i < myNewArray.length - 1; i++) {
                        for (int j = 0; j < myNewArray.length - i - 1; j++) {
                            if (myNewArray[j] < myNewArray[j + 1]) {

                                int a = myNewArray[j];
                                myNewArray[j] = myNewArray[j + 1];
                                myNewArray[j + 1] = a;
                            }
                        }
                    }

                    System.out.println("mảng mới : ");
                    for (int i = 0 ; i < myNewArray.length ; i++){
                        System.out.println(myNewArray[i] + " ");

                    }
                    break;


                case 9 :
                    System.out.println("thoát");
                    System.exit(0);
                    break;

                default:
                    System.out.println("vui lòng nhâp số 1 - 9 : ");
                    break;
            }
        }while (true);
    }
}
