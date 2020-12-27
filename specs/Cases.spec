#Cases Spec

This test spec contains success Login , failure Login and Logout cases

## Case 1: Success Login
Tags: Succes
* "hello@getir.com" ve "hello" bilgileriyle login olunur.

## Case Extra : raporda fail durumunda screenshot alındığını göstermek için fail alacak senaryo
* Bu adımda rapora "burada yazılan mesaj raporda gözükür" yaz
* "fail@getir.com" ve "fail" bilgileriyle login olunur.

## Case 1: Failure Login
Tags: Failure
* "wrongUsername" ve "xxxx" bilgileriyle başarısız login gerçekleştirilir ve toast mesajı kontrol edilir.


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


## Case Extra :
* "hello@getir.com" ve "hello" bilgileriyle login olunur.
* "Yiyecek" kategorisine girilir "foodCategoryButton" bilgisiyle girilir. Sayfadaki elementler bir listeye alınır, listeden ürün seçilip rastgele tıklanır.
 "Süt & Kahvaltı" kategorisine girilir "milkAndBreakfastButton" bilgisiyle girilir. Sayfadaki elementler bir listeye alınır, listeden ürün seçilip rastgele tıklanır.
* "getirLogo" elementinin görünür olduğunu kontrol eder.
* "BasketButton" butonuna tıkla
* sepetteki tüm ürünleri "basketIncraseButtons" ile bulduktan sonra adedini "3" tane yap
 "basketNoResultText" elementinin yazısı "There is no result" görünene kadar sepetteki tüm ürünler "basketNegativeButtonList" elementiyle silinir. "productCountList" bilgisiyle ürünün sayısı kadar tıklanır.
* "1" tane ürün "basketNoResultText" elementinin yazısı "There is no result" görünene kadar sepetteki tüm ürünler "basketNegativeButtonList" elementiyle silinir. "productCountList" bilgisiyle ürünün sayısı kadar tıklanır.