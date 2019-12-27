# EcoGranja
## Introduccion
Esta aplicación se corresponde con el proyecto desarrolado para la asignatura **Bases de Datos II** del Grado de Ingeniería
Infromática Ofertado por la Universidad de Santiago de Compostela. El objetivo fundamental de dicho proyecto radicaba en la 
creación de una aplicación que permitiera poner en contacto a los pequeños productores de productos agrícolas y ganaderos
con los consumidores finales sin la necesidad de intermediados, para ello se habrán empleado **Java 8** y la base de datos 
**PostgreSQL** en su versión **8.4**, almacenandose aquí los datos que serán necesarios en la interacción. Otras tecnologías empleadas
serán **JAVA Swing** para el entorno gráfico de interacción y **JDBC**, para la conexión con la base de datos.

Esta apliación se desarrollo en su estructura general de forma común, así como la interfaz dispuesta. a nivel funcional, en esta parte
se habrá implementado la consulta de productos, las devoluciones de productos, la gestión de perfiles, dar de alta granjas, 
recuperar los pedidos efectuados y operaciones relativas al loggin de usuarios, combinadas con la función gestora de una serie
de administradores

La aplicación se concibe como una aplicación de escritorio que podrían usar tanto clientes como granejeros como administradores
orientada unicamente a procesos relativos a la compra o la consulta de información. Con lo cual para acceder a toda la información
ofertada se ofrece una serie de servicios de login y resgistro para el acceso a dicha tienda, donde se acceder a los productos y
y pedidos y efectuar procesos de devolución y compra, debido a que la funcionalidad de compra fue realizada por otro
grupo de implementación dispuesto en la materia.

## ¿Como se efctúa la conexion con la base de datos?
La base de datos tomará el nombre de **EcoGranja** y la información asociada a la conexión se encontrará recogida en **baseDatos.properties**,
dentro de la carpeta raíz del proyecto que será la de nombre **EcoGranja/**. El proceso de conexion involucrará al gesto mencionado
accedido desde java empleando **JDBC**.

## ¿Como se estructura la informacion almacenada?
La infromación almacenada en la base de datos se estructurará en una serie de tablas las cuales se indicarán en el script de creación de nombre
**script_creacion.sql**, incluyendose en el script **script_insercion.sql** los datos necesarios para efectuar la prueba de la aplicación.
En este sentido, se distinguirán tablas para cada uno de los diferentes tipos de usuarios, productos, métodos de pago y pedidos.

## ¿Como acceder a la plataforma de compra?
Para acceder a la plataforma de compra, se requerirá en un princpio, en una ventana de inicio, que el usuario ingrese su **nombre** y **password**.
Este usuario, puede ser administrador o, en el caso de ser cliente, puede también ser productor y consumidor, es decir, cliente. Esto
conllevará la restricción de no poder adquirir sus propios productos.

Dichas comprobaciones se llevarán a acbo con los datos obtenidos de la base de datos, donde en las difernetes tablas de usuarios
se comprobará si la información coincide, siempre con la **información relativa a claves cifrada**.

## ¿ Que puede realizar cada perfil?
Se podrán realizar difernetes acciones para los diferentes perfiles de usuario mencionados anteriormente, presentado ciertas similitudes entre cliente y granjero
* ### Cliente
El cliente podrá acceder a un catalogo de productos en el que podrá consultar los prouductos disponibles, los cuales puede haber comprado.
En este caso ya en relación con la apliacicón mostrada, se podrá consultar los pedidos efectuados y en base a estos, solicitar la devolución
determinados artículos que componen el pedido efectuado. A nivel de datos, se podrán modificar , en la sección de perfil los datos asociados
al mismo.
* ### Granjero
Los granjeros como tal podrán dar de alta granjas nuevas, las cuales serán las que oferten los productos. En esta parte los granjeros
también podrán eiminar o modificar los datos de las granjas así como su perfil de granjero.
* ### Administrador
Será el personal interno de la aplicación encargado de regular los procesos de devolucion, los cuales podrán ser rechazados o aceptados
en función de su criterio. Loc ual se habrá realizado así para que se gestione de una manera más correcta dicho proceso en la base de datos
## ¿Como se ejecuta la aplicación?
El proyecto fue desarrollado en un IDE como es **NetBeans8.2**. Peroen su porceso de compliación se hbará creado un .jar el cual al ser
ser ejecutado, contiene la apliación. Siendo necsario para su prueba tener instalado PostgreSQL y creadas las bases con los scripts indicados.
> java -jar Proyecto_BD2.jar

Será necesario, colocar el acrhivo properties en el mismo directorio que el jar, al igual que el archivo .jar relativo al conector de PostgreSQL
## Autores
* [César Díaz Parga](https://github.com/cesdp)
* [David Landín Calvo](https://github.com/david-lc)





