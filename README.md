# Nazwa zadania

Atipera Task

## Wprowadzenie

Podając nazwę użytkownika, można uzyskać listę jego repozytoriów i commitów

## Wymagania

<br>Java 17,
<br>Spring Boot,
<br>Rest Api,
<br>Kompilator.

## Działanie programu
Program wypisuje repozytoria, commity i branche dla danego użytkownika.

## Przyklad użycia

1. Pobierz program i uruchom go w wybranym kompilatorze ( u mnie IntelliJ IDEA Community Edition 2022.2.3 ).
2. Aby odczytać zawartość repozytoriów danego użytkownika wpisz w przeglądarkę ( u mnie chrome).

http://localhost:8080/repositories?username=user

gdzie:
<br> user - to nazwa użytkownika

Przykład użycia:

http://localhost:8080/repositories?username=DPCivilEngineer

3. Aby zobaczyć branch danego użytkownika w danym repozytorium w przeglądarkę wpisz:

http://localhost:8080/repository/branches?username=user&repositoryName=reponame

gdzie:
<br> user - nazwa użytkownika;
<br> reponame - nazwa repozytorium

Przykład użycia:

http://localhost:8080/repository/branches?username=DPCivilEngineer&repositoryName=TestApi1

4. Aby zobaczyć comitty danego użytkownika z danego repozytorium w przeglądarkę wpisz:

http://localhost:8080/repository/lastcommit?username=user&repositoryName=reponame

gdzie:
<br> user - nazwa użytkownika
<br> reponame - nazwa repozytorium

przykład użycia:

http://localhost:8080/repository/lastcommit?username=DPCivilEngineer&repositoryName=TestApi1


## Wykonał

DPCivilEngineer