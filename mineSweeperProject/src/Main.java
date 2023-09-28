import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);
        //Değerlendirme Formu 7
        System.out.print("Oyun alanı için,\nSatır boyutunu giriniz: " );
        int rowBorder=inp.nextInt(); //Satır Boyutu
        System.out.print("Sütun boyutunu giriniz: " );
        int columnBorder=inp.nextInt(); // Sütun boyutu

        MineSweeper mine=new MineSweeper(rowBorder,columnBorder); //MineSweeper sınıfına ait mine nesnesi oluşturduk.
        mine.gameStart();


}
}