#Cases Spec

This test spec contains success Login , failure Login and Logout cases

## Case 1: Success Login
Tags: Succes
* "hello@getir.com" ve "hello" bilgileriyle login olunur.

## Case 1: Failure Login
Tags: Failure
* "wrongUsername" ve "xxxx" bilgileriyle başarısız login gerçekleştirilir ve toast mesajı kontrol edilir.

## Case Extra: test fail durumunda rapor oluştuğunu görmek için hata alacak senaryo
Tüm testlerin başarılı koşmasını istiyorsanız lütfen bu case'i yorum haline getiriniz
* "fail@getir.com" ve "fail" bilgileriyle login olunur.

## Case 1: Logout
Burada concept yapısının güzelliği ortaya çıkıyor. Başarılı login senaryosu ilk concept'ten direkt olarak alınır.
* "hello@getir.com" ve "hello" bilgileriyle login olunur.
* Logout olma işlemi yapılır. Sayfa geçişleri kontrol edilir.

## Case 2: Add basket random items and erase them all
* "hello@getir.com" ve "hello" bilgileriyle login olunur.

* "Yiyecek" kategorisine girilir "foodCategoryButton" bilgisiyle girilir. Sayfadaki elementler bir listeye alınır, listeden ürün seçilip rastgele tıklanır.
* "Süt & Kahvaltı" kategorisine girilir "milkAndBreakfastButton" bilgisiyle girilir. Sayfadaki elementler bir listeye alınır, listeden ürün seçilip rastgele tıklanır.
* Eğer ürün bulunamadıysa swipe et
* "Bebek" kategorisine girilir "BabyButton" bilgisiyle girilir. Sayfadaki elementler bir listeye alınır, listeden ürün seçilip rastgele tıklanır.

* Sepete tıklanır ve içindeki her ürün silinir. Silindiği kontrol edilir.

## Case 3: Sepete ürünler rastgele eklenir payment adımına geçilir kontroller yapılır ürünler silinir
Case2 sepete ürün ekleme adımları
* "hello@getir.com" ve "hello" bilgileriyle login olunur.
* "Yiyecek" kategorisine girilir "foodCategoryButton" bilgisiyle girilir. Sayfadaki elementler bir listeye alınır, listeden ürün seçilip rastgele tıklanır.
* "Süt & Kahvaltı" kategorisine girilir "milkAndBreakfastButton" bilgisiyle girilir. Sayfadaki elementler bir listeye alınır, listeden ürün seçilip rastgele tıklanır.
* Eğer ürün bulunamadıysa swipe et
* "Bebek" kategorisine girilir "BabyButton" bilgisiyle girilir. Sayfadaki elementler bir listeye alınır, listeden ürün seçilip rastgele tıklanır.

* Sepetteki ürünlerin adedini "3" yapar. Fiyatlarını hesaplar ve payment kısmına gidip kontrol eder. Payment içindeki kontrolleri yapar. Sepete geri dönüp ürünleri siler

