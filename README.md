# getirMobileGauge

- Bu proje maven üzerinde BDD yaklaşımını sağlamak için Gauge ile yazılmıştır. Appium kullanılmıştır.
- Gauge hakkında bilgi almak için medium üzerindeki şu yazımı inceleyebilirsiniz : https://semihsaydam.medium.com/gauge-1334a2229bb7
Selenium, Appium, Jmeter vb. automation konuları hakkında bilgi almak için diğer 47 makaleyi medium üzerinden inceleyebilirsiniz.

- Öncelikle Gauge kullanırken testlerimizi Spec dosyaları halinde tutarız. Projedeki spec dosyalarına proje içinden "getirMobileGauge/specs/" ulaşabilirsiniz.
Spec dosyalarındaki BDD yaklaşımlı adımları ise Concepts altında kısaltıyoruz. Örneğin 6 adımdan oluşan bir login senaryosunu concept ile kısaltarak tek adımda çağırabilirsiniz
ScenariosConcepts.cpt altındaki ilk "# <username> ve <password> bilgileriyle login olunur." ifadesi altındaki 6 adımı çağırıyor olacaktır. Farklı username ve password'ler için başarılı logini sağlayacaktır.

- Gauge'nin kendi raporlama ekranları oluşur. Bunun ayarları yapılabilir. Örneğin hata durumunda screenShot alması için "screenshot_on_failure = true" değeri true yapılır.
Bu ayarlar proje içindeki "getirMobileGauge/env/default/default.properties" içinden yapılır. Rapora ulaşmak isterseniz, Senaryo bitiminde "reports" klasörü oluşur. İçindeki index.html sizin raporunuzdur.
Raporu oluşturmak istediğiniz direction'u da yine properties'yen ayarlayabilirsiniz.

- Projede Log4j ile loglamalar yapılmaktadır. Tüm hata seviyelerini log'layabilmek için log4j2.properties dosyası eklenmiştir. Buradan log ayarları düzenlenebilir.
Proje içinden "getirMobileGauge/src/main/resources/" adımlarıyla erişilebilir.

- Projede sürekli kullanılacak findElement, click vb. gibi methodlar proje içindeki "getirMobileGauge/src/test/java/driver/BaseMethods.java" içinde kısaltılmıştır.

- Uygulamayı ayağa kaldırmak için Appium hub tetiklenir. Bunun için Capabilities bilgileri Proje içindeki "getirMobileGauge/src/test/java/driver/HookImpl.java" class'ında verilir.

- BDD yaklaşımlı adımların arkasına yazılan methodlar Step annotation'ları ile tanımlanır. Bu methodlar proje içindeki "getirMobileGauge/src/test/java/StepImpl/StepImplementation.java" class'ında bulunur.

- Adımlarda kullanılmak üzere id, xpath vb. bilgiler bir json'da tutulur. Bu json'a proje içindeki "getirMobileGauge/src/test/resources/element-values/getirProject.json" ile ulaşabilirsiniz.


Sorularınız için Linkedin : https://www.linkedin.com/in/semih-saydam-574829168/

Mutlu günler dilerim :)

