Mayın Tarlası Oyunu.

Oyun metin tabanlıdır.
Oyunu MineSweeper sınıfı içerisinde çift boyutlu diziler ile işlem yaparak tasarladım. 
Kullanıcıdan en başta satır ve sütun numarasını istedim. Buna göre oyun alanının boyutu belirlenmiş oldu. 
(satır*sütun)/4  ifadesiyle oyunu her başlattığımızda  oyundaki mayın sayısı, kullanıcının en başta girdiği satır sütun bilgilerine göre değişiyor olacak.
Mayınların tutulduğu alanı ve oyunun oynanacağı alanı iki ayrı dizide tuttum ki başta mayınların konumunu gösteren dizinin çıktısını görelim.
Oyun içinde yapılacak işlemleri de oyun dizisinin çıktısında görelim.

Oyun başladığında;
Kullanıcının bir satır ve sütun değerini girmesini istedik. 
Eğer seçtiği yerde mayın varsa oyunu direkt sonlandırıp ekrana "Game Over" mesajını veriyoruz. 
Sonrasında kullanıcıya tekrar oynamak isteyip isyemediğini soruyoruz. Tekrar oynamak istiyorsa oyunu en baştan başlatıyoruz. İstemiyorsa oyun orada sonlanmış oluyor.
Eğer seçtiği yerde mayın yoksa seçili yerin etrafında kaç tane mayın varsa onun sayısını seçili kutucuğa yazdırıyoruz.
Mayın olan kutuyu seçmediği taktirde bu şekilde seçtiği kutucuğa etraftaki mayın sayısının toplamını yazdırıyoruz.
En son seçilecek alan kalmazsa yani sadece mayınların olduğu kutucuklar kaldıysa kullanıcı oyunu kazanmış oluyor. 
Ekrana "Tebrikler oyunu kazandınız" gibi bir mesaj yazdırıyoruz.
Kullanıcı oyunu kazandıktan sonra ekrana, oyunu kaybettiğinde olduğu gibi tekrar oynamak isteyip istemediğini soruyoruz. 
İstiyorsa oyun baştan başlıyor. İstemiyorsa oyun orada sona eriyor.


