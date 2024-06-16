# Cinema TCS

## 1. Opis projektu
Cinema TCS jest stroną na której użytkownik może w łatwy sposób rezerwować bilety na aktualnie dostępne seanse, które chce obejrzeć.

## 2. Funkcjonalności
1. **Założenie konta**: Użytkownicy mogą tworzyć konta, co umożliwia późniejsze logowanie.
2. **Logowanie**: Możliwość uzyskania dostępu do wszystkich funkcjonalności kina poprzez zalogowanie na swoje konto.
3. **Przeglądanie seansów**: Zalogowany użytkownik może przejrzeć wszystkie seanse dostępne na najbliższy tydzień.
4. **Wybranie seansu**: Po przejrzeniu seansów użytkownik jest w stanie wybrać ten który mu się podoba.
5. **Rezerwacja biletów**: Użytkownik, który wybrał interesujący go seans ma możliwość wybrania ilości biletów którą chce zarezerwować. 
Każdy inny użytkownik już nie będzie mógł wybrać tych samych biletów, które inni użytkownicy zarezerwowali
6. **Wysłanie potwierdzenia zakupu biletu**: Użytkownik po udanej transakcji dostanie potwierdzenie swojego zakupu drogą mailową.

## 3. Architektura

#### 3.1 Warstwa klienta
Frontend został zbudowany przy użyciu React.js oraz HTML+CSS. Komunikacja z serwerem odbywa się poprzez RESTowe API.

- **Struktura katalogów**:
    - `components`: Zawiera logikę kontrolerów dla różnych operacji.
        - `aboutUs.jsx`: Przedstawia informacje na temat twórców.
        - `AuthContext.jsx`: Jest odpowiedzialny za przetrzymywanie informacji czy użytkownik jest zalogowany czy nie.
        - `BuyTickets.jsx`: Odpowiada za rysowanie sali kinowej z funkcją wyboru miejsca.
        - `BuyTickets.jsx`: Przedstawia informaje kontaktowe twórców.
        - `Contact.jsx`: Jest stroną główną kina.
        - `Login.jsx`: Przedstawia formularz logowania.
        - `MobieInReportoire.jsx`: Komponent przedstawia dany film w repertuarze.
        - `Nav.jsx`: Nawigacja strony.
        - `Register.jsx`: Formularz odpowiedzielny za rejestrację.
        - `Reporoire.jsx`: Komonent wyciągający filmy na dany dzień.
        - `Summary.jsx`: Podsumowanie zakupionego biletu i wysłanie maila z rezerwacją miejsca.
    - `style`: Katalog zawierający style wszystki komponentów projektu.
    - `routes`: Zawiera definicje tras API.
    - `App.js`: Główny plik programu zawierający routing podstron.
    - 
#### 3.2 Warstwa serwera
Backend zawiera całą logikę biznesową i opiera się o Java i Spring Boot. Jedyna komunikacja jaką serwer wyokonuje odbywa się z bazą danych poprzez Spring Data JPA

- **Struktura katalogów**:
    - `src`: Główny katalog.
        - `main/java/com/uj/cinema`: Katalog z kodem źródłowym
          - `config`: Katalog zawierający klasy odpowiedzialne za konfiguracje serwera dotyczące na przykład bezpieczeństwa, ale również ogólnych ustawień aplikacji.
          - `model`: Katalog, w którym są wszelkiego rodzaju klasy modelujące encje, DTO, ale również na przykład wyjątki używane w trakcie pracy serwera.
          - `repository`: Katalog zawierający klasy odpowiedzialne za komunikację z bazą danych.
          - `service`: Katalog, w którym są wszystkie serwisy, czyli klasy zawierające logikę biznesową aplikacji.
          - `web/controller`: Katalog zawierający klasy obsługujące żądania HTTP przychodzące z warstwy klienta.
        - `resources`: Katalog z zasobami serwera.
          - `application.yml`: Plik z ustawieniami konfiguracyjnymi aplikacji.
    - `scripts`: Zawiera skrypty potrzebne do inicjalizacji bazy danych.
        - `create.sql`: Skrypt do inicjalizacji tabel.
        - `clear.sql`: Skrypt do usunięcia tabel.
        - `insert.sql`: Skrypt do wstawienia podstawowych danych

#### 3.3 Baza danych
Baza danych odpowiada za przechowywanie danych aplikacji w tabelach bazy PostgreSQL. \
[Tabele z relacjami](assets/database_relations.png)

## 4. Wymagania instalacyjne

- Maven
- PostgreSQL
- npm
- Java

#### Postrzebne zmienne środowiskowe

- DB_USERNAME=<YOUR_DATABASE_USER_USERNAME>
- DB_PASSWORD=<YOUR_DATABASE_USER_PASSWORD>
- DB_URL=<YOUR_DATABASE_URL> (przykład: jdbc:postgresql://localhost:5432/<YOUR_DATABASE_NAME>)
- JWT_SECRET=<YOUR_JWT_SECRET_KEY> (Klucz używany do podpisywania tokenów JWT)
- MAIL_SENDER_USERNAME=<YOUR_MAIL_ACCOUNT_USERNAME> (Nazwa użytkownika konta z którego będą wysyłane maile dotyczące zakupu biletów)
- MAIL_SENDER_PASSWORD=<YOUR_MAIL_ACCOUNT_PASSWORD> (Nazwa do konta z którego będą wysyłane maile dotyczące zakupu biletów)
