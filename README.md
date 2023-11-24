# Examen Argumentativo Práctico de Desarrollo Móvil

## Gabriel Cordova - A01781236

### Android

# Diseño de Componentes para Aplicación Móvil de Análisis de COVID-19

## Arquitectura General
- **Model-View-ViewModel (MVVM)**: Separación de lógica de UI, lógica de negocio y modelos de datos.
- **Clean Architecture**: Independencia del código de las interfaces de usuario, frameworks y agentes externos.

## Componentes Principales

### Capa de Presentación
- **Views**: Interfaces de usuario para mostrar los datos (Listas, gráficos, etc.).
- **ViewModels**: Transformación de los datos del modelo en valores para las Views.

### Capa de Dominio
- **Use Cases/Interactors**: Lógica de negocio específica (análisis de tendencias de COVID-19).
- **Entities**: Objetos de dominio puros (ej., CasoCovid).

### Capa de Datos
- **Repositories**: Puentes entre la capa de dominio y la de datos.
- **Data Sources**: Fuentes de datos (API).
- **Data Models**: Modelos para manejar los datos de las fuentes.

## CI (Integración Continua)
- **Pipelines de CI**: commits/Pull Requests.

## Documentación y Estándares
- **Documentación en el Código**: Comentarios y documentación de métodos y clases.

## Extras
- **Diagramas de Componentes/Diseño**: Documentación de interacción entre componentes.

- ![image](https://github.com/GabrielCU/TC2007B-exam/assets/70386592/d8bb1e8d-2c31-47a4-ae77-de2a10241448)

- ![image](https://github.com/GabrielCU/TC2007B-exam/assets/70386592/47e7129c-953e-47b4-a15e-e9cd59444776)



