document.getElementById('sync-btn').addEventListener('click', async function() {
    const timezone = document.getElementById('timezone-select').value;

    try {
        const response = await fetch(`/sync-time?timezone=${timezone}`);
        const data = await response.json();

        // Verificar si la respuesta está vacía o no contiene la hora sincronizada
        if (!data || !data.syncedTime || data.syncedTime === "Error") {
            document.getElementById('status-text').innerText = 'Error al sincronizar la hora. ' + (data.syncedTime || 'No se obtuvo respuesta válida.');
            return;
        }

        // Mostrar la hora local y sincronizada
        document.getElementById('local-time').innerText = data.localTime;
        document.getElementById('synced-time').innerText = data.syncedTime;

        // Actualizar el historial
        addToHistory(data);
    } catch (error) {
        console.error('Error:', error);
        document.getElementById('status-text').innerText = 'Error al sincronizar la hora: ' + error.message;
    }
});
function updateLocalTime() {
    const localTime = new Date().toLocaleString(); // Obtiene la hora local actual
    document.getElementById('local-time').innerText = localTime;
}


setInterval(updateLocalTime, 1000);
function addToHistory(data) {
    const tbody = document.querySelector('#history-table tbody');
    const row = document.createElement('tr');
    row.innerHTML = `
        <td>${data.timezone}</td>
        <td>${data.localTime}</td>
        <td>${data.syncedTime}</td>
    `;
    tbody.appendChild(row);
}
