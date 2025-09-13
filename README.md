# ✈️ FlightSearch 
🔥 Proyecto creado como ejercicio de aprendizaje en Java.

**FlightSearch** es una aplicación de consola escrita en **Java** que permite buscar vuelos entre ciudades.  
El programa utiliza una lista de conexiones aéreas predefinidas y determina si existe:

- Un **vuelo directo** entre origen y destino.  
- Un **vuelo con una escala** (origen → escala → destino).  

Está pensado como ejercicio de práctica en Java para trabajar con arrays, bucles y manipulación de cadenas.

---

## 📖 Enunciado del ejercicio

Se pide implementar un programa que:

1. Pida al usuario introducir una ciudad de **origen** y una de **destino**.  
2. Busque en una lista de aeropuertos y conexiones si existe un vuelo directo.  
3. Si no existe vuelo directo, busque si existe alguna **escala intermedia** que permita llegar al destino.  
4. Muestre el resultado en consola (vuelo directo, vuelo con escala o sin vuelos disponibles).

---

## 🛠️ Problema a resolver

En la vida real, no siempre existen vuelos directos entre dos ciudades.  
El programa intenta **simular un motor básico de búsqueda de vuelos**, capaz de responder preguntas como:

- ¿Puedo volar directo de **Barcelona** a **Múnich**?  
- Si no, ¿puedo hacerlo con una escala en otra ciudad (ej. Barcelona → París → Múnich)?  

Esto representa un problema típico de **búsqueda de rutas** en grafos, simplificado en forma de arrays.

---

## ▶️ Ejemplo de uso

### Entrada del usuario
Introduce tu ciudad de origen: Barcelona  
Introduce tu ciudad destino: Munich  

### Ejecución del programa
Introduce tu ciudad de origen: Madrid
Introduce tu ciudad destino: Barcelona
Buscando vuelos MADRID >> BARCELONA...
Encontrado vuelo directo de MADRID a BARCELONA.

---

### Otro ejemplo
Introduce tu ciudad de origen: Bilbao
Introduce tu ciudad destino: Múnich

Buscando vuelos BILBAO >> MUNICH...
Sin vuelos directos, buscando escalas...
Vuelo con escala encontrado: BILBAO >> BARCELONA >> MUNICH  

---

### Caso sin vuelos disponibles
Introduce tu ciudad de origen: Murcia
Introduce tu ciudad destino: Pionyang
Buscando vuelos MURCIA >> PIONYANG...
Sin vuelos directos, buscando escalas...
Lo sentimos, no hay vuelos disponibles con conexión directa o con una sola escala 

---

## 🚀 Cómo ejecutar

1. Compila el proyecto en tu IDE (ej. Eclipse o IntelliJ).  
2. Exporta el proyecto como `.jar`.  
3. Ejecuta desde terminal: 
 ```bash
java -jar flightsearch.jar
```

---

## 💡 Posibles mejoras

Este proyecto se puede extender de muchas formas:

- ✅ **Múltiples escalas**: implementar búsqueda con número indefinido de escalas (BFS, DFS, Dijkstra).  
- ✅ **Uso de grafos**: modelar los aeropuertos y conexiones como un grafo dirigido en lugar de arrays estáticos.  
- ✅ **Mostrar todas las rutas posibles**: no solo la primera encontrada, sino también rutas alternativas.  
- ✅ **Interfaz gráfica**: implementar una UI con **Swing** o **JavaFX**, o incluso versión web.  
- ✅ **Persistencia de datos**: leer y guardar conexiones en **JSON**, **CSV** o una **base de datos**.  
- ✅ **Datos reales**: usar un dataset de aeropuertos y rutas reales (ej. OpenFlights).  
- ✅ **Optimización de rutas**: elegir vuelos en función de distancia, tiempo o precio (no solo existencia).  
- ✅ **Tests automáticos**: añadir pruebas unitarias con JUnit para validar los métodos de búsqueda.  
- ✅ **Internacionalización**: permitir entrada y salida en distintos idiomas.  




