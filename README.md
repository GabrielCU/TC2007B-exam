# TC2007B-exam

## Gabriel Cordova - A01781236

### Android

1. Arquitectura General: Clean Architecture y MVVM
Model-View-ViewModel (MVVM): Separar la lógica de UI, lógica de negocio y modelos de datos.
Clean Architecture: Asegurar la independencia del código de las interfaces de usuario, frameworks y agentes externos.
2. Componentes Principales
2.1. Capa de Presentación

Views: Interfaces de usuario para mostrar los datos (Listas, gráficos, etc.).
ViewModels: Responsables de la transformación de los datos del modelo en valores que pueden ser mostrados en las Views.
2.2. Capa de Dominio

Use Cases/Interactors: Contienen la lógica de negocio específica (p.ej., análisis de tendencias de COVID-19).
Entities: Representan objetos de dominio puros (p.ej., CasoCovid).
2.3. Capa de Datos

Repositories: Puentes entre la capa de dominio y la de datos. Abstraen la fuente de los datos.
Data Sources: Fuentes de datos (APIs, Base de datos local, etc.).
Models de Datos: Modelos específicos para manejar los datos provenientes de las fuentes de datos.
