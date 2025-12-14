# Tarea 2 PMDM 

## 📋 Descripción del Proyecto
Proyecto en Android Studio que contiene tres ejercicios independientes desarrollados en Kotlin.
Cada ejercicio demuestra diferentes conceptos y componentes fundamentales de Android.

## 🎯 Características Técnicas
- **Lenguaje**: Kotlin
- **Minimum SDK**: API 28 (Android 9.0 Pie)
- **View Binding**: Implementado en todos los ejercicios
- **Offline First**: Imágenes locales sin dependencia de internet
- **Compatibilidad**: Emulador y dispositivos reales

<img width="295" height="911" alt="image" src="https://github.com/user-attachments/assets/dd5941bd-8996-4ba3-a649-38c09599bf7b" />


## Ejercicio 1 - Conversor de Moneda (EUR ↔ USD)

📱 Vista Principal
- **Tasa de cambio**: Input para definir cuántos dólares vale 1 euro y viceversa
- **Campo Euros**: Para introducir cantidad en euros
- **Campo Dólares**: Para introducir cantidad en dólares

🔄 Funcionamiento Automático
- Sin botón CONVERTIR - La conversión se realiza en tiempo real:
- Escribes en Euros → Se calculan Dólares automáticamente
- Escribes en Dólares → Se calculan Euros automáticamente
- Cambias la tasa → Se recalcula todo automáticamente

🛡️ Protección contra Errores
- **Campos vacíos**: No causa errores, limpia el campo opuesto
- **Letras**: Se ignoran automáticamente
- **Tasa inválida**: Usa 1.08 por defecto
- **Evita loops**: Variable isConverting previene conversiones cíclicas

🏗️ Tecnologías Usadas
- ConstraintLayout para diseño responsivo
- View Binding para acceso seguro a vistas
- TextWatcher para detección de cambios en tiempo real
- Validación con try-catch para entradas inválidas

## Ejercicio 2 - Lista de Items

📱 Vista Principal
- RecyclerView con CardView personalizados mostrando restaurantes de Málaga
- Cada card muestra: Nombre, Enlace web y Foto del restaurante
- Botón flotante para añadir nuevos restaurantes

🔄 Funcionamiento Interactivo
- Click en restaurante → Muestra AlertDialog con descripción completa y email
- Swipe derecha → Elimina restaurante con Snackbar para deshacer
- Botón "Añadir Web" → Abre diálogo para agregar nuevo restaurante

🎨 Características de Diseño
- Imágenes locales → Cargadas desde res/drawable/ (sin internet)
- Cards redondeados → Bordes de 16dp para mejor apariencia
- Feedback visual → Efectos al seleccionar y eliminar
- Offline-first → Todo funciona sin conexión

🏗️ Tecnologías Usadas
- RecyclerView + ViewHolder → Lista eficiente y reciclable
- ItemTouchHelper → Gestos swipe para eliminar
- AlertDialog → Mostrar detalles sin cambiar pantalla
- Snackbar → Confirmación con acción de deshacer
- View Binding → Acceso tipo-safe a vistas

## Ejercicio 3 - Fragments para Tablet
📱 Vista Tablet
- Layout horizontal dividido en dos fragments lado a lado
- Fragment Izquierdo (40%) → Lista solo con nombres de restaurantes
- Fragment Derecho (60%) → Detalles completos del seleccionado

🔄 Funcionamiento
- Selección en lista izquierda → Actualiza automáticamente detalles derecha
- Panel superior → Muestra nombre seleccionado en grande
- Panel inferior → Muestra todos los datos: foto, enlace, descripción, email

🎨 Características Tablet
- Diseño horizontal → Optimizado para pantallas grandes
- Comunicación Fragments → A través de Activity (patrón recomendado)
- Imágenes completas → Usa centerInside para no cortar fotos
- Estado inicial → Mensaje "Selecciona un restaurante"

🦺 Arquitectura
- 2 Fragments independientes → WebsiteListFragment + WebsiteDetailFragment
- Comunicación vía interfaz → Fragment → Activity → Fragment
- Reutilización de datos → Mismos modelos y provider del Ejercicio 2
- View Binding en Fragments → Con limpieza en onDestroyView()

🏗️ Tecnologías Usadas
- Fragments + FragmentManager para UI modular
- Layout weights → División de pantalla
- RecyclerView en Fragment → Adaptado para contexto de fragment
- Manejo de lifecycle → Correcta inicialización y destrucción




















