# Sincronización de Hora NTP

Este proyecto implementa una aplicación web desarrollada con **Java**, **Spring Boot** y **Thymeleaf**, que permite la sincronización de la hora local con servidores NTP. Además, incluye funcionalidades para seleccionar zonas horarias, sincronizar la hora, y mantener un historial de sincronizaciones realizadas.

## Características
- Visualización de la hora local en vivo.
- Selección de zona horaria.
- Sincronización de hora con servidores NTP.
- Historial de sincronizaciones.
- Mensajes de estado claros y manejo de errores.

## Tecnologías Utilizadas
- **Java 17**
- **Spring Boot**
- **Thymeleaf** para las vistas.
- **Bootstrap** para el diseño responsivo.
- **NTP Client** para la sincronización de hora.

## Requisitos Previos
- Java 17 o superior instalado.
- Apache Maven instalado.
- Un servidor local o entorno de desarrollo compatible con Spring Boot.

## Instalación y Ejecución
1. Clona este repositorio:
   ```bash
   git clone https://github.com/ALPullaguariSW/SincroNTP.git
   ```

2. Navega al directorio del proyecto:
   ```bash
   cd SincroNTP
   ```

3. Compila y ejecuta el proyecto con Maven:
   ```bash
   mvn spring-boot:run
   ```

4. Accede a la aplicación desde tu navegador en:
   ```
   http://localhost:8080
   ```

## Uso
1. La aplicación mostrará la hora local en tiempo real.
2. Selecciona una zona horaria de la lista desplegable.
3. Haz clic en el botón **Sincronizar Hora** para sincronizar la hora con un servidor NTP.
4. Revisa el historial de sincronizaciones en la tabla inferior.

## Configuración Adicional
Si deseas personalizar las zonas horarias disponibles, puedes editar el archivo correspondiente en el código fuente (por ejemplo, `application.properties` o una clase de configuración).

## Capturas de Pantalla
![text](<assets/Screenshot 2025-01-22 205623.png>) ![text](<assets/Screenshot 2025-01-22 205601.png>) ![text](<assets/Screenshot 2025-01-22 205543.png>) ![text](<assets/Screenshot 2025-01-22 205508.png>) ![text](<assets/Screenshot 2025-01-22 185044.png>) ![text](<assets/Screenshot 2025-01-22 184328.png>)


## Contribuciones
Las contribuciones son bienvenidas. Si encuentras algún problema o tienes una sugerencia, abre un **issue** o envía un **pull request**.

## Licencia
Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo [LICENSE](LICENSE) para obtener más detalles.

---

**Autor:** Axel Lenin Pullaguari Cedeño
