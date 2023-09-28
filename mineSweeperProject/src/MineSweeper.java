import java.util.Random;
import java.util.Scanner;
// Değerlendirme Formu 5
public class MineSweeper {
    int row, column; //Satır, Sütun
    int size;// Kaça kaçlık bir oyun alanı olacak onu belirtiyor.
    int rowSelect; // Kullanıcının seçeceği satır
    int columnSelect;//Kullanıcının seçeceği sütun
    String[][] gameArray;// Mayın Dizisi
    String[][] mineArray;// Oyun Dizisi
    int minesTotal; // Olması gereken toplam mayın adeti.
    String answer; // Tekrar oynamak ister misin sorusunun cevabını tutar.
    Scanner inp = new Scanner(System.in);
    Random rand = new Random();
    MineSweeper(int row, int column) {
        this.row = row;
        this.column = column;
        this.gameArray = new String[row][column];
        this.mineArray = new String[row][column];
        this.size = row* column;
        this.minesTotal = size / 4; // oyundaki toplam mayın sayısı.

    }
    //Değerlendirme Formu 6
    public void mineBoard() { // Kullanıcının istediği boyutta bir oyun alanı oluşturuldu.
        for (int i = 0; i < this.mineArray.length; i++) {// mayin ve oyun dizilerini istenen boyutlarda noktalardan oluşturduk.
            for (int j = 0; j < this.mineArray[i].length; j++) {
                this.mineArray[i][j] = ". ";
                this.gameArray[i][j] = ". ";

            }
        }
        //Değerlendirme Formu 8
        //mayın dizisinin içine random mayın yerleştiriliyor.
        int m = 0;
        while (m != this.minesTotal) {
            int randomSatir = rand.nextInt(row); // satır sayısından random biri seçiliyor.
            int randomSutun = rand.nextInt(column); // sütun sayısından random biri seçiliyor.
            if (!(this.mineArray[randomSatir][randomSutun].equals("* "))) { // seçilen random satır ve sütundaki değer * a eşit değilse oraya * koyar.
                this.mineArray[randomSatir][randomSutun] = "* ";// if koşulu sağlanmıyorsa m değerini arttırmaz.
                m++; //Böylece aynı random sayılar üretilirse döngünün başına dönüp tekrar random üretilmesi sağlanır.
                //Ne zamanki m değeri mayın sayısına eşit olur o zaman döngüden çıkılır.
            }
        }

        System.out.println("Mayınların Konumu:");

        for (int i = 0; i < this.mineArray.length; i++) { // Mayın dizisinin mayınlı hali ekrana yazılıyor.
            for (int j = 0; j < this.mineArray[i].length; j++) {
                System.out.print(this.mineArray[i][j]);
            }
            System.out.println();

        }
    }
    //Değerlendirme Formu 6
    public void gameBoard() {
        System.out.println("Mayın Tarlasına Hoşgeldiniz !");
        for (int i = 0; i < this.gameArray.length; i++) {  // Oyun dizisi ekrana yazılıyor.
            for (int j = 0; j < this.gameArray[i].length; j++) {
                System.out.print(this.gameArray[i][j]);
            }
            System.out.println();
        }

    }
    //Değerlendirme Formu 6
    public void gameStart() {
        mineBoard(); // Mayın dizisini çektik
        gameBoard(); // Oyun dizisini çektik.
        while (true) {
            //Değerlendirme Formu 9
            System.out.print("Satır numarasını giriniz: ");
            rowSelect = inp.nextInt();
            System.out.print("Sütun numarasını giriniz: ");
            columnSelect= inp.nextInt();

            //Değerlendirme Formu 10
            //Seçilen noktanın dizinin sınırları içerisinde olup olmadığını kontrol edilmeli ve koşul sağlanmazsa tekrar nokta istenmeli.
            if (rowSelect>= this.row || columnSelect >= this.column || columnSelect < 0 || rowSelect< 0) {
                System.out.println("Yanlış değerler girdiniz. Tekrar giriniz: ");
                continue;
            }
            //Değerlendirme Formu 13,15
            if (isFail()) { //Kullanıcının girdiği noktada mayın var ise oyunu kaybetmeli.
                System.out.println("Game Over...");
                if (isAgain()) { // Tekrar oynamak isterse tekrar oynar.
                    gameStart();
                }
                break; //istemezse oyun sona erer.


            }
            //Değerlendirme Formu 12
            //Mayın yok ise, ilgili noktaya değen tüm konumlarına bakılmalı (sağı, solu, yukarısı, aşağısı, sol üst çapraz, sağ üst çapraz, sağ alt çapraz, sol alt çapraz)
            // ve etrafındaki mayınların sayısının toplamı ilgili noktaya yazılmalı.
            // Noktaya değen herhangi bir mayın yok ise "0" değeri atanmalı.
            else {
                int count = 0; // Sayaç

                for (int i = (rowSelect - 1); i <= (rowSelect + 1); i++) {
                    for (int j = (columnSelect - 1); j <= (columnSelect + 1); j++) {
                        if (i < 0 || i >= this.row || j < 0 || j >= this.column) {
                            continue;
                        }
                        if (this.mineArray[i][j].equals("* ")) { // etrafında kaç tane * varsa sayıyor.
                            count++;
                        }
                    }
                }
                this.gameArray[rowSelect][columnSelect] =Integer.toString(count)+" "; //Dizi String veri tuttuğu için  sayac değerini int den Stringe çevirdik. Program gerek olmadığını söylemiş ben yine de yaptım.
               //Değerlendirme Formu 11
                for (int i = 0; i < this.gameArray.length; i++) {// seçilen indisin etrafında kaç * olduğunu göstererek oyun alanını güncelledik.
                    for (int j = 0; j < this.gameArray[i].length; j++) {
                        System.out.print(this.gameArray[i][j]);
                    }
                    System.out.println();
                }
            }
            //Değerlendirme Formu 14,15
            if (isWin()){ // Kullanıcı hiç bir mayına basmadan tüm noktaları seçebilirse oyunu kazanmalı.
                System.out.println("Tebrikler, Kazandınız!!!");
                if (isAgain()) { // Tekrar oynamak isterse tekrar oynar.
                    gameStart();
                }
                break; //istemezse oyun sona erer.

            }

        }

    }
    //Değerlendirme Formu 6
    public boolean isFail() {// Mayın dizisinde kullanıcının işaretlediği yerde * varsa True yoksa False.
        if (this.mineArray[this.rowSelect][this.columnSelect].equals("* ")) {
            return true;
        }
        return false;
    }
    //Değerlendirme Formu 6
    public boolean isWin() { // Oyun alanındaki . sayısı mayın sayısına eşitlendiğinde
        // alanda sadece mayın kalmış ve oyun kazanılmış demektir.
        int count = 0;
        for (int i = 0; i < this.gameArray.length; i++) {
            for (int j = 0; j < this.gameArray[i].length; j++) {
                if (this.gameArray[i][j].equals(". ")) {
                    count++;
                }
            }
        }
        if (count==this.minesTotal){
            return true;
        }
        return false;
    }
    //Değerlendirme Formu 6
    public boolean isAgain(){
        System.out.println("Tekrar oynamak ister misiniz? (E/H)");
        Scanner input=new Scanner(System.in);
        answer=input.nextLine();
        if (answer.equals("e")||answer.equals("E")) {

            return true;
        }
        else{
            System.out.println("Tekrar görüşürüz :)");
            return false;

        }


    }
}




