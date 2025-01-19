<p align="center">
  <img src="https://upload.wikimedia.org/wikipedia/commons/c/c1/Logo_ULPGC_%282019%29.svg" alt="ULPGC Logo" width="200" />
</p>

# Bounce Ball Simulator

Este proyecto forma parte de la asignatura **Ingeniería del Software II** de la **Universidad de Las Palmas de Gran Canaria (ULPGC)**. **Bounce Ball Simulator** es una simulación interactiva en la que varias bolas caen bajo la influencia de la gravedad y rebotan al llegar al suelo. Este proyecto utiliza la arquitectura **Modelo-Vista-Controlador (MVC)** para separar la lógica de la simulación, la representación gráfica y el control de la interacción, lo que mejora la escalabilidad, la mantenibilidad y la reutilización del código. 
El proyecto también hace uso de **principios de diseño orientado a objetos**, como la **encapsulación**, el **polimorfismo** y la **abstracción**, para asegurar un diseño limpio y modular.

## Introducción

Este proyecto tiene como objetivo simular el movimiento de bolas bajo la influencia de la gravedad, con un comportamiento de rebote elástico cuando las bolas tocan el suelo. La simulación se ejecuta en una ventana gráfica utilizando **Java Swing** para la representación visual.

Las bolas se definen con propiedades como el **radio** y el **coeficiente de restitución** (elasticidad). Cada bola cae desde una altura inicial y rebota al llegar al suelo. La simulación se actualiza a intervalos regulares, lo que permite visualizar el movimiento en tiempo real.

## Estructura del Proyecto

El proyecto sigue una arquitectura **Modelo-Vista-Controlador (MVC)** para separar claramente las diferentes responsabilidades del sistema.

- **Modelo** (`model`): Contiene la lógica de datos de la simulación, incluyendo la clase `Ball` y `BallSimulation`.
- **Vista** (`view`): Se encarga de la representación visual de las bolas y el suelo mediante la clase `BallView`.
- **Controlador** (`control`): La clase `BallController` maneja la lógica de la simulación y la interacción entre el modelo y la vista.
- **Main** (`main`): Contiene el punto de entrada principal de la aplicación.

## Patrones de Diseño Utilizados

- **Factory Method**: Utilizado en la clase `Ball` para crear instancias de bolas con diferentes propiedades de forma simplificada.
  - Método: `Ball.create(radius, restitution)`.

- **Observer**: Aunque no se implementa explícitamente, el patrón **Observer** se utiliza implícitamente en la vista mediante la actualización de las posiciones de las bolas en la pantalla cada vez que se modifica el modelo.

- **Encapsulación**: Cada clase encapsula sus propiedades y comportamientos, proporcionando métodos públicos para interactuar con sus datos sin exponer detalles internos.

## Arquitectura Utilizada

- **Modelo-Vista-Controlador (MVC)**: Este arquitectura se utiliza para separar la lógica del negocio (Modelo), la interfaz gráfica (Vista) y el control de la simulación (Controlador). Esto permite que cada componente pueda ser desarrollado, probado y mantenido de forma independiente.
  - **Modelo**: Gestiona el estado y las propiedades de las bolas.
  - **Vista**: Actualiza y muestra el estado del modelo en la interfaz gráfica.
  - **Controlador**: Orquesta el flujo de datos y actualiza tanto el modelo como la vista.

---
Este proyecto fue desarrollado como parte de los trabajos opcionales de la asignatura **Ingeniería del Software II** en la **ULPGC**.
**Según las directrices de clase, esta incompleto, arrastrar las pelotas NO FUNCIONA**
