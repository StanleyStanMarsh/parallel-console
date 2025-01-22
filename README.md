 # Параллельный доступ к консоли

Проект демонстрирует реализацию системы управления доступом к консоли с использованием бинарного семафора в многопоточной среде.

## Описание
Проект моделирует работу операционной системы, где несколько пользовательских процессов и системный процесс конкурируют за доступ к консоли. Для обеспечения корректного доступа используется бинарный семафор, гарантирующий, что только один процесс может работать с консолью в определенный момент времени.

## Структура проекта
- `BinarySemaphore.java` - собственная реализация бинарного семафора
- `UserThread.java` - класс, представляющий пользовательский процесс
- `SystemThread.java` - класс, представляющий системный процесс
- `App.java` - основной класс с демонстрацией работы системы

## Тестирование
Проект включает модульные тесты (`AppTest.java`), которые проверяют:
- Корректность работы одиночного пользователя
- Работу системного процесса
- Взаимодействие множества пользователей
- Корректность взаимодействия системного и пользовательского процессов

## Запуск проекта
```bash
# Сборка проекта
mvn package

# Запуск приложения
java -cp target/parallel-console-1.0-SNAPSHOT.jar ru.spbstu.telematics.java.App

# Запуск тестов
mvn test
```
