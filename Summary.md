## Запуск автотестов и получение отчета

#### 1. Запустить контейнеры Docker с помощью команды
 docker-compose down && docker-compose up -d

#### 2. Запустить эмулятор 
 java -jar ./artifacts/aqa-shop.jar 

#### 3. Запустить тесты 
 ./gradlew clean test               

#### 4. Сформировать и открыть отчет Allure
 ./gradlew allureServe 


## Запланированные автотесты

 1. Успешная оплата (валидная карта) - **✅ Реализовано**
 2. Отказ в оплате (невалидная карта) - **❗Реализовано, есть баг** https://github.com/lizaveta0/diplom/issues/3
 3. Отказ в оплате (карта с недостаточным балансом) - **❌Не реализовано** (В результате написания АТ, стало понятно, что баланс для всех карт - одинаковый) 
 4. Успешное одобрение кредита (валидная карта) - **✅ Реализовано**
 5. Отказ в выдаче кредита (невалидная карта) - **❗Реализовано, есть баг** https://github.com/lizaveta0/diplom/issues/3
 6. Проверка ввода некорректных данных

#### Сценарии:

- **Пустые поля** - **❗Реализовано, есть баг** https://github.com/lizaveta0/diplom/issues/2
- **Неверный формат номера карты** - **✅ Реализовано**
- **Неверный месяц** - **✅ Реализовано**
