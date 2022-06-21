package su22hw2;

import java.util.Scanner;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Su22Hw2 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("inputs.txt"));
        Scanner sc1 = new Scanner(new File("inputs.txt"));
        int count = 0, i = 0;
        double totaltax;
        final double TAX = 0.08875;
        double highestprice, lowestprice, newprice, firstprice, secondprice;

        while (sc1.hasNext()) {
            String line = sc1.nextLine();
            count++;
        }
        int skucopy[] = new int[count];
        String datecopy[] = new String[count];
        double pricecopy[] = new double[count];
        double discountcopy[] = new double[count];
        int arr[] = new int[count];

        /*I got this from the internet because I was having struggles
  getting the date out from the file.The date wasn't a string, double or int and 
  needed a way to get the date formatted the same way as in the file.
  The website I took it from was jenkov.com. The simpleDataFormat 
  is used to help format the dates how you want them and used it 
  to convert it into a string*/
        String pattern = "MM-DD";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());

        while (sc.hasNext()) {

            datecopy[i] = sc.next();
            skucopy[i] = sc.nextInt();
            pricecopy[i] = sc.nextDouble();
            discountcopy[i] = sc.nextDouble();
            i++;
        }
        //for loop was giving index 5 out of bound for length 5 so I just subtract 1
        for (i = 0; i < arr.length - 1; i++) {
            System.out.printf("Report from: %s to %s\n", datecopy[i], datecopy[i + 1]);
            firstprice = (pricecopy[i] - (discountcopy[i] / 100) * pricecopy[i]);
            secondprice = (pricecopy[i + 1] - (discountcopy[i + 1] / 100 * pricecopy[i + 1]));
            newprice = firstprice + secondprice;
            System.out.printf("The total price is %.2f\n", newprice);
            totaltax = newprice * TAX;
            System.out.printf("The tax is %.2f\n", totaltax);

            if (firstprice > secondprice) {
                highestprice = firstprice;
                System.out.printf("The highest price item is %d at %.2f\n", skucopy[i], highestprice);
            } else {
                highestprice = secondprice;
                System.out.printf("The highest price item is %d at %.2f\n", skucopy[i + 1], highestprice);
            }
            if (firstprice < secondprice) {
                lowestprice = firstprice;
                System.out.printf("The lowest price item is %d at %.2f\n", skucopy[i], lowestprice);
            } else {
                lowestprice = secondprice;
                System.out.printf("The lowest price item is %d at %.2f\n", skucopy[i + 1], lowestprice);
            }
            System.out.printf("\n");

        }
        System.out.printf("Report completed!\n");
    }
}
