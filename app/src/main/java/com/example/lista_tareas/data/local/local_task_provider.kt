package com.example.lista_tareas.data.local

data class Task(
    val nombre: String,
    val fechaMaxima: String,
    val descripcion: String,
    val prioridad: String
)

object local_task_provider {
    val taskList = listOf(
        Task("Revisar informes", "12/08/2025", "Analizar los informes de ventas del último trimestre", "Alta"),
        Task("Enviar factura", "15/08/2025", "Enviar factura del proyecto al cliente", "Media"),
        Task("Plan de marketing", "20/08/2025", "Diseñar la nueva estrategia para redes sociales", "Alta"),
        Task("Capacitación interna", "25/08/2025", "Organizar sesión de capacitación sobre Kotlin", "Baja"),
        Task("Backup del sistema", "28/08/2025", "Realizar copia de seguridad completa del servidor", "Alta"),
        Task("Diseñar logo", "30/08/2025", "Crear propuesta de logo para la nueva marca", "Media"),
        Task("Actualizar base de datos", "01/09/2025", "Agregar nuevas tablas y limpiar registros obsoletos", "Alta"),
        Task("Reunión con proveedores", "03/09/2025", "Negociar precios para la próxima campaña", "Media"),
        Task("Preparar presentación", "05/09/2025", "Preparar diapositivas para la junta directiva", "Alta"),
        Task("Revisión de contrato", "07/09/2025", "Verificar cláusulas antes de firmar", "Media"),
        Task("Pruebas de app", "10/09/2025", "Realizar pruebas unitarias y de integración", "Alta"),
        Task("Entrega de informes", "12/09/2025", "Enviar reportes financieros a gerencia", "Media"),
        Task("Diseño UI", "15/09/2025", "Crear interfaz para el nuevo módulo de usuario", "Alta"),
        Task("Actualizar manual", "18/09/2025", "Modificar instrucciones del manual de uso", "Baja"),
        Task("Optimizar código", "20/09/2025", "Mejorar rendimiento de la aplicación", "Alta"),
        Task("Campaña de correo", "22/09/2025", "Enviar promoción a clientes registrados", "Media"),
        Task("Revisión SEO", "25/09/2025", "Optimizar página web para buscadores", "Baja"),
        Task("Revisión de hardware", "28/09/2025", "Verificar el estado de los equipos", "Media"),
        Task("Inventario mensual", "30/09/2025", "Actualizar inventario de productos", "Baja"),
        Task("Evaluación del equipo", "05/10/2025", "Evaluar desempeño del equipo de trabajo", "Media")
    )
}
