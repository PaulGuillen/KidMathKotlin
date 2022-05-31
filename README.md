# Math4Kids

_Este proyecto es la base de un juego llamado "Piensa rápido", el cual cuenta con operaciones báscias de suma, resta, multiplicación y división, también cuenta con  niveles, los cuales pueden ser "Fácil, Intermedio, Avanzado y Experto", este juego esta enfocado para los niños de 3er y 4to año de primaria, especificamente es una relacion de un salon de clases con su grupo de alumnos, en el cual el profesor puede medir el rendimiento de sus alumnos en operaciones básicas desde una app aparte  llamada [MathKidAdmin](https://github.com/PaulGuillen/KidMathAdmin)._

## Comenzando 🚀

_Para comenzar debes tener en cuenta que esta aplicación esta solamente esta renderizada para tablets, así que procederemos a ver el especificamiento de la tablet._

```
. API level = 27.
. Resolución = 2560 x 1600.
. Nombre del dispositivo  = Nexus 10.
. Retrato = Solamente renderizado para vertical, portrait horizontal desactivado.
```

<p align="center">
 <img src="https://user-images.githubusercontent.com/43099030/170897222-8c45aca7-cbd8-4a36-a957-b161a21e5c35.png"/>
</p>

_Un poco mas de información a tener en cuenta sobre las tablets [CalidadTablets](https://developer.android.com/docs/quality-guidelines/tablet-app-quality?hl=es-419)_

_Algo importante son los constraintlayout, la división de porcentajes de pantalla [ConstraintLayout](https://www.geeksforgeeks.org/constraintlayout-in-android/)_


### Pre-requisitos 📋

_Tener instalado Android Studio, conocer sobre kotlin, tener conocimiento de firebase (auth-firestore-database-storage)_

```
. MinSdk =  23
. CompileSdk = 31
. TargetSdk = 31
. Gradle JDFK = corretto - 15 Amanzon Corretto version 15.0.2 
```

## Ejecutando los diseños ⚙️

_En esta etapa mostraremos el flujo de la app con capturas de pantalla de la misma app._

_**Onboarding App**_

_Estas son las capturas de patnalla en la cual mostramos la secuencia para llegar al incio de sesión, esta secuencia solo se mostrará una sola vez, ya que utilizamos SharedPreferences para ejecutarlo una única vez._

<p align="center">
 <img src="https://user-images.githubusercontent.com/43099030/171042820-02caab30-b5ce-48c7-9ea5-ae3d151ef528.png"/>
</p>

---

_**Registro usuario**_

_En esta parte vemos que usaremos el usuario test, en el cual esta en la parte inferior de este texto, vemos como el menú principal cuenta con varias secciones, el que vemos en la tercera posición de la imagen que es el perfil confirmando el usuario registrado con sus datos, vemos que el usuario aún no ha jugado ninguna operación por eso el puntaje es de cero._

```
. Correo =  usertest@gmail.com
. Contraseña = 123456
```

<p align="center">
 <img src="https://user-images.githubusercontent.com/43099030/171043088-eaf6a13c-971d-44b2-a16b-57671023c6a1.png"/>
</p>

---

_**Proceso Suma**_

_En esta imagen vemos que la operación suma, tiene cuatro niveles de fácil hasta a experto, el nivel seleccionado fue el intermedio en el cual tiene un contador de 60 segundos y un puntaje en la parte superior de la segunda imagen, cuando el tiempo termine se muestra el puntaje y su mejor puntaje personal con sharedpreferences, ádemas de contar un boton de ir al siguiente nivel directamente y en la última imagen vemos el resultado en firestore con sus respectivos campos._


<p align="center">
 <img src="https://user-images.githubusercontent.com/43099030/171049106-d0f2059f-c9bf-4f51-a38c-58b75e5b1d05.png"/>
</p>

---

_**Proceso Resta**_

_Como vemos es lo mismo que suma, lo diferente es en la tercera imagen que muestra como se guarda el tipo de operación con su respectivo nivel seleccionado previamente._

<p align="center">
 <img src="https://user-images.githubusercontent.com/43099030/171049918-2d988b70-892c-4c8f-9472-df4429ae668f.png"/>
</p>

---

_**Proceso Multiplicación**_

_Como vemos es lo mismo que suma y restas, lo diferente es en la tercera imagen que muestra como se guarda el tipo de operación con su respectivo nivel seleccionado previamente._

<p align="center">
 <img src="https://user-images.githubusercontent.com/43099030/171053514-61d105e9-ec98-4444-beff-281130548f23.png"/>
</p>

---

_**Sección Noticias**_

_En esta sección aplicaremos validacion en firestore, ya que es importante saber si la información existe o no, así que vemos en la segunda imagen que las noticias publicadas estan en orden del mas actual, pero que pasaría si no existe ni una noticia en la base de datos, entonces mostramos el mensaje de la tercera imagen._

<p align="center">
 <img src="https://user-images.githubusercontent.com/43099030/171055179-97eafbca-2075-4da1-abd7-19768cc88e5d.png"/>
</p>

---

_**Sección Teoría**_

_Como podemos apreciar podemos observar en las imagenes, que se dividen en segmentos, este segmento esta en desarollo ya que actualmente son datos estáticos, solo muestran teoría pero en un futuro seria cómodo mostrar datos proporcionados por el profesor, en la última imagen vemos una animación de como funciona el juego._

<p align="center">
 <img src="https://user-images.githubusercontent.com/43099030/171056945-66942d25-1aed-4215-b3c4-2b229a25b1b9.png"/>
</p>

---

_**Sección Perfil**_

_Iniciamos desde el dashboard, como estudiante tenemos que ver nuestros scores y nuestros datos personales, en las imagenes se ven que hay cuatro botones los cuales muestran el utlimo puntaje que has jugado, ádemas de ver tu correo, contraseña y la última vez que has jugado._


<p align="center">
 <img src="https://user-images.githubusercontent.com/43099030/171059650-7d0ded2d-95e1-4ea6-9f47-e0073ea31965.png"/>
</p>

---

_**Sección Ajustes**_

_Observamos que tiene información de la aplicación movil, también se observa tres opciones, la de Reocmendar a un amigo esta opción no esta habilitada ya que la aplicación aun no esta en producción osea en Play Store, los terminos de servicio y políticas son paginas que muestran los detalles de la pp.._

<p align="center">
 <img src="https://user-images.githubusercontent.com/43099030/171061912-e9f2c28c-9aee-4541-adb1-4c843fdaa837.png"/>
</p>

---

## Video 📄

_En este video se mostrará las funcionalidades._

**Video en progreso.**


## Autor ✒️

* **Paul Guillen Acuña** - *Mi Repositorio* - [PaulGuillen](https://github.com/PaulGuillen?tab=repositories)
