********************************************************************
*****************	APP BasketList para Android	   *****************
********************************************************************

Instrucciones de Uso del APK
- Instalar el apk en un dispositivo android o emulador.
- Una vez instalado el APK, iniciamos y esperamos la pantalla de inicio.

1. Pantalla de Inicio (MainActivity): la pantalla de inicio contiene una imagen y dos botones. Cada boton representa a un tipo de usuario. 
Si hacemos click en el boton Sandra vamos a la pantalla principal del perfil de Sandra(MainSandra).

2. Pantallas principales de los perfiles Sandra y MainNatalia

	2.1 Pantalla principal del perfil Sandra (MainSandra): en esta pantalla se muestran las opciones para este usuario. Las opciones vienen definidas en 3 botones.
		-.Crear lista: nos lleva a una nueva actividad "Productos" donde crearemos nuevas listas
		-.Ver lista: nos lleva a una nueva actividad "ListaActivity" listado de las diferentes listas disponibles
		-.Crear oferta: nos lleva a una nueva actividad "OfertasActivity" donde crearemos nuevas ofertas
		-.En el action bar esta disponible la opcion de settings, no implementada, que deberia permitir hacer cambios en el perfil (como colores e imagen de perfil). Ademas podremos volver al inicio con el boton home (la casita) que tambien esta presente.

	2.2 Pantalla principal del perfil Natalia (MainNatalia): en esta pantalla solo hay una opcion con un boton que nos permitira ver el listado de las listas ya disponibles (igual al boton Ver lista del MainSandra), modificarlas, pero en ningun caso hay otras opciones como crear nuevas listas o crear ofertas.
		-.En el action bar esta disponible la opcion de settings, no implementada, que deberia permitir hacer cambios en el perfil (como colores e imagen de perfil). Ademas podremos volver al inicio con el boton home (la casita) que tambien esta presente.

3. Actividades disponibles desde Main_Sandra

	3.1 Crear nuevas listas (Productos): este apartado finalmente no fue implementado, la idea era presentar todos los productos disponibles separados por su clasificacion (frescos, bebidas, ect).
		-.En el action bar esta disponible la opcion de settings, no implementada, que deberia permitir hacer cambios en la presentacion de las listas (como colores). Ademas podremos volver al inicio con la imagen home (la casita) o volver atras con la imagen de la flecha (<-). Aqui finaliza este recorrido.

	3.2 Mostrar listas (ListaActivity): actividad que muestra diversos botones que se corresponde a las diferentes listas disponibles. Con el nombre del boton cargaremos un listview diferente para cada caso, reutilizando continuamente esta actividad (ListaView).
		-. Al igual que otras activities, en el action bar tenemos la posibilidad de ir atras o al inicio.
		-.Esta actividad tambien esta disponible desde Main_Natalia.

	3.3 Pantalla de crear ofertas (OfertasActivity): aqui podremos crear una oferta, dandole un nombre en el editText, eligiendo el supermercado (que lo usamos de nombre de la lista) y una imagen que nos permite tener toda la informacion de la oferta. La guardaremos dando en añadir y cancelaremos la accion con el boton cancelar que hace un reset. Al igual que otras activities, en el action bar tenemos la posibilidad de ir atras o al inicio. Aqui finaliza este recorrido.
 
4. Pantalla de la lista de los productos (ListaView): en esta pantalla se carga un listview con los productos que seran diferentes segun el boton que se pulse en el "ListaActivity". Hemos hecho que cada elemento del listview sea clicable de manera que cambie de estado. 
Los estados disponibles es hace falta (rojo), no hace falta (gris), ya comprado (verde). Se deberia poder hacer un reset y poner todos los productos en gris pero no fue implemntado. Si se cierra la aplicacion, se va a atras o al inicio. Se guarda el nuevo estado de cada producto en la base de datos, asi no se pierde el estado de toda la lista. Aqui tambien le damos vida al action bar, con las opciones de volver atras e ir al inicio. Aqui finalizamos la vizualizacion de la app.


Instrucciones del codigo de la app:
- Primeros nos situaremos en la carpeta main que se encuentra en por ejemplo
C:\ListaSuperApp\app\src\main
- Dentro de esta carpeta encontramos el documento AndroidMAnifest.xml, donde declaramos 
las diferentes activities de nuestra app. En nuestro caso la principal es
MainActivity y hay varias secundarias como ListaView, OfertasActivity, ListaActivity, MainSandra o MainNatalia.
Si nos situamos a continuacion en C:\ListaSuperApp\app\src\main\java\com\example\listasuperapp
podremos vizualizar los diferentes archivos java.
	1.MainActivity.java
	2.ListaView.java
	3.ItemAdapter.java
	4.MyItem.java
	5.MainSandra.java
	6.ListaActivity.java
	7.MainNatalia.java
	8.OfertasActivity.java
	9.Productos.java


- Ahora situados en C:\ListaSuperApp\app\src\main\res encontraremos las imagenes con diversas medidas dentro de las carpetas mipmap* o drawable*. Ademas en la carpeta layout se encuentran los archivos xml que definen como se vera el contenido de las pantallas.
	1.activity_lista_super
	2.empty_text_view
	3.inicial
	4.lista_view
	5.activity_productos
	6.add_ofertas
	7.listas
	8.listas_super
	9.main_natalia
	10.main_sandra
-Otra carpeta ha destacar es la carpeta values que contiene los archivos xml que definen los 
colores, string, dimensiones y estilos a utilizar en la app.
 	1. colors: definimos los principales colores de las actividades y los botones
 	2. dimens: dimensiones basicas, utlizadas por defecto.
 	3. strings: los textos de los botones, textview y demas objetos se pueden definir aqui.
 	4. styles: se define el tema de la app con AppTheme y EstiloButton para los botones.
- La carpeta menu: esta carpeta contiene unoss menu que utilizaremos para los action bar.

Nota: dentro de cada archivo nombrado se encuentran una serie de comentarios para facilitar
entender el codigo.



