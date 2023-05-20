# Immutable

* *What is it?*
* *What are the advantages?*
* *Where to use?*

### Immutable objects are objects whose internal state cannot be changed after they are created.
An example of such objects is String.
*For example:*
 ```java
String message = "Hello world!";
message.toUpperCase(); // In this case, the variable 'message' will not be displayed in uppercase.
  ```
But if we create a new string variable, for example:
```java
String upperCase = message.toUpperCase(); // It works because we are calling the modified object in the output and returning a new object in which the necessary changes have occurred.
```

##All *wrapper classes are immutable*, such as ***Integer, Double, Boolean***.

Where is it appropriate to use immutable objects?
* They can be used as keys in a HashMap.
* In multi-threading.
* Also, when we don't want to have certain side effects when working with variables.
For example, when we perform a certain action on an object but do not want changes to occur in that object, and instead, 
* we want the result of the operation to form a specific new object." 

~~~~

# Immutable

 * *Що це таке ?*
 * *які переваги ?* 
 * *де використовувати ?* 

* це обьект внутрішній стан якого ми *не можемо змінити* після того як він був створений.
### прикладом таких обьектів є String.
*наприклад :* 
```java
String message = "Hello world !";
message.toUpperCase(); // в данному випадку змінна message не буде виводитись з UpperCase
```
але якщо створити нову змінну типу String, наприклад : 
```java
String UpperCase = message.toUpperCase(); // працює це через те що в output ми викликаємо не змінений об'єкт, а повертаємо новий об'єкт в якому відбулися потрібні зміни
```

всі класи обгортки будуть Immutable,тобто Integer Double, Boolean.
## Де саме доцільно використовувати Immutable об`єкти ?
* використовувати можна в якості ключів у хешмапі
* В багатопоточності 
* А також тоді коли не хочемо мати певних сайд ефектів по роботі зі змінними 
наприклад коли виконуємо певну дію над об'єктом, але не хочемо, щоб зміни в цьому об'єкті відбулися, а хочемо, щоб результат виконання операції сформував певний новий об'єкт 