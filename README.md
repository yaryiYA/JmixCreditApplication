#  приложение JmixCreditApplication
## Описание 

JmixCreditApplication - это  прмер банковского приложения, где его пользователями являются банковский пероснал. JmixCreditApplication реализует
базовый набор возможностей, которые предоставляют крупные банковсике приложения.

Приложение разработано с помощью плагина Jmix — набора библиотек и инструментов для ускорения разработки приложений Spring Boot. 
Jmix предоставляет множество готовых к использованию функций из "корбки". Данный инструмент
подключает расширенные системные функции, такие как комплексная защита данных и аудит, а также бизнес-функции, 
такие как создание отчетов или механизм выполнения бизнес-процессов, с помощью нескольких строк кода.

## Бизнес-функциональность
* Приложение JmixCreditApplication предоставляет возмонжность регистрации клиента.Его паспортные данные хранятся в другом приложении, тем самым обеспечивая сохранность данных.
* Существует гибкая настройка кредитной программы, предлогая широкий спеткр банковских продуктов.
* На основе данных позволяет генерировать кредитные предложения, тем самым формируя график платежей.
* При сформированном кредитном предложении генериует кредит для  клиента банка.

## Модель данных

Модель домена  JmixCreditApplication основана на модели данных обычной системы управления банка.

```mermaid
  graph TD;
      bank-->creditProgram;
      bank-->offer;
      creditProgram-->creditType;
      offer-->creditType;
      offer-->credit;
      offer-->client;
      offer-->PaymentShedule;
      user;
```

user - класс, который представляет пользователя нашей программы. Основной целью которого является подтверждение доступа к системе. 
Ссылки Userна несколько Roleобъектов (физически не в базе данных, а концептуально через RoleAssignmentEntityfrom Jmix).

* bank (class) -  является логическим отображеием банка.
* creditProgram (class) - сущность, содержащая  все основные атрибуты для оформления кредитной программы.
* creditType (enum) - представляет проодукты кредитной программы.
* offer (class) - кредитное предложение, на основе собранных данных - формируются график платежей.
* paymentShedule(class) -  создаются в оффере, отображая платежную информацию. 
* credit(class) - при усфешной генереции офера, создается кредит.
* client(class) -  сущность, необходимая для регистарции и ослеживания клиентов.

## Безопасность

В примере с JmixCreditApplication для разных групп пользователей используются разные разрешения для безопасности,чтобы пользователи могли видеть только те данные и использовать функции, которые им разрешены.

Для достижения этой цели используется подсистема Jmix. В пакете io.jmix.bookstore.security определены различные роли времени разработки.

Сотрудники обычно получают одну из следующих функциональных/ресурсных ролей:

ManagerResourceRole- базовая роль для всех сотрудников, чтобы получить базовый доступ к системе
разрешение на чтение основных данных, таких как сотрудники, банки, кредит, кредитные программы.
Разрешения пользовательского интерфейса для общих экранов пользовательского интерфейса.
FullAccessRole - Роль для административных пользователей без каких-либо ограничений.


## Дополнеине

Для полноценного запуска проекта необходимо использовать дополнительный модуль:
https://github.com/yaryiYA/passportApp
